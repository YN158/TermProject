package org.example;

public class Comment
{
    String ID;
    String videoID;                                  //stores the ID of the video which the comment was written under
    String userID;                                   //stores the ID of the author of the comment
    String body;
    String date;                                     //stores the date which the comment was written

    public Comment(String id, String vidid, String userid, String bd)
    {
        ID= id;
        videoID = vidid;
        userID = userid;
        body = bd;
    }

    public String GetID()
    {
        return ID;
    }

    public String GetVideoID()
    {
        return videoID;
    }

    public String GetUserID()
    {
        return userID;
    }

    public String GetBody()
    {
        return body;
    }

    public String GetDate()
    {
        return ID;
    }
}
