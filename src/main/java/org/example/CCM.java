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

    public static ArrayList<Video> videos = new ArrayList<Video>();
    public static ArrayList<User> users = new ArrayList<User>();
    public static ArrayList<Comment> comments = new ArrayList<Comment>();

    // getAll
    // updateVideos
    // updateUsers
    // updateComments

    public static User findUserById(ArrayList<User> users, String targetId)
    {
        for (User user : users) {
            if (user.GetID().equals(targetId)) {
                return user;
            }
        }
        return null;
    }

    public static void updateUser(ArrayList<User> users , User updatedUser)
    {
        for (int i = 0; i < users.size(); i++)
        {
            if (users.get(i).GetID().equals(updatedUser.GetID()))
            {
                users.set(i, updatedUser.copy());
            }
        }
    }

    public static Video findVideoById(ArrayList<Video> videos, String targetId)
    {
        for (Video video : videos) {
            if (video.GetID().equals(targetId)) {
                return video;
            }
        }
        return null;
    }
    public static Comment findCommentById(ArrayList<Comment> comments, String targetId)
    {
        for (Comment comment : comments) {
            if (comment.GetID().equals(targetId)) {
                return comment;
            }
        }
        return null;
    }

}