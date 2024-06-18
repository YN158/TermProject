package org.example;

import org.example.panels.StartPanel;
import javax.swing.*;

public class GUI                           //this class holds all the needed panels and acts as a manager to them
{
    public JFrame frame;

    JPanel startPanel;

    CCM centralClassManager;

    public GUI(String name, CCM ccm)
    {
        centralClassManager = ccm;

        frame = new JFrame(name);

        startPanel = new StartPanel(this);

        frame.add(startPanel);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}
