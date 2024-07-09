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
import org.example.User;

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

    public void insertVideo(User user)
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

    public void insertComment(User user)
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
}
