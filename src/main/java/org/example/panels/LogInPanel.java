package org.example.panels;

import org.example.GUI;
import org.example.User;

import javax.swing.*;
import java.awt.event.WindowEvent;

public class LogInPanel extends JPanel
{
    JLabel enterName;
    JTextField nametext;
    JLabel enterpassword;
    JTextField passwordtext;
    JLabel statues;
    JButton create;
    JButton exit;

    public LogInPanel(GUI gui)
    {
        setLayout(null);

        enterName = new JLabel("Enter Name");
        enterName.setBounds(160,160, 250, 40);
        add(enterName);

        nametext = new JTextField();
        nametext.setBounds(160,200, 250, 40);
        add(nametext);


        enterpassword = new JLabel("Enter Password");
        enterpassword.setBounds(160,240, 250, 40);
        add(enterpassword);

        passwordtext = new JTextField();
        passwordtext.setBounds(160,280, 250, 40);
        add(passwordtext);

        statues = new JLabel();
        statues.setBounds(160,320, 250, 40);
        add(statues);

        create = new JButton("Login");
        create.setBounds(160,360, 250, 40);
        add(create);

        exit = new JButton("exit");
        exit.setBounds(160,410, 250, 40);
        add(exit);

        create.addActionListener(e ->
        {
            if (!nametext.getText().equals("") && !passwordtext.getText().equals(""))
            {

            }
            else
            {
                statues.setText("Please Fill all the areas");
            }
        });

        exit.addActionListener(e ->
        {
            setVisible(false);
            gui.startPanel.setVisible(true);
        });


        setVisible(false);
        setSize(1550, 838);
    }

    public void refresh()
    {

    }
}