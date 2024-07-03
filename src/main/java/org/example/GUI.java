package org.example;

import org.example.panels.*;

import javax.swing.*;

public class GUI                           //this class holds all the needed panels and acts as a manager to them
{
    public JFrame frame;

    public JPanel startPanel;
    public JPanel videoPanel;
    public JPanel mainDashboardPanel;
    public JPanel newAccountPanel;
    public JPanel channelPanel;
    public JPanel loginPanel;

    public CCM centralClassManager;

    public GUI(String name, CCM ccm)
    {
        centralClassManager = ccm;

        frame = new JFrame(name);

        startPanel = new StartPanel(this);
        videoPanel = new VideoPanel(this);
        mainDashboardPanel = new MainDashboardPanel(this);
        newAccountPanel = new NewAccountPanel(this);
        channelPanel = new ChannelPanel(this);
        loginPanel = new LogInPanel(this);

        frame.add(startPanel);
        frame.add(videoPanel);
        frame.add(mainDashboardPanel);
        frame.add(newAccountPanel);
        frame.add(channelPanel);
        frame.add(loginPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1550, 838);
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        System.out.println(frame.getSize());
    }
}
