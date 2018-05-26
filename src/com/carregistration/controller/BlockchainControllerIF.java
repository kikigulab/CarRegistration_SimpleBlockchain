package com.carregistration.controller;

import com.carregistration.model.Car;
import com.carregistration.model.MyBlock;

import java.rmi.Remote;
import java.rmi.RemoteException;

public interface BlockchainControllerIF extends Remote{

    public MyBlock registerCarInBlock(int previousHash, Car car) throws RemoteException; //takes hash code of the previous block
}
