package org.example.NetWork;

import com.mongodb.client.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;
import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoDatabase;
import org.example.Comment;
import org.example.User;
import org.example.Video;
import java.util.ArrayList;

public class MongoDBRepository
{
    private final MongoDatabase database;

    public MongoDBRepository()
    {
        this.database = MongoDBConnectionManager.getDatabase();
    }

    public void insertUser(User user)
    {
        MongoCollection<Document> usersCollection = database.getCollection("Users");
        Document userDocument = new Document()
                .append("ID", user.GetID())
                .append("email", user.GetEmail())
                .append("password", user.GetPassword())
                .append("videoIDs", user.GetVidIDs())
                .append("subscriberIDs", user.GetSubersIDs())
                .append("subscriptionIDs", user.GetSubsIDs())
                .append("icon", user.getIcon());

        usersCollection.insertOne(userDocument);
    }

    public void insertVideo(Video video)
    {
        MongoCollection<Document> usersCollection = database.getCollection("Videos");
        Document userDocument = new Document()
                .append("ID", video.GetID())
                .append("channelID", video.Getuploader())
                .append("videoPath", video.GetVideoPath())
                .append("title", video.GetTitle())
                .append("description", video.GetDescription())
                .append("commentIDs", video.GetCommentIDs())
                .append("viewerIDs", video.GetViewerIDs())
                .append("likes", video.GetLikes())
                .append("dislike", video.GetDislikes())
                .append("thumbnail", video.GetThumbnail());

        usersCollection.insertOne(userDocument);
    }

    public void insertComment(Comment comment)
    {
        MongoCollection<Document> usersCollection = database.getCollection("Comments");
        Document userDocument = new Document()
                .append("ID", comment.GetID())
                .append("videoID", comment.GetVideoID())
                .append("userID", comment.GetUserID())
                .append("body", comment.GetBody())
                .append("date", comment.GetDate());

        usersCollection.insertOne(userDocument);
    }

    public ArrayList<User> getAllUsers()
    {
        MongoCollection<User> collection = database.getCollection("Users", User.class);

        ArrayList<User> users = new ArrayList<>();
        MongoCursor<User> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
                users.add(cursor.next());
            }
        } finally {
            cursor.close();
        }

        return users;
    }

    public ArrayList<Comment> getAllComments()
    {
        MongoCollection<Comment> collection = database.getCollection("Comments", Comment.class);

        ArrayList<Comment> comments = new ArrayList<>();
        MongoCursor<Comment> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
                comments.add(cursor.next());
            }
        } finally {
            cursor.close();
        }

        return comments;
    }

    public ArrayList<Video> getAllVideos()
    {
        MongoCollection<Video> collection = database.getCollection("Videos", Video.class);

        ArrayList<Video> videos = new ArrayList<>();
        MongoCursor<Video> cursor = collection.find().iterator();

        try {
            while (cursor.hasNext()) {
                videos.add(cursor.next());
            }
        } finally {
            cursor.close();
        }

        return videos;
    }
}

