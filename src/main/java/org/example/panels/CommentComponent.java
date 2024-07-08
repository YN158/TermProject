package org.example.panels;

import org.example.CCM;
import org.example.Comment;
import org.example.GUI;

import javax.swing.*;
import java.awt.*;

public class CommentComponent extends JPanel
{
    JButton viewAuthorChannel;
    JLabel commentBody;

    public CommentComponent(Comment comment, GUI gui)
    {
        setLayout(new BorderLayout());

        viewAuthorChannel = new JButton(comment.GetUserID());
        viewAuthorChannel.addActionListener(e -> {
            gui.videoPanel.setVisible(false);
            gui.channelPanel.refresh(CCM.findUserById(CCM.users, comment.GetUserID()));
            gui.channelPanel.setVisible(true);
        });
        add(viewAuthorChannel, BorderLayout.NORTH);

        commentBody = new JLabel(comment.GetBody());
        add(commentBody, BorderLayout.CENTER);
    }

}