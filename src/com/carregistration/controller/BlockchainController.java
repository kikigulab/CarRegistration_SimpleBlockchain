package com.carregistration.controller;


import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.io.*;
import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;
import java.util.ArrayList;
import java.util.Collection;

public class BlockchainController extends UnicastRemoteObject implements BlockchainControllerIF{

    ArrayList<MyBlock> blockchain = new ArrayList<>();

    public BlockchainController() throws RemoteException {
        //create the genesis in the blockchain
        Car genesisCar = new Car("gen", "gen", "gen", "gen", "gen");
        MyBlock genesisBlock = new MyBlock(0, genesisCar);
        blockchain.add(genesisBlock);
    }

    @Override
    public MyBlock registerCarInBlock(int previousHash, Car car) throws RemoteException {
        MyBlock block = new MyBlock(previousHash, car);
        return block;
    }

    @Override
    public void updateBlockchainList(ArrayList<MyBlock> blockchain) throws RemoteException {
        this.blockchain = blockchain;
    }

    @Override
    public ArrayList<MyBlock> getBlockchain() throws RemoteException {
        return blockchain;
    }
}
