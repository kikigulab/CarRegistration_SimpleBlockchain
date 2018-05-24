package com.carregistration.controller;


import java.rmi.RemoteException;
import java.rmi.server.UnicastRemoteObject;

public class CalculatorImpl extends UnicastRemoteObject implements  CalculatorInterface{

    private static final long serialVersionUID = 1L;

    public CalculatorImpl() throws RemoteException {
    }


    public int add(int n1, int n2) throws RemoteException {
        return n1 + n2;
    }


    public int substract(int n1, int n2) throws RemoteException {
        return n1 - n2;
    }


    public int multiply(int n1, int n2) throws RemoteException {
        return n1 * n2;
    }


    public int divide(int n1, int n2) throws RemoteException {
        return n1 / n2;
    }

}
