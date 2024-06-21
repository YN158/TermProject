package org.example.NetWork;

import java.io.*;
import java.net.*;

public class Server implements Runnable {
    public static final int port = 9090;


    public void run() {
        try{
            ServerSocket server = new ServerSocket(port);

            while (true)
            {
                final Socket client = server.accept();
                new Thread() {
                    public void run() {
                        try{
                            ObjectInputStream in =
                                    new ObjectInputStream( client.getInputStream() );
                            String msg = (String) in.readObject();
                            System.out.println(msg + " nn");
                            if (msg.equals("Hello !"))
                            {
                                System.out.println("baaaaa");
                            }
                        }
                        catch(Exception e){System.err.println(e);}

                    }}.start();
            }
        }
        catch(IOException e){System.err.println(e);}
    }

}
