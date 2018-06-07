package com.carregistration.server;

import com.carregistration.controller.BlockchainController;

import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class DeployService {
    public static void main(String[] args) throws RemoteException{
        Registry r = LocateRegistry.createRegistry(55555);
        r.rebind("blockchain", new BlockchainController());
    }
}
