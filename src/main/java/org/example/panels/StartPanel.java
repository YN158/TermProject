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
    JLabel label1;

    public StartPanel(GUI gui)
    {
        setLayout(null);

        button1 = new JButton("LOG IN");
        button1.setBounds(10, 200, 200, 30);

        button2 = new JButton("CREATE ACCOUNT");
        button2.setBounds(10, 260, 200, 30);

        button3 = new JButton("EXIT");
        button3.setBounds(10, 320, 200, 30);

        label1 = new JLabel("TUBE");
        label1.setBounds(10, 75, 200, 50);
        label1.setFont(new Font("Calibri", Font.BOLD, 20));


        button1.addActionListener(e ->
        {
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


        add(button1);
        add(button2);
        add(button3);
        add(label1);
        setVisible(true);
        setSize(800, 500);
    }
}