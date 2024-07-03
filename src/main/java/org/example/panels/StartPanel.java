package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;
import java.awt.event.WindowEvent;

public class StartPanel extends JPanel
{
    JButton button1;
    JButton button2;
    JButton button3;
    JButton button4;
    JLabel label1;

    public StartPanel(GUI gui)
    {
        setLayout(null);


        button1 = new JButton("LOG IN");
        button1.setBounds(160,320, 250, 40);
        add(button1);


        button2 = new JButton("CREATE ACCOUNT");
        button2.setBounds(160,370, 250, 40);
        add(button2);


        button3 = new JButton("EXIT");
        button3.setBounds(160,420, 250, 40);
        add(button3);



        label1 = new JLabel("YOUTUBE AT HOME");
        label1.setBounds(160,270, 250, 40);
        add(label1);



        button1.addActionListener(e ->
        {
            gui.mainDashboardPanel.setVisible(true);
            setVisible(false);
        });
        button2.addActionListener(e ->
        {
            setVisible(false);
        });
        button3.addActionListener(e ->
        {
            gui.frame.dispatchEvent(new WindowEvent(gui.frame, WindowEvent.WINDOW_CLOSING));
        });


        setVisible(true);
        setSize(1550, 838);
    }

    public void refresh()
    {

    }
}