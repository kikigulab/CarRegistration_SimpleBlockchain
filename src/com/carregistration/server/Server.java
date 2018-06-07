package com.carregistration.server;

import com.carregistration.controller.BlockchainController;
import com.carregistration.controller.BlockchainControllerIF;
import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.rmi.NotBoundException;
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
            ObjectInputStream ois = new ObjectInputStream(socket.get(0).getInputStream());
            System.out.println("Stream initialized");

            //recieve the car object and store it in the blockchain, then send the signature back to the client
            while(true){
                System.out.println("***STEP: Recieving new car for registration.");
                Car newCar = (Car) ois.readObject();
                System.out.println("Check if we got the car: " + newCar.getOwnerName());


                Registry register= LocateRegistry.getRegistry("localhost", 55555);
                BlockchainControllerIF bci = (BlockchainControllerIF) register.lookup("blockchain");

                ArrayList<MyBlock> blockchainList = bci.getBlockchain();

                System.out.println("***STEP: Register the car in a block.");
                int lastElement = blockchainList.size() - 1;
                int previousBlockHash = blockchainList.get(lastElement).getBlockHash();
                MyBlock newBlock = bci.registerCarInBlock(previousBlockHash, newCar);
                System.out.println("REGISTRATION SIGNATURE of the new car: " + newBlock.getBlockHash());

                System.out.println("***STEP: Put the block into the blockchain.");
                blockchainList.add(newBlock);
                bci.updateBlockchainList(blockchainList);
                System.out.println("Check: Get the signature of the last block getting it from the updated blockchain: " +
                        "### " + bci.getBlockchain().get(lastElement+1).getBlockHash() + "###");

                System.out.println("***STEP: Send the registered block of the new car to the client.");
                oos.writeObject(newBlock);
            }



        } catch (IOException e1) {
            e1.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } catch (NotBoundException e) {
            e.printStackTrace();
        }


    }

}