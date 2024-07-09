package org.example.NetWork;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;

public class MongoDBConnectionManager
{
    private static final String CONNECTION_STRING = "mongodb+srv://bluemustardsauce:691NfDk7mwCNeTJt@termproject.xdwhar0.mongodb.net/?retryWrites=true&w=majority&appName=TermProject?tls=true";

    public static MongoDatabase getDatabase() {
        ConnectionString connectionString = new ConnectionString(CONNECTION_STRING);
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(connectionString)
                .build();

        MongoClient mongoClient = MongoClients.create(settings);
        return mongoClient.getDatabase("TermProject");
    }
}