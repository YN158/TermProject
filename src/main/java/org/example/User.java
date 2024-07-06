package org.example;

import java.awt.*;
import java.util.ArrayList;

public class User
{
    String ID;                                       //this also functions as the UserName of the user
    String email;                                    //this is a placeholder
    String password;                                 //this is a placeholder
    ArrayList<String> videoIDs;                      //to store the IDs of the videos belonging to your channel
    ArrayList<String> subscriberIDs;                 //to store the IDs of channels/accounts which are subscribed to you
    ArrayList<String> subscriptionIDs;               //to store the IDs of the channels/accounts you are subscribed to
    Image icon;                                      //this is a placeholder and will be replaced by the correct format/variable type


    public User(String id, String em, String pw)
    {
        ID = id;
        email = em;
        password = pw;
        videoIDs = new ArrayList<String>();
        subscriptionIDs = new ArrayList<String>();
        subscriberIDs = new ArrayList<String>();
    }

    public String GetID()
    {
        return ID;
    }

    public void addVideo(String vidID)
    {
        videoIDs.add(vidID);
    }

    public void print()
    {
        System.out.println(videoIDs);
    }

    public void SetToDefault()
    {
        ID = "";
        email = "";
        password = "";
        videoIDs = null;
        subscriberIDs = null;
        subscriptionIDs = null;
        icon = null;
    }
}
