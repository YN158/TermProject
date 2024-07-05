package org.example.NetWork;

import java.io.*;
import java.net.*;

import com.mongodb.ConnectionString;
import com.mongodb.MongoClientSettings;
import com.mongodb.MongoException;
import com.mongodb.ServerApi;
import com.mongodb.ServerApiVersion;
import com.mongodb.client.MongoClient;
import com.mongodb.client.MongoClients;
import com.mongodb.client.MongoDatabase;
import org.bson.Document;

public class Server implements Runnable {
    public static final int port = 9090;

    //mongodb password: 691NfDk7mwCNeTJt
    //mangodb username: bluemustardsauce

    public static void main(String[] args) {
        String connectionString = "mongodb+srv://bluemustardsauce:691NfDk7mwCNeTJt@termproject.xdwhar0.mongodb.net/?appName=TermProject";
        ServerApi serverApi = ServerApi.builder()
                .version(ServerApiVersion.V1)
                .build();
        MongoClientSettings settings = MongoClientSettings.builder()
                .applyConnectionString(new ConnectionString(connectionString))
                .serverApi(serverApi)
                .build();
        // Create a new client and connect to the server
        try (MongoClient mongoClient = MongoClients.create(settings)) {
            try {
                // Send a ping to confirm a successful connection
                MongoDatabase database = mongoClient.getDatabase("admin");
                database.runCommand(new Document("ping", 1));
                System.out.println("Pinged your deployment. You successfully connected to MongoDB!");
            } catch (MongoException e) {
                e.printStackTrace();
            }
        }
    }

    public void run() {
        try{
            ServerSocket server = new ServerSocket(port);

            while (true)
            {
                final Socket client = server.accept();
                new Thread() {
                    public void run() {
                        try{
                            ObjectInputStream in =
                                    new ObjectInputStream( client.getInputStream() );
                            String msg = (String) in.readObject();
                            System.out.println(msg + " nn");
                            if (msg.equals("Hello !"))
                            {
                                System.out.println("baaaaa");
                            }
                        }
                        catch(Exception e){System.err.println(e);}

                    }}.start();
            }
        }
        catch(IOException e){System.err.println(e);}
    }

}
