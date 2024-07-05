package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class VideoPanel extends JPanel
{
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
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


    public VideoPanel(GUI gui)
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

        //---------------------------------- Other Components ----------------------------------

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setPreferredSize(new Dimension(900, 400));

        panelCenter.add(mediaPlayerComponent, BorderLayout.CENTER);



        mainPageButton = new JButton("Main DashBoard");
        panelNorth.add(mainPageButton);
        mainPageButton.addActionListener(e ->
        {
            setVisible(false);
            gui.mainDashboardPanel.setVisible(true);
            gui.mainDashboardPanel.refresh();
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
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
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
            gui.uploadVideoPanel.setVisible(true);
        });

        pause = new JButton("pause");
        panelSouth.add(pause);
        pause.addActionListener(e ->
        {
            stopVideo();
        });

        setVisible(false);
        setSize(1550, 838);
    }

    public void playVideo(String videoPath)
    {
        mediaPlayerComponent.mediaPlayer().media().startPaused(videoPath);
    }

    public void stopVideo()
    {
        mediaPlayerComponent.mediaPlayer().controls().pause();
    }

    public void refresh()
    {

    }
}