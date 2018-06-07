package com.carregistration.controller;


import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.rmi.RemoteException;

public class BlockchainControllelrImpl{

    public BlockchainControllelrImpl() throws RemoteException {
    }

    public MyBlock registerCarInBlock(int previousHash, Car car) throws RemoteException{
        MyBlock block = new MyBlock(previousHash, car);
        return block;
    }
}
