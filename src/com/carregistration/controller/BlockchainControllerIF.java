package com.carregistration.controller;

import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.rmi.Remote;
import java.rmi.RemoteException;
import java.util.ArrayList;

public interface BlockchainControllerIF extends Remote {
    public MyBlock registerCarInBlock(int previousHash, Car car) throws RemoteException;
    public void updateBlockchainList(ArrayList<MyBlock> blockchain) throws RemoteException;
    public ArrayList<MyBlock> getBlockchain() throws RemoteException;
}
