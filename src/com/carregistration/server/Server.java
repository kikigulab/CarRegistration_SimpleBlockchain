package com.carregistration.server;

import com.carregistration.controller.BlockchainControllelrImpl;
import com.carregistration.model.Car;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.ArrayList;
import java.util.List;

public class Server {

    public static void main(String[] args) {
        try {
            ServerSocket server = new ServerSocket(12345);
            System.out.println("Server started...");
            while (true) {
                Socket socket = server.accept();
                new Thread(new ServerThread(socket)).start();
            }
        } catch (IOException e) {
            e.printStackTrace();
        }}
}

class ServerThread extends Thread {

    static List<Socket> socket = new ArrayList<Socket>();

    public ServerThread(Socket s) {
        socket.add(s);
    }

    public void run() {

        try {
            ObjectOutputStream oos = new ObjectOutputStream(socket.get(0).getOutputStream());
            //ObjectInputStream ois = new ObjectInputStream(socket.get(0).getInputStream());
            System.out.println("Stream initialized");
            //do the blockchain here


        } catch (IOException e1) {
            e1.printStackTrace();
        }


    }

}