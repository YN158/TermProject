package org.example;

import org.example.NetWork.*;

public class Main
{
    public static MongoDBRepository repository;
    public static void main(String[] args)
    {
        repository = new MongoDBRepository();
        GUI gui = new GUI("TUBE");
    }
}