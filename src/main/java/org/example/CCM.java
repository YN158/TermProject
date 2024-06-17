package org.example;

import java.util.ArrayList;

public class CCM                                     //CCM of Central Class Manager is a class designed to hold the data and information required during the runtime
{
    User activeUser;                                 //used to store the data of the user which is currently active
    Video activeVideo;                               //used to store the data of the video which is currently active
    ArrayList<String> videoID;                       //used to store the IDs of multiple videos if ever needed
    ArrayList<String> userID;                        //used to store the IDs of multiple users if ever needed


    public CCM()
    {

    }
}