package org.example;

import org.example.panels.StartPanel;
import org.example.panels.VideoPanel;

import javax.swing.*;

public class GUI                           //this class holds all the needed panels and acts as a manager to them
{
    public JFrame frame;

    JPanel startPanel;
    JPanel videoPanel;

    CCM centralClassManager;

    public GUI(String name, CCM ccm)
    {
        centralClassManager = ccm;

        frame = new JFrame(name);

        startPanel = new StartPanel(this);
        videoPanel = new VideoPanel(this);

        frame.add(startPanel);
        frame.add(videoPanel);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(1550, 838);
        frame.setVisible(true);
        frame.setExtendedState(frame.getExtendedState() | JFrame.MAXIMIZED_BOTH);

        System.out.println(frame.getSize());
    }
}
