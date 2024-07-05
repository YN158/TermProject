package org.example.NetWork;

import com.mongodb.BasicDBObject;
import com.mongodb.DBObject;
import com.mongodb.DBCollection;
import com.mongodb.client.MongoClient;
import org.example.Comment;
import org.example.User;
import org.example.Video;

public class MongoDb
{
    public static MongoClient mongoClient;
    //public static DB database
    //public static DBCollection test;
    public static void main(String[] args)
    {
        mongoClient = new MongoClient(new MongoClient("mongodb+srv://bluemustardsauce:691NfDk7mwCNeTJt@termproject.xdwhar0.mongodb.net/?retryWrites=true&w=majority&appName=TermProject"));
        database = mongoClient.getdb("Mongodb");
        test = database.getCollection("test");
        DBObject obj = new BasicDBOject();

    }
    public static BasicDBObject convert (User user)
    {
        return new BasicDBObject("ID" , user.getID())
                .append("email" , user.getEmail())
                .append("password" , user.getPassword())
                .append("videoIDs" , user.getvideoIDs())
                .append("subscriptionIDs" , user.getsubscriptionIDs())
                .append("subscriberIDs" , user.getsubscriberIDs()).append("icon" , user.getIcon());
    }
    public static BasicDBObject convert (Video video)
    {
        return new BasicDBObject("ID" , video.getID())
                .append("channelId" , video.getChannelID())
                .append("title" , video.getTitle())
                .append("describtion" , video.getDescription())
                .append("commentIDs" , video.getCommentIDs())
                .append("viewerIDs" , video.getViewerIDs()).append("likes" , video.getLikes())
                .append("dislikes" , video.getDislike()).append("thumbnail" , video.getThumbnail());
    }
    public static BasicDBObject convert (Comment comment)
    {
        return new BasicDBObject("ID" , comment.getID())
                .append("videoID" , comment.getVideoID())
                .append("body" , comment.getBody())
                .append("userID" , comment.getUserID())
                .append("date" , comment.getDate());

    }
}