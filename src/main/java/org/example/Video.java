package org.example;

import java.util.ArrayList;

public class Video
{
    String ID;
    String channelID;                                //the ID of the channel which uploaded the video
    String title;
    String description;
    ArrayList<String> commentIDs;                    //the ID of the comments under the video, the order in the array list is better to also follow the order which the comments have been made
    ArrayList<String> viewers;                       //to store the ID of the users which have viewed the video followed by either 0 for no like or dislike, 1 for like and 2 for dislike (this is prone to change)
    int likes;                                       //to store the number of likes
    int dislike;                                     //to store the number of dislikes
    String thumbnail;                                //this is a placeholder

    public Video()
    {

    }
}
