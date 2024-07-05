package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class VideoComponent extends JPanel
{
    JButton viewVideo;
    JButton viewUploaderChannel;
    JLabel thumbnail;

    public VideoComponent(String vidtit, String vidUploader, GUI gui)
    {
        setLayout(new BorderLayout());

        viewVideo = new JButton(vidtit);
        viewVideo.addActionListener(e ->
        {
            gui.videoPanel.playVideo("D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\Videos\\" + vidtit + ".mp4");
            gui.videoPanel.setVisible(true);
            gui.videoPanel.refresh();
            gui.mainDashboardPanel.setVisible(false);
        });
        viewUploaderChannel = new JButton(vidUploader);
        //thumbnail = new JLabel(new ImageIcon(img));

        add(viewVideo, BorderLayout.CENTER);
        add(viewUploaderChannel, BorderLayout.SOUTH);
        //add(thumbnail, BorderLayout.WEST);
    }

}
