package org.example;

import org.example.NetWork.Client;
import org.example.NetWork.Server;

import java.io.IOException;

public class Main
{
    public static void main(String[] args) throws IOException
    {
        Client.sendVideo("1");
        Client.receiveVideo("2");
    }
}