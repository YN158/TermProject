package org.example.panels;

import org.example.CCM;
import org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class MainDashboardPanel extends JPanel
{
    GUI gui;
    JPanel panelNorth;
    JPanel panelWest;
    JPanel panelEast;
    JPanel panelSouth;
    JPanel panelCenter;

    JTextField searchbar;
    JButton searchButton;
    JLabel pfp;
    JButton accountButton;
    JButton logOutButton;
    JButton uploadButton;
    ArrayList <VideoComponent> newVideos;

    JLabel subscriptions;

    public MainDashboardPanel(GUI g)
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

        searchbar = new JTextField();
        searchbar.setPreferredSize(new Dimension(250, 25));
        panelNorth.add(searchbar);

        searchButton = new JButton("Search");
        panelNorth.add(searchButton);
        searchButton.addActionListener(e ->
        {
            setVisible(false);
            gui.searchedPanel.refresh(searchbar.getText());
            gui.searchedPanel.setVisible(true);
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

        newVideos = new ArrayList<VideoComponent>();

        subscriptions = new JLabel();
        panelWest.add(subscriptions);

        setVisible(false);
        setSize(1550, 838);

    }

    public void refresh()
    {
        accountButton.setText(CCM.activeUser.GetID());
        pfp.setIcon(CCM.activeUser.getIcon());

        for (int i = 0; i < newVideos.size(); i++)
        {
            panelCenter.add(newVideos.get(i));
        }

        subscriptions.setText("");
        for (int i = 0; i < CCM.activeUser.GetSubsIDs().size(); i++)
        {
            subscriptions.setText(CCM.activeUser.GetSubsIDs().get(i) + "\n");
        }
    }
}
