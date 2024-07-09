package org.example.panels;

import org.example.CCM;
import org.example.Comment;
import org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.util.ArrayList;

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


    JLabel videoTitle;
    JLabel videoDescription;
    JButton viewChannel;
    JButton subscribe;
    JButton pause;
    JButton like;
    boolean liked = false;
    JButton dislike;
    boolean disliked = false;
    JButton mute;

    JTextField writeComment;
    JButton postComment;
    ArrayList<CommentComponent> commentComps;
    JLabel commentSection;                                    //place holder

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
        panelWest.setPreferredSize(new Dimension(200, 100));
        panelEast.setPreferredSize(new Dimension(200, 100));
        panelSouth.setPreferredSize(new Dimension(100, 100));
        panelCenter.setPreferredSize(new Dimension(100, 100));


        add(panelNorth, BorderLayout.NORTH);
        add(panelWest, BorderLayout.WEST);
        add(panelEast, BorderLayout.EAST);
        add(panelSouth, BorderLayout.SOUTH);
        add(panelCenter, BorderLayout.CENTER);

        panelNorth.setLayout(new FlowLayout());
        //panelEast.setLayout(new GridLayout(5, 1));
        panelWest.setLayout(new GridLayout(5, 1));

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
            liked = false;
            disliked = false;
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
            gui.channelPanel.setVisible(true);
            gui.channelPanel.refresh(CCM.activeUser);
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
            liked = false;
            disliked = false;
            setVisible(false);
        });

        logOutButton = new JButton("LogOut");
        panelNorth.add(logOutButton);
        logOutButton.addActionListener(e ->
        {
            setVisible(false);
            gui.startPanel.setVisible(true);
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
            liked = false;
            disliked = false;
            CCM.activeUser.SetToDefault();
        });

        uploadButton = new JButton("Upload Video");
        panelNorth.add(uploadButton);
        uploadButton.addActionListener(e ->
        {
            setVisible(false);
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
            liked = false;
            disliked = false;
            gui.uploadVideoPanel.setVisible(true);
        });

        //---------------------------------- Video Control Components ----------------------------------

        videoTitle = new JLabel();
        panelSouth.add(videoTitle);

        videoDescription = new JLabel();
        panelSouth.add(videoDescription);

        viewChannel = new JButton();
        panelSouth.add(viewChannel);
        viewChannel.addActionListener(e ->
        {
            gui.channelPanel.setVisible(true);
            gui.channelPanel.refresh(CCM.findUserById(CCM.users, CCM.activeVideo.Getuploader()));
            mediaPlayerComponent.mediaPlayer().controls().setPause(true);
            liked = false;
            disliked = false;
            setVisible(false);
        });

        subscribe = new JButton("Subscribe");
        panelSouth.add(subscribe);
        subscribe.addActionListener(e ->
        {
            boolean issubscribed = false;
            if (!issubscribed)
            {
                CCM.activeUser.addSubscription(CCM.activeVideo.Getuploader());
                issubscribed = false;
                subscribe.setText("Subscribed!");
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

        //------------------------------------ Comment Components ------------------------------------

        commentComps = new ArrayList<CommentComponent>();

        writeComment = new JTextField();
        panelWest.add(writeComment);

        postComment = new JButton("Post Comment");
        postComment.addActionListener(e ->
        {
            if(!writeComment.getText().equals(""))
            {
                CCM.comments.add(new Comment(IDgenerator.CommentGetUniqueId(), CCM.activeVideo.GetID(), CCM.activeUser.GetID(), writeComment.getText()));
                System.out.println(CCM.comments.getLast().GetBody());
                CCM.activeVideo.AddComment(CCM.comments.getLast().GetID());
                System.out.println(CCM.findCommentById(CCM.comments, CCM.activeVideo.GetCommentIDs().getLast()).GetBody());
                refresh();
            }
        });
        panelWest.add(postComment);

        commentSection = new JLabel();
        panelEast.add(commentSection);

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
        //panelEast.removeAll();

        commentComps = new ArrayList<CommentComponent>();

        videoTitle.setText(CCM.activeVideo.GetTitle());
        videoDescription.setText(CCM.activeVideo.GetDescription());
        pfp.setIcon(CCM.activeUser.getIcon());
        viewChannel.setText(CCM.activeVideo.Getuploader());
        accountButton.setText(CCM.activeUser.GetID());
        dislike.setText("Dislikes = " + CCM.activeVideo.GetDislikes());
        like.setText("Likes = " + CCM.activeVideo.GetLikes());

        for (int i = 0; i < CCM.activeVideo.GetCommentIDs().size(); i++)
        {
            commentComps.add(new CommentComponent(CCM.findCommentById(CCM.comments, CCM.activeVideo.GetCommentIDs().get(i)), gui));
        }

        commentSection.setText("");

        for (int i = 0; i < commentComps.size(); i++)
        {
            commentSection.setText(commentComps.get(i).viewAuthorChannel.getText() + "\n" + commentComps.get(i).commentBody.getText() + "\n");
        }
        System.out.println(panelEast.getComponentCount());
    }
}