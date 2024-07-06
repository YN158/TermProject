package org.example;

import org.example.panels.IDgenerator;
import org.example.panels.VideoComponent;

import java.util.ArrayList;

public class CCM                                     //CCM of Central Class Manager is a class designed to hold the data and information required during the runtime
{
    public static User activeUser;                                 //used to store the data of the user which is currently active
    public static Video activeVideo;                               //used to store the data of the video which is currently active
    public static ArrayList<String> videoID;                       //used to store the IDs of multiple videos if ever needed
    public static ArrayList<String> userID;                        //used to store the IDs of multiple users if ever needed
    public static ArrayList<String> commentID;                     //used to store the IDs of multiple comments if ever needed

    public static ArrayList<Video> videos;
    public static ArrayList<User> users;
    public static ArrayList<Comment> comments;

    public CCM()
    {

    }
}