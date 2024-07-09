package org.example.NetWork;

import com.mongodb.client.MongoClient;
import com.mongodb.client.*;
import com.mongodb.client.model.Filters;
import com.mongodb.client.model.Updates;
import org.bson.Document;

public class MongoDb {

    private static MongoClient mongoClient;
    private static MongoDatabase database;

    public static void connect(String connectionString)
    {
        MongoClient mongoClient = MongoClients.create(connectionString);
        database = mongoClient.getDatabase("youtube");
    }

    public static void createCollections() {
        database.createCollection("users");
        database.createCollection("videos");
        database.createCollection("comments");
    }

    // Function to update a user document in the users collection
    public static void updateUser(String userId, String fieldName, String newValue) {
        MongoCollection<Document> usersCollection = database.getCollection("users");
        usersCollection.updateOne(
                Filters.eq("ID", userId),
                Updates.set(fieldName, newValue)
        );
    }

    // Function to update a video document in the videos collection
    public static void updateVideo(String videoId, String fieldName, String newValue) {
        MongoCollection<Document> videosCollection = database.getCollection("videos");
        videosCollection.updateOne(
                Filters.eq("ID", videoId),
                Updates.set(fieldName, newValue)
        );
    }

    // Function to update a comment document in the comments collection
    public static void updateComment(String commentId, String fieldName, String newValue) {
        MongoCollection<Document> commentsCollection = database.getCollection("comments");
        commentsCollection.updateOne(
                Filters.eq("ID", commentId),
                Updates.set(fieldName, newValue)
        );
    }
    // Function to retrieve and print all documents from the users collection
    public static void getAllUsers() {
        MongoCollection<Document> usersCollection = database.getCollection("users");
        FindIterable<Document> users = usersCollection.find();
        for (Document user : users) {
            System.out.println("User: " + user);
        }
    }

    // Function to retrieve and print all documents from the videos collection
    public static void getAllVideos() {
        MongoCollection<Document> videosCollection = database.getCollection("videos");
        FindIterable<Document> videos = videosCollection.find();
        for (Document video : videos) {
            System.out.println("Video: " + video);
        }
    }

    // Function to retrieve and print all documents from the comments collection
    public static void getAllComments() {
        MongoCollection<Document> commentsCollection = database.getCollection("comments");
        FindIterable<Document> comments = commentsCollection.find();
        for (Document comment : comments) {
            System.out.println("Comment: " + comment);
        }
    }

    public static void close() {
        if (mongoClient != null) {
            mongoClient.close();
        }
    }

    public static void main(String[] args)
    {
        String connectionString = "mongodb+srv://bluemustardsauce:<691NfDk7mwCNeTJt>@termproject.xdwhar0.mongodb.net/?retryWrites=true&w=majority&appName=TermProject";

        connect(connectionString);
        createCollections();

        close();
    }
}