package org.example.panels;

import org.example.GUI;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;

import javax.swing.*;
import java.awt.*;

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
    JButton accountButton;
    JButton logOutButton;
    JButton uploadButton;


    JButton pause;


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

        });

        accountButton = new JButton("User");
        panelNorth.add(accountButton);
        accountButton.addActionListener(e ->
        {
            setVisible(false);
            gui.channelPanel.refresh();
            gui.channelPanel.setVisible(true);
        });

        logOutButton = new JButton("LogOut");
        panelNorth.add(logOutButton);
        logOutButton.addActionListener(e ->
        {
            setVisible(false);
            gui.startPanel.setVisible(true);
            gui.centralClassManager.activeUser.SetToDefault();
        });

        uploadButton = new JButton("Upload Video");
        panelNorth.add(uploadButton);
        uploadButton.addActionListener(e ->
        {
            setVisible(false);
            gui.uploadVideoPanel.setVisible(true);
        });

        setVisible(false);
        setSize(1550, 838);
    }

    public void refresh()
    {
        accountButton.setText(gui.centralClassManager.activeUser.GetID());
    }
}
