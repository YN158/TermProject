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
import java.io.File;

public class UploadVideoPanel extends JPanel
{
    JLabel thumbnailPathLable;
    JLabel vidpathlable;
    JLabel vidtitlelable;
    JLabel viddesclable;
    JButton thumbNailSelect;
    String thumbnailPath;
    JButton videoSelect;
    String videoPath;
    JTextField videoTitle;
    JTextField videoDescription;
    JFileChooser j = new JFileChooser();

    JButton upload;
    JButton exit;

    public UploadVideoPanel(GUI gui)
    {
        setLayout(null);

        thumbnailPathLable = new JLabel("Select a thumbnail for the video");
        thumbnailPathLable.setBounds(160,80, 250, 40);
        add(thumbnailPathLable);

        thumbNailSelect = new JButton("Open");
        thumbNailSelect.setBounds(160,120, 250, 40);
        thumbNailSelect.addActionListener(e ->
        {
            thumbnailPath = selectFile();
        });
        add(thumbNailSelect);

        vidpathlable = new JLabel("Select a .mp4 file");
        vidpathlable.setBounds(160,160, 250, 40);
        add(vidpathlable);

        videoSelect = new JButton("Open");
        videoSelect.setBounds(160,200, 250, 40);
        videoSelect.addActionListener(e ->
        {
            videoPath = selectFile();
        });
        add(videoSelect);

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
            if (!videoPath.equals("") && !videoTitle.getText().equals("") &&  !videoDescription.getText().equals("") && !thumbnailPath.equals(""))
            {
                ImageIcon imageIcon = new ImageIcon(thumbnailPath);
                CCM.activeVideo = new Video(IDgenerator.VideoGetUniqueId() ,videoTitle.getText(), videoPath, videoDescription.getText(), CCM.activeUser.GetID(), imageIcon);
                CCM.activeUser.addVideo(CCM.activeVideo.GetID());
                CCM.videos.add(CCM.activeVideo);

                copyFile(videoPath, "D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\Videos", CCM.activeVideo.GetID());

                gui.videoPanel.playVideo("D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\Videos\\" + CCM.activeVideo.GetID() + ".mp4");

                gui.mainDashboardPanel.newVideos.add(new VideoComponent(CCM.activeVideo, gui));

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
            videoPath = "";
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

    public String selectFile()
    {
        JFileChooser fileChooser = new JFileChooser();
        fileChooser.setCurrentDirectory(new File(System.getProperty("user.home")));
        String selectedPath = "";

        int result = fileChooser.showOpenDialog(this);
        if (result == JFileChooser.APPROVE_OPTION)
        {
            File selectedFile = fileChooser.getSelectedFile();
            selectedPath = selectedFile.getAbsolutePath();
        }
        return selectedPath;
    }

    public void refresh()
    {

    }
}