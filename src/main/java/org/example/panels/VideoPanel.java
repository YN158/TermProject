package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;
import javax.swing.SwingUtilities;

import uk.co.caprica.vlcj.factory.MediaPlayerFactory;
import uk.co.caprica.vlcj.player.component.EmbeddedMediaPlayerComponent;
import uk.co.caprica.vlcj.player.embedded.EmbeddedMediaPlayer;


public class VideoPanel extends JPanel
{
    private final EmbeddedMediaPlayerComponent mediaPlayerComponent;
    public VideoPanel(GUI gui)
    {
        setLayout(new BorderLayout());

        mediaPlayerComponent = new EmbeddedMediaPlayerComponent();
        mediaPlayerComponent.setPreferredSize(new Dimension(300, 300));

        add(mediaPlayerComponent, BorderLayout.CENTER);

        setVisible(false);
        setSize(1550, 838);
    }

    public void playVideo(String videoPath)
    {
        mediaPlayerComponent.mediaPlayer().media().start(videoPath);
    }

    public void refresh()
    {

    }
}