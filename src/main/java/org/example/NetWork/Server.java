package org.example.NetWork;

import javax.swing.*;
import java.awt.*;
import java.io.*;
import java.net.*;

public class Server {
    private static final int SERVER_PORT = 8080;
    private static final String VIDEO_FOLDER = "D:\\University\\Advanced Programming\\Assignments\\TermProject\\TermProject\\VideoServer\\";

    static JFrame frame;
    static JLabel label;
    static JLabel label2;

    public static void main(String[] args)
    {

        frame = new JFrame("Server");

        label = new JLabel();
        label.setBounds(200, 130, 400, 50);
        label2 = new JLabel();
        label2.setBounds(200, 200, 400, 50);
        frame.add(label);
        frame.add(label2);


        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        frame.setLayout(null);
        frame.setSize(700, 400);
        frame.setVisible(true);



        try {
            printIPAddress();
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            label.setText("Server started. Listening on port " + SERVER_PORT);

            while (true)
            {
                Socket clientSocket = serverSocket.accept();
                label.setText("Client connected: " + clientSocket.getInetAddress().getHostAddress());
                new ClientHandler(clientSocket).start();
            }
        }
        catch (IOException e)
        {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread
    {
        private final Socket clientSocket;

        public ClientHandler(Socket socket)
        {
            this.clientSocket = socket;
        }

        @Override
        public void run()
        {
            try
            {
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

                String operation = dis.readUTF();

                if (operation.equalsIgnoreCase("send")) {
                    receiveVideo(dis, dos);
                } else if (operation.equalsIgnoreCase("receive")) {
                    sendVideo(dis, dos);
                } else {
                    label.setText("Invalid operation received from the client.");
                }

                dis.close();
                dos.close();
                clientSocket.close();
            }
            catch (IOException e)
            {
                e.printStackTrace();
            }
        }

        private void receiveVideo(DataInputStream dis, DataOutputStream dos) throws IOException
        {

            String videoName = dis.readUTF();
            File file = new File(VIDEO_FOLDER + videoName);

            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = dis.read(buffer)) != -1)
            {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            label.setText("Video received successfully: " + file.getAbsolutePath());
        }

        private void sendVideo(DataInputStream dis, DataOutputStream dos) throws IOException
        {
            String videoName = dis.readUTF();
            File file = new File(VIDEO_FOLDER + videoName);

            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1)
            {
                dos.write(buffer, 0, bytesRead);
            }
            dos.flush();
            fis.close();
            label.setText("Video sent successfully to the client.");
        }
    }

    public static void printIPAddress()
    {
        try
        {
            InetAddress localHost = InetAddress.getLocalHost();
            label2.setText("Server's IP address is: " + localHost.getHostAddress());
        }
        catch (UnknownHostException e)
        {
            label2.setText("Unable to get local host IP address.");
            e.printStackTrace();
        }
    }
}
