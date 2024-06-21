package org.example.NetWork;

import java.io.*;
import java.net.*;


public class Client
{
    public void writeMessage(String msg) throws IOException
    {
        new ObjectOutputStream((new Socket("localhost",Server.port).getOutputStream())).writeObject(msg);
    }
}