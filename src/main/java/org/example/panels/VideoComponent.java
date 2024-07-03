package org.example.panels;

import javax.swing.*;
import java.awt.*;

public class VideoComponent extends JPanel
{
    JButton viewVideo;
    JButton viewUploaderChannel;
    JLabel thumbnail;

    public VideoComponent(String vidtit, String vidUploader, Image img)
    {
        setLayout(new BorderLayout());

        viewVideo = new JButton(vidtit);
        viewUploaderChannel = new JButton(vidUploader);
        thumbnail = new JLabel(new ImageIcon(img));

        add(viewVideo, BorderLayout.CENTER);
        add(viewUploaderChannel, BorderLayout.SOUTH);
        add(thumbnail, BorderLayout.WEST);
    }

}
