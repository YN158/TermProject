package org.example;

import org.example.NetWork.Client;
import org.example.NetWork.Server;

import java.io.IOException;

public class Main
{
    static CCM ccm;
    public static void main(String[] args) throws IOException
    {
        System.out.println("BANANA!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!!");
        Server server = new Server();
        new Thread(server).start();
        Client client1 = new Client();
        Client client2 = new Client();
        client1.writeMessage("Hello !");
        client2.writeMessage("Give me five !");
    }
}