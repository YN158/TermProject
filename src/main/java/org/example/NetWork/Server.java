package org.example.NetWork;

import java.io.*;
import java.net.*;

public class Server {
    private static final int SERVER_PORT = 8080;
    private static final String VIDEO_FOLDER = "C:\\Users\\Lenovo\\Desktop\\Server\\";

    public static void main(String[] args) {
        try {
            // Create a server socket to listen for incoming connections
            ServerSocket serverSocket = new ServerSocket(SERVER_PORT);
            System.out.println("Server started. Listening on port " + SERVER_PORT);

            while (true) {
                // Wait for a client connection
                Socket clientSocket = serverSocket.accept();
                System.out.println("Client connected: " + clientSocket.getInetAddress().getHostAddress());

                // Handle the client connection in a separate thread
                new ClientHandler(clientSocket).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static class ClientHandler extends Thread {
        private final Socket clientSocket;

        public ClientHandler(Socket socket) {
            this.clientSocket = socket;
        }

        @Override
        public void run() {
            try {
                DataInputStream dis = new DataInputStream(clientSocket.getInputStream());
                DataOutputStream dos = new DataOutputStream(clientSocket.getOutputStream());

                // Receive the operation from the client
                String operation = dis.readUTF();

                if (operation.equalsIgnoreCase("send")) {
                    // Receive a video from the client
                    receiveVideo(dis, dos);
                } else if (operation.equalsIgnoreCase("receive")) {
                    // Send a video to the client
                    sendVideo(dis, dos);
                } else {
                    System.out.println("Invalid operation received from the client.");
                }

                dis.close();
                dos.close();
                clientSocket.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }

        private void receiveVideo(DataInputStream dis, DataOutputStream dos) throws IOException {
            // Receive the video file name from the client
            String videoName = dis.readUTF();
            File file = new File(VIDEO_FOLDER + videoName);

            // Receive the video file from the client
            FileOutputStream fos = new FileOutputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = dis.read(buffer)) != -1) {
                fos.write(buffer, 0, bytesRead);
            }
            fos.close();
            System.out.println("Video received successfully: " + file.getAbsolutePath());
        }

        private void sendVideo(DataInputStream dis, DataOutputStream dos) throws IOException {
            // Receive the video file name from the client
            String videoName = dis.readUTF();
            File file = new File(VIDEO_FOLDER + videoName);

            // Send the video file to the client
            FileInputStream fis = new FileInputStream(file);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = fis.read(buffer)) != -1) {
                dos.write(buffer, 0, bytesRead);
            }
            dos.flush();
            fis.close();
            System.out.println("Video sent successfully to the client.");
        }
    }
}
