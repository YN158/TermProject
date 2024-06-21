package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
//import javax.media.Manager;
//import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class VideoPanel extends JPanel
{

    public VideoPanel(GUI gui)
    {
        setLayout(null);

        /*try {
            // Create the player
            Player player = Manager.createRealizedPlayer("path/to/your/video.mp4");

            // Add the player to the content pane
            getContentPane().add(player.getVisualComponent(), "Center");
            getContentPane().add(player.getControlPanelComponent(), "South");
        } catch (Exception e) {
            e.printStackTrace();
        }*/

        setVisible(false);
        setSize(1550, 838);
    }
}