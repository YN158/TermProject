package org.example;
import javax.swing.*;
import java.awt.event.WindowEvent;

public class GUI                           //this class holds all the needed panels and acts as a manager to them
{
    JFrame frame;

    CCM centralClassManager;

    public GUI(String name, CCM ccm)
    {
        centralClassManager = ccm;

        frame = new JFrame(name);

        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(800, 500);
        frame.setVisible(true);
    }
}
