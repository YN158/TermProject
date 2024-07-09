package org.example;

public class Comment
{
    String ID;
    String videoID;                                  //stores the ID of the video which the comment was written under
    String userID;                                   //stores the ID of the author of the comment
    String body;
    String date;                                     //stores the date which the comment was written

    public Comment()
    {

    }

    public String getID() {
        return ID;
    }

    public String getBody() {
        return body;
    }

    public String getDate() {
        return date;
    }

    public String getUserID() {
        return userID;
    }

    public String getVideoID() {
        return videoID;
    }
}
