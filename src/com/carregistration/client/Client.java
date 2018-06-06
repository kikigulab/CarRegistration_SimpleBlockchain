package com.carregistration.client;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class Client {
    public static void main() throws NotBoundException {

        try {
            Socket client = new Socket("localhost", 12345);

            System.out.println("Hello Client Started.");

        } catch (Exception e) {
            e.printStackTrace();
        }

    }
}
