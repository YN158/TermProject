package org.example.panels;

import org.example.CCM;
import org.example.GUI;
import org.example.Video;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;
import java.util.stream.Collectors;

public class SearchedPanel extends JPanel
{
    GUI gui;
    JPanel panelNorth;
    JPanel panelWest;
    JPanel panelEast;
    JPanel panelSouth;
    JPanel panelCenter;

    JButton mainPageButton;
    JTextField searchbar;
    JButton searchButton;
    JLabel pfp;
    JButton accountButton;
    JButton logOutButton;
    JButton uploadButton;
    ArrayList <VideoComponent> searchedVideosComp;
    ArrayList <Video> searchedVideos;

    JLabel subscriptions;

    public SearchedPanel(GUI g)
    {
        gui = g;
        setLayout(new BorderLayout());

        //---------------------------------- Main Border Panel ----------------------------------

        panelNorth = new JPanel();
        panelWest = new JPanel();
        panelEast = new JPanel();
        panelSouth = new JPanel();
        panelCenter = new JPanel();

        panelNorth.setPreferredSize(new Dimension(100, 100));
        panelWest.setPreferredSize(new Dimension(100, 100));
        panelEast.setPreferredSize(new Dimension(100, 100));
        panelSouth.setPreferredSize(new Dimension(100, 100));
        panelCenter.setPreferredSize(new Dimension(100, 100));
        JScrollPane scrollFrame = new JScrollPane(panelCenter);
        panelCenter.setAutoscrolls(true);

        add(panelNorth, BorderLayout.NORTH);
        add(panelWest, BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
        add(scrollFrame, BorderLayout.CENTER);

        panelNorth.setLayout(new FlowLayout());
        panelCenter.setLayout(new GridLayout(5,3));
        panelWest.setLayout(new BoxLayout(panelWest, BoxLayout.Y_AXIS));

        //---------------------------------- Other Components ----------------------------------

        mainPageButton = new JButton("Main DashBoard");
        panelNorth.add(mainPageButton);
        mainPageButton.addActionListener(e ->
        {
            setVisible(false);
            gui.mainDashboardPanel.setVisible(true);
            gui.mainDashboardPanel.refresh();
        });

        searchbar = new JTextField();
        searchbar.setPreferredSize(new Dimension(250, 25));
        panelNorth.add(searchbar);

        searchButton = new JButton("Search");
        panelNorth.add(searchButton);
        searchButton.addActionListener(e ->
        {

        });

        pfp = new JLabel();
        pfp.setPreferredSize(new Dimension(25, 25));
        panelNorth.add(pfp);

        accountButton = new JButton("User");
        panelNorth.add(accountButton);
        accountButton.addActionListener(e ->
        {
            gui.channelPanel.setVisible(true);
            gui.channelPanel.refresh(CCM.activeUser);
            setVisible(false);
        });

        logOutButton = new JButton("LogOut");
        panelNorth.add(logOutButton);
        logOutButton.addActionListener(e ->
        {
            setVisible(false);
            gui.startPanel.setVisible(true);
            CCM.activeUser.SetToDefault();
        });

        uploadButton = new JButton("Upload Video");
        panelNorth.add(uploadButton);
        uploadButton.addActionListener(e ->
        {
            setVisible(false);
            gui.uploadVideoPanel.setVisible(true);
        });

        searchedVideosComp = new ArrayList<VideoComponent>();

        subscriptions = new JLabel();
        panelWest.add(subscriptions);

        setVisible(false);
        setSize(1550, 838);

    }

    public void refresh(String searchedPhrase)
    {
        panelCenter.removeAll();

        accountButton.setText(CCM.activeUser.GetID());
        pfp.setIcon(CCM.activeUser.getIcon());
        searchedVideos = null;
        searchedVideos = searchVideoByTitle(CCM.videos, searchedPhrase);
        //searchedVideos.addAll(searchVideoByTitle(CCM.videos, searchedPhrase));

        searchedVideosComp = new ArrayList<VideoComponent>();

        for (int i = 0; i < searchedVideos.size(); i++)
        {
            searchedVideosComp.add(new VideoComponent(searchedVideos.get(i), gui));
        }

        for (int i = 0; i < searchedVideosComp.size(); i++)
        {
            panelCenter.add(searchedVideosComp.get(i));
        }

        subscriptions.setText("");
        for (int i = 0; i < CCM.activeUser.GetSubsIDs().size(); i++)
        {
            subscriptions.setText(CCM.activeUser.GetSubsIDs().get(i) + "\n");
        }
    }

    public static ArrayList<Video> searchVideoByTitle(ArrayList<Video> videos, String titleSearch)
    {
        return videos.stream()
                .filter(video -> video.GetTitle().contains(titleSearch))
                .filter(video -> video.Getuploader().contains(titleSearch))
                .collect(Collectors.toCollection(ArrayList::new));
    }
    public static ArrayList<Video> searchVideoByUploader(ArrayList<Video> videos, String uploaderSearch)
    {
        return videos.stream()
                .filter(video -> video.Getuploader().contains(uploaderSearch))
                .collect(Collectors.toCollection(ArrayList::new));
    }
}
