package org.example;

import java.util.ArrayList;

public class PlayList
{
    String ID;
    String Title;
    String OwnerID;
    ArrayList<String> VideoIDs;

    public PlayList(String id, String ttl, String ownerID)
    {
        ID = id;
        Title = ttl;
        OwnerID = ownerID;
        VideoIDs = new ArrayList<String >();
    }

    public String getID()
    {
        return ID;
    }

    public String getTitle()
    {
        return Title;
    }

    public String getOwnerID()
    {
        return OwnerID;
    }

    public void addVideo(String vidID)
    {
        VideoIDs.add(vidID);
    }
}
