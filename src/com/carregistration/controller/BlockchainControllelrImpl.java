package com.carregistration.controller;


import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class BlockchainControllelrImpl extends UnicastRemoteObject implements  BlockchainControllerIF{

    private static final long serialVersionUID = 1L;

    public BlockchainControllelrImpl() throws RemoteException{
    }

    @Override
    public MyBlock registerCarInBlock(int previousHash, Car car) throws RemoteException{
        MyBlock block = new MyBlock(previousHash, car);
        return block;
    }
}
