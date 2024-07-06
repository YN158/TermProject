package org.example.panels;

public class IDgenerator
{
    //private static int channelNextId = 1;
    private static int videoNextId = 1;
    private static int commentNextId = 1;

    /*public static int ChannelGetUniqueId() {
        return channelNextId++;
    }*/
    public static int VideoGetUniqueId() {
        return videoNextId++;
    }
    public static int CommentGetUniqueId() {
        return commentNextId++;
    }
}
