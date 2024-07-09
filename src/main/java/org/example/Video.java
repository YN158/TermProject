package org.example;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class Video
{
    String ID;
    String channelID;                                //the ID of the channel which uploaded the video
    String videoPath;
    String title;
    String description;
    ArrayList<String> commentIDs;                    //the ID of the comments under the video, the order in the array list is better to also follow the order which the comments have been made
    ArrayList<String> viewerIDs;                     //to store the ID of the users which have viewed the video followed by either 0 for no like or dislike, 1 for like and 2 for dislike (this is prone to change)
    int likes;                                       //to store the number of likes
    int dislike;                                     //to store the number of dislikes
    ImageIcon thumbnail;                                 //this is a placeholder and will be replaced by the correct format/variable type

    public Video(String id, String ttl ,String path, String  desc, ArrayList<String> commentids, String uploaderid, ImageIcon img)
    {
        ID = id;
        title = ttl;
        videoPath = path;
        description = desc;
        commentIDs = commentids;
        channelID = uploaderid;
        thumbnail = img;
    }

    public String GetID()
    {
        return ID;
    }

    public String GetTitle()
    {
        return title;
    }

    public String GetVideoPath() {
        return videoPath;
    }

    public String GetDescription()
    {
        return description;
    }

    public int GetLikes()
    {
        return likes;
    }

    public int GetDislikes()
    {
        return dislike;
    }

    public String Getuploader()
    {
        return channelID;
    }

    public ArrayList<String> GetViewerIDs() {
        return viewerIDs;
    }

    public ImageIcon GetThumbnail()
    {
        return thumbnail;
    }

    public ArrayList<String> GetCommentIDs()
    {
        return commentIDs;
    }

    public void AddLike()
    {
        likes++;
    }

    public void RemoveLike()
    {
        likes--;
    }

    public void AddDislike()
    {
        dislike++;
    }

    public void RemoveDislike()
    {
        dislike--;
    }

    public void AddComment(String commentID)
    {
        commentIDs.add(new String(commentID));
    }

}
