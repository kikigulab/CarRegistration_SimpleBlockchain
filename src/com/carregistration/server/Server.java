package com.carregistration.server;

import com.carregistration.model.Car;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
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
            ObjectInputStream ois = new ObjectInputStream(socket.get(0).getInputStream());
            System.out.println("Stream initialized");

            //recieve the car object and store it in the blockchain, then send the signature back to the client
            while(true){
                Car carInfoRecieved = (Car) ois.readObject();
                System.out.println("Check if we got the car: " + carInfoRecieved.getOwnerName());

            }



        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }


    }

}