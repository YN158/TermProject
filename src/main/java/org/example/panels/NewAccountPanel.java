package org.example.panels;

import org.example.CCM;
import org.example.GUI;
import org.example.User;

import javax.swing.*;
import java.awt.event.WindowEvent;

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

        create.addActionListener(e ->
        {
            if (!nametext.getText().equals("") && !passwordtext.getText().equals("") && !emailtext.getText().equals(""))
            {
                if (isValidEmail(emailtext.getText()))
                {
                    CCM.activeUser = new User(nametext.getText(), emailtext.getText(), passwordtext.getText());
                    setVisible(false);
                    gui.mainDashboardPanel.refresh();
                    gui.mainDashboardPanel.setVisible(true);
                }
                else
                {
                    statues.setText("Please enter a valid Email");
                }
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

    public static boolean isValidEmail(String email)
    {
        String emailRegex = "^[a-zA-Z0-9_+&*-]+(?:\\.[a-zA-Z0-9_+&*-]+)*@(?:[a-zA-Z0-9-]+\\.)+[a-zA-Z]{2,7}$";

        return email.matches(emailRegex);
    }
}
