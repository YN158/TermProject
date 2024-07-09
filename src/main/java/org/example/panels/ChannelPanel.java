package org.example.panels;

import org.example.CCM;
import org.example.GUI;
import org.example.User;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

public class ChannelPanel  extends JPanel
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


    User user;
    JLabel channelName;
    ArrayList<VideoComponent> newVideos;


    public ChannelPanel(GUI g)
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


        add(panelNorth, BorderLayout.NORTH);
        add(panelWest, BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);

        panelNorth.setLayout(new FlowLayout());

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
            setVisible(false);
            gui.channelPanel.refresh(CCM.activeUser);
            gui.channelPanel.setVisible(true);
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

        channelName = new JLabel();
        panelWest.add(channelName);

        setVisible(false);
        setSize(1550, 838);
    }

    public void refresh(User u)
    {
        panelCenter.removeAll();
        newVideos = new ArrayList<VideoComponent>();
        user = u;
        pfp.setIcon(CCM.activeUser.getIcon());
        accountButton.setText(CCM.activeUser.GetID());
        channelName.setText(user.GetID());

        for (int i = 0; i < user.GetVidIDs().size(); i++)
        {
            newVideos.add(new VideoComponent(CCM.findVideoById(CCM.videos, user.GetVidIDs().get(i)), gui));
        }

        for (int i = 0; i < newVideos.size(); i++)
        {
            panelCenter.add(newVideos.get(i));
        }
    }
}
