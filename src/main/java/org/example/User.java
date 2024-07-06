package org.example;

import java.awt.*;
import java.util.ArrayList;

public class User implements Cloneable
{
    String ID;                                       //this also functions as the UserName of the user
    String email;                                    //this is a placeholder
    String password;                                 //this is a placeholder
    ArrayList<String> videoIDs;                      //to store the IDs of the videos belonging to your channel
    ArrayList<String> subscriberIDs;                 //to store the IDs of channels/accounts which are subscribed to you
    ArrayList<String> subscriptionIDs;               //to store the IDs of the channels/accounts you are subscribed to
    Image icon;                                      //this is a placeholder and will be replaced by the correct format/variable type


    public User(String id, String em, String pw, ArrayList<String> videoids, ArrayList<String> subs, ArrayList<String> subers)
    {
        ID = id;
        email = em;
        password = pw;
        videoIDs = videoids;
        subscriptionIDs = subs;
        subscriberIDs = subers;
    }

    public String GetID()
    {
        return ID;
    }

    public String GetPassword()
    {
        return password;
    }
    public String GetEmail()
    {
        return email;
    }

    public ArrayList<String> GetVidIDs()
    {
        return videoIDs;
    }

    public ArrayList<String> GetSubsIDs()
    {
        return subscriptionIDs;
    }

    public ArrayList<String> GetSubersIDs()
    {
        return subscriberIDs;
    }

    public void addVideo(String vidID)
    {
        videoIDs.add(vidID);
    }

    public void addSubscription(String subscribedChannelID)
    {
        subscriptionIDs.add(subscribedChannelID);
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

    @Override
    public User clone() {
        try {
            return (User) super.clone();
        } catch (CloneNotSupportedException e) {
            throw new RuntimeException(e);
        }
    }
}
