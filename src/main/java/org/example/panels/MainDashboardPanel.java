package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class MainDashboardPanel extends JPanel
{

    JPanel panelNorth;
    JPanel panelWest;
    JPanel panelEast;
    JPanel panelSouth;
    JPanel panelCenter;

    JTextField searchbar;
    JButton searchButton;
    JButton accountButton;
    JButton logOutButton;
    JButton uploadButton;
    VideoComponent newVideo1;
    VideoComponent newVideo2;
    VideoComponent newVideo3;
    VideoComponent newVideo4;
    VideoComponent newVideo5;



    public MainDashboardPanel(GUI gui)
    {
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
        panelCenter.setLayout(new GridLayout(5,1));

        //---------------------------------- Other Components ----------------------------------

        searchbar = new JTextField();
        searchbar.setPreferredSize(new Dimension(250, 25));
        panelNorth.add(searchbar);

        searchButton = new JButton("Search");
        panelNorth.add(searchButton);

        accountButton = new JButton("User");
        panelNorth.add(accountButton);

        logOutButton = new JButton("LogOut");
        panelNorth.add(logOutButton);

        uploadButton = new JButton("Upload Video");
        panelNorth.add(uploadButton);


        setVisible(false);
        setSize(1550, 838);

    }

    public void refresh()
    {

    }
}
