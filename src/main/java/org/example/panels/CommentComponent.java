package org.example.panels;

import org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class CommentComponent extends JPanel
{
    JButton viewAuthorChannel;
    JLabel commentBody;

    public CommentComponent(String CommentID)
    {
        setLayout(new BorderLayout());

        viewAuthorChannel = new JButton();
        add(viewAuthorChannel, BorderLayout.NORTH);
        commentBody = new JLabel();
        add(commentBody, BorderLayout.CENTER);
    }

}