package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;
import javax.media.Manager;
import javax.media.Player;
import javax.swing.JFrame;
import javax.swing.SwingUtilities;


public class VideoPanel extends JPanel
{

    public VideoPanel(GUI gui)
    {
        setLayout(null);

        /*try {
            Manager.setHint(Manager.LIGHTWEIGHT_RENDERER, true);
            Player mediaPlayer = Manager.createRealizedPlayer(mediaURL);
            Component video = mediaPlayer.getVisualComponent();
            Component controls = mediaPlayer.getControlPanelComponent();

            if (video != null)

                add(video, BorderLayout.CENTER);

            if (controls != null)
                add(controls, BorderLayout.SOUTH);

            mediaPlayer.start();
        } catch (NoPlayerException noPlayerException) {
            System.err.println("No media player found");
        } // end catch
        catch (CannotRealizeException cannotRealizeException) {
            System.err.println("Could not realize media player");
        } // end catch
        catch (IOException iOException) {
            System.err.println("Error reading from the source");
        }*/

        setVisible(true);
        setSize(1550, 838);
    }

    public void refresh()
    {

    }
}