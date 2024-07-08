package org.example.NetWork;

import java.io.*;
import java.net.*;

public class Client {
    private static final String SERVER_IP = "127.0.0.1";
    private static final int SERVER_PORT = 8080;
    private static final String VIDEO_FOLDER = "C:\\Users\\Lenovo\\Desktop\\Client\\";

    public static void sendVideo(String videoName) {
        try {
            videoName = videoName + ".mp4";
            // Connect to the server
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send the "send" operation to the server
            dos.writeUTF("send");

            // Send the video file name to the server
            dos.writeUTF(videoName);

            // Send the video file to the server
            File file = new File(VIDEO_FOLDER + videoName);
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            dos.flush();
            fis.close();

            System.out.println("Video sent successfully to the server.");

            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    public static void receiveVideo(String videoName) {
        try {
            videoName = videoName + ".mp4";
            // Connect to the server
            Socket socket = new Socket(SERVER_IP, SERVER_PORT);
            DataInputStream dis = new DataInputStream(socket.getInputStream());
            DataOutputStream dos = new DataOutputStream(socket.getOutputStream());

            // Send the "receive" operation to the server
            dos.writeUTF("receive");

            // Send the video file name to the server
            dos.writeUTF(videoName);

            // Receive the video file from the server
            File file = new File(VIDEO_FOLDER + videoName);
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();

            System.out.println("Video received successfully from the server.");

            dis.close();
            dos.close();
            socket.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}