package com.carregistration.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    private static ObjectOutputStream oos; //pazi go ova e static vidi ako neshto ne ti e vo red

    public static void main() throws NotBoundException {


        try {
            Socket client = new Socket("localhost", 12345);
            System.out.println("Client Started.");
            oos = new ObjectOutputStream(client.getOutputStream());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(Serializable data) throws Exception {
        oos.writeObject(data);
    }
}
