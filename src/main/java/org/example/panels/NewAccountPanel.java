package org.example.panels;

import org.example.GUI;

import javax.swing.*;

public class NewAccountPanel  extends JPanel
{
    JLabel enterName;
    JTextField nametext;
    JLabel enterEmail;
    JTextField emailtext;
    JLabel enterpassword;
    JTextField passwordtext;
    JLabel statues;
    JButton create;
    JButton exit;

    public NewAccountPanel(GUI gui)
    {
        setLayout(null);

        enterName = new JLabel("Enter Name");
        enterName.setBounds(160,160, 250, 40);
        add(enterName);

        nametext = new JTextField();
        nametext.setBounds(160,200, 250, 40);
        add(nametext);

        enterEmail = new JLabel("Enter EMail");
        enterEmail.setBounds(160,240, 250, 40);
        add(enterEmail);

        emailtext = new JTextField();
        emailtext.setBounds(160,280, 250, 40);
        add(emailtext);

        enterpassword = new JLabel("Enter Password");
        enterpassword.setBounds(160,320, 250, 40);
        add(enterpassword);

        passwordtext = new JTextField();
        passwordtext.setBounds(160,360, 250, 40);
        add(passwordtext);

        statues = new JLabel();
        statues.setBounds(160,400, 250, 40);
        add(statues);

        create = new JButton("Create");
        create.setBounds(160,440, 250, 40);
        add(create);

        exit = new JButton("exit");
        exit.setBounds(160,490, 250, 40);
        add(exit);


        setVisible(false);
        setSize(1550, 838);
    }

    public void refresh()
    {

    }
}
