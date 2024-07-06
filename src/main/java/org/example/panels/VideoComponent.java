package org.example.panels;

import org.example.GUI;
import org.example.Video;

import javax.swing.*;
import java.awt.*;

public class VideoComponent extends JPanel
{
    JButton viewVideo;
    JButton viewUploaderChannel;
    JLabel thumbnail;
    String videoID;

    public VideoComponent(Video vid, GUI gui)
    {
        videoID = vid.GetID();

        setLayout(new BorderLayout());

        viewVideo = new JButton(vid.GetTitle());
        viewVideo.addActionListener(e ->
        {
            gui.videoPanel.playVideo("D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\Videos\\" + videoID + ".mp4");
            gui.mainDashboardPanel.setVisible(false);
            gui.videoPanel.setVisible(true);
            gui.videoPanel.refresh();
        });
        viewUploaderChannel = new JButton(vid.Getuploader());
        viewUploaderChannel.addActionListener(e ->
        {
            gui.mainDashboardPanel.setVisible(false);
            gui.channelPanel.refresh();
            gui.channelPanel.setVisible(true);
        });
        //thumbnail = new JLabel(new ImageIcon(img));

        add(viewVideo, BorderLayout.CENTER);
        add(viewUploaderChannel, BorderLayout.SOUTH);
        //add(thumbnail, BorderLayout.WEST);
    }

}
