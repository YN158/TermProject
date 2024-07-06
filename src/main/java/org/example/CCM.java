package org.example;

import org.example.panels.IDgenerator;

import java.util.ArrayList;

public class CCM                                     //CCM of Central Class Manager is a class designed to hold the data and information required during the runtime
{
    public User activeUser;                                 //used to store the data of the user which is currently active
    public Video activeVideo;                               //used to store the data of the video which is currently active
    public ArrayList<String> videoID;                       //used to store the IDs of multiple videos if ever needed
    public ArrayList<String> userID;                        //used to store the IDs of multiple users if ever needed
    public ArrayList<String> commentID;                     //used to store the IDs of multiple comments if ever needed


    public CCM()
    {

    }
}