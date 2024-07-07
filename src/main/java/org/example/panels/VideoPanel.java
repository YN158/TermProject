package org.example.panels;

import org.example.CCM;
import org.example.GUI;

import javax.swing.*;
import java.awt.*;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class VideoPanel extends JPanel
{
    GUI gui;
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
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


    JButton subscribe;
    JButton pause;
    JButton like;
    boolean liked = false;
    JButton dislike;
    boolean disliked = false;
    JButton mute;


    public VideoPanel(GUI g)
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
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
            gui.uploadVideoPanel.setVisible(true);
        });

        //---------------------------------- Video Control Components ----------------------------------

        subscribe = new JButton();
        panelSouth.add(subscribe);

        subscribe.addActionListener(e ->
        {
            boolean issubscribed = false;
            if (!issubscribed)
            {
                CCM.activeUser.addSubscription(CCM.activeVideo.Getuploader());
                issubscribed = false;
            }

        });

        pause = new JButton("pause/play");
        panelSouth.add(pause);
        pause.addActionListener(e ->
        {
            mediaPlayerComponent.mediaPlayer().controls().pause();
        });

        like = new JButton();
        panelSouth.add(like);
        like.addActionListener(e ->
        {
            if (!liked)
            {
                CCM.activeVideo.AddLike();
                liked = true;
                like.setText("Likes = " + CCM.activeVideo.GetLikes());
                if (disliked)
                {
                    disliked = false;
                    CCM.activeVideo.RemoveDislike();
                    dislike.setText("Dislikes = " + CCM.activeVideo.GetDislikes());
                }
            }
            else
            {
                CCM.activeVideo.RemoveLike();
                liked = false;
                like.setText("Likes = " + CCM.activeVideo.GetLikes());
            }

        });

        dislike = new JButton();
        panelSouth.add(dislike);
        dislike.addActionListener(e ->
        {
            if (!disliked)
            {
                CCM.activeVideo.AddDislike();
                disliked = true;
                dislike.setText("Dislikes = " + CCM.activeVideo.GetDislikes());
                if (liked)
                {
                    liked = false;
                    CCM.activeVideo.RemoveLike();
                    like.setText("Likes = " + CCM.activeVideo.GetLikes());
                }
            }
            else
            {
                CCM.activeVideo.RemoveDislike();
                disliked = false;
                dislike.setText("Dislikes = " + CCM.activeVideo.GetDislikes());
            }
        });

        mute = new JButton("mute");
        panelSouth.add(mute);
        mute.addActionListener(e ->
        {
            mediaPlayerComponent.mediaPlayer().audio().mute();
        });

        setVisible(false);
        setSize(1550, 838);
    }

    public void playVideo(String videoPath)
    {
        mediaPlayerComponent.mediaPlayer().media().startPaused(videoPath);
        mediaPlayerComponent.mediaPlayer().controls().setRepeat(true);
    }


    public void refresh()
    {
        pfp.setIcon(CCM.activeUser.getIcon());
        subscribe.setText(CCM.activeVideo.Getuploader());
        accountButton.setText(CCM.activeUser.GetID());
        dislike.setText("Dislikes = " + CCM.activeVideo.GetDislikes());
        like.setText("Likes = " + CCM.activeVideo.GetLikes());
    }
}