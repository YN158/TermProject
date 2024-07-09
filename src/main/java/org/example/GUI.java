package org.example;

import org.example.panels.*;

import javax.swing.*;

public class GUI                           //this class holds all the needed panels and acts as a manager to them
{
    public JFrame frame;

    public StartPanel startPanel;
    public VideoPanel videoPanel;
    public MainDashboardPanel mainDashboardPanel;
    public NewAccountPanel newAccountPanel;
    public ChannelPanel channelPanel;
    public LogInPanel loginPanel;
    public UploadVideoPanel uploadVideoPanel;
    public SearchedPanel searchedPanel;


    public GUI(String name)
    {
        frame = new JFrame(name);

        startPanel = new StartPanel(this);
        videoPanel = new VideoPanel(this);
        mainDashboardPanel = new MainDashboardPanel(this);
        newAccountPanel = new NewAccountPanel(this);
        channelPanel = new ChannelPanel(this);
        loginPanel = new LogInPanel(this);
        uploadVideoPanel = new UploadVideoPanel(this);
        searchedPanel = new SearchedPanel(this);

        frame.add(startPanel);
        frame.add(videoPanel);
        frame.add(mainDashboardPanel);
        frame.add(newAccountPanel);
        frame.add(channelPanel);
        frame.add(loginPanel);
        frame.add(uploadVideoPanel);
        frame.add(searchedPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1550, 838);
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        System.out.println(frame.getSize());
    }
}
