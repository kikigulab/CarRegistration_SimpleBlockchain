package com.carregistration.controller;


import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.io.*;
import java.rmi.RemoteException;
import java.util.ArrayList;
import java.util.Collection;

public class BlockchainController {
    String fname;

    ArrayList<MyBlock> blockchain = null;

    Car genesisCar = new Car("gen", "gen", "gen", "gen", "gen");
    MyBlock genesisBlock = new MyBlock(0, genesisCar);

    public BlockchainController(){
    }

    public ArrayList<MyBlock> getBlockchain() {
        return blockchain;
    }

    public MyBlock registerCarInBlock(int previousHash, Car car) throws RemoteException{
        MyBlock block = new MyBlock(previousHash, car);
        return block;
    }

    //file that will store the blocks signatures in a chain.
    public String createBlockchainFile(){
        fname = "blockchain_DBfile.ser";
        FileOutputStream fout;
        ObjectOutputStream oos;

        //if it already exists just return its name
        File yourFile = new File(fname);
        try {
            if(yourFile.createNewFile()){
                //add the genisis block in the file
                fout = new FileOutputStream(yourFile, false);
                oos = new ObjectOutputStream(fout);
                oos.writeObject(genesisBlock);
                System.out.println("New blockchain file created, and genesis block added.");
            }else return fname;

        } catch (IOException e) {
            e.printStackTrace();
        }

        return fname;
    }

    public ArrayList<MyBlock>  loadBlockchainFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fname));
        while(true){
            try{
                blockchain.add((MyBlock) ois.readObject());
            } catch (EOFException e) {
                return blockchain; }
        }
    }

    public void updateFileFromList(ArrayList<MyBlock> bList){
        FileOutputStream fout;
        ObjectOutputStream oos;

        //if it already exists just return its name
        File myFile = new File(fname);
        try {
            myFile.createNewFile();

            fout = new FileOutputStream(myFile, false);
            oos = new ObjectOutputStream(fout);

            for(MyBlock block : bList){
                oos.writeObject(block);
            }

            System.out.println("Blockchain file updated.!");
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
