package com.carregistration.client;

import com.carregistration.controller.BlockchainController;
import com.carregistration.model.MyBlock;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.rmi.NotBoundException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;

public class Client {
    private static ObjectOutputStream oos; //pazi go ova e static vidi ako neshto ne ti e vo red
    private static ObjectInputStream ois;

    public static void main() throws NotBoundException {


        try {
            Socket client = new Socket("localhost", 12345);
            System.out.println("Client Started.");
            oos = new ObjectOutputStream(client.getOutputStream());
            ois = new ObjectInputStream(client.getInputStream());


        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public void send(Serializable data) throws Exception {
        oos.writeObject(data);
    }

    public MyBlock recieveRegisteredBlock() throws Exception {
        MyBlock block = (MyBlock) ois.readObject();
        return block;
    }
}
