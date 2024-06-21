package org.example.NetWork;

import java.io.*;
import java.net.*;


public class Client
{
    void writeMessage(String msg) throws IOException
    {
        new ObjectOutputStream((new Socket("localhost",Server.port).getOutputStream())).writeObject(msg);
    }

    public static void main(String[] args) throws IOException
    {
        Server server = new Server();
        new Thread(server).start();
        Client client1 = new Client();
        Client client2 = new Client();
        client1.writeMessage("Hello !");
        client2.writeMessage("Give me five !");
    }
}