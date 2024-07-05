package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class VideoComponent extends JPanel
{
    JButton viewVideo;
    JButton viewUploaderChannel;
    JLabel thumbnail;

    public VideoComponent(String vidtit, String vidUploader/*, Image img*/, GUI gui, String path)
    {
        setLayout(new BorderLayout());

        viewVideo = new JButton(vidtit);
        viewVideo.addActionListener(e ->
        {
            gui.videoPanel.playVideo(path);
            gui.videoPanel.setVisible(true);
            gui.mainDashboardPanel.setVisible(false);
        });
        viewUploaderChannel = new JButton(vidUploader);
        //thumbnail = new JLabel(new ImageIcon(img));

        add(viewVideo, BorderLayout.CENTER);
        add(viewUploaderChannel, BorderLayout.SOUTH);
        //add(thumbnail, BorderLayout.WEST);
    }

}
