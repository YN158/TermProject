package org.example.panels;

import org.example.CCM;
import org.example.GUI;
import org.example.User;
import org.example.Video;

import javax.swing.*;
import java.awt.event.WindowEvent;
import javax.swing.filechooser.*;
import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.nio.file.StandardCopyOption;

public class UploadVideoPanel extends JPanel
{
    JLabel vidpathlable;
    JLabel vidtitlelable;
    JLabel viddesclable;
    JTextField videoPath;
    JTextField videoTitle;
    JTextField videoDescription;
    JFileChooser j = new JFileChooser();

    JButton upload;
    JButton exit;

    public UploadVideoPanel(GUI gui)
    {
        setLayout(null);

        vidpathlable = new JLabel("Enter Video Path");
        vidpathlable.setBounds(160,160, 250, 40);
        add(vidpathlable);

        videoPath = new JTextField();
        videoPath.setBounds(160,200, 250, 40);
        add(videoPath);

        vidtitlelable = new JLabel("Enter Title");
        vidtitlelable.setBounds(160,240, 250, 40);
        add(vidtitlelable);

        videoTitle = new JTextField();
        videoTitle.setBounds(160,280, 250, 40);
        add(videoTitle);

        viddesclable = new JLabel("Enter Description");
        viddesclable.setBounds(160,320, 250, 40);
        add(viddesclable);

        videoDescription = new JTextField();
        videoDescription.setBounds(160,360, 250, 40);
        add(videoDescription);

        upload = new JButton("Upload");
        upload.setBounds(160,440, 250, 40);
        upload.addActionListener(e ->
        {
            if (!videoPath.getText().equals("") && !videoTitle.getText().equals("") &&  !videoDescription.getText().equals(""))
            {
                CCM.activeVideo = new Video(IDgenerator.VideoGetUniqueId() ,videoTitle.getText(), videoPath.getText(), videoDescription.getText(), CCM.activeUser.GetID());
                CCM.activeUser.addVideo(CCM.activeVideo.GetID());

                copyFile(videoPath.getText(), "D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\Videos", CCM.activeVideo.GetID());

                gui.videoPanel.playVideo("D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\Videos\\" + CCM.activeVideo.GetID() + ".mp4");

                setVisible(false);
                gui.videoPanel.setVisible(true);
                gui.videoPanel.refresh();
                gui.mainDashboardPanel.refresh();
            }
        });
        add(upload);

        exit = new JButton("exit");
        exit.setBounds(160,490, 250, 40);
        exit.addActionListener(e ->
        {
            setVisible(false);
            videoPath.setText("");
            videoTitle.setText("");
            videoDescription.setText("");
            gui.mainDashboardPanel.setVisible(true);
        });
        add(exit);

        setVisible(false);
        setSize(1550, 838);
    }

    public static void copyFile(String sourceFilePath, String destinationFolderPath, String destinationFileName) {
        try {
            Path source = Paths.get(sourceFilePath);
            Path destination = Paths.get(destinationFolderPath, destinationFileName+".mp4");

            Files.createDirectories(destination.getParent());

            Files.copy(source, destination, StandardCopyOption.REPLACE_EXISTING);
            System.out.println("File copied successfully!");
        } catch (IOException e) {
            System.err.println("Error copying file: " + e.getMessage());
        }
    }

    public void refresh()
    {

    }
}