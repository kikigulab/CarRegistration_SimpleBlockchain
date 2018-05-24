package com.carregistration.server;

import com.carregistration.controller.CalculatorImpl;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ServerMain {
    public static void main(String[] args) {
        try {
            Registry reg = LocateRegistry.createRegistry(1099);

            //now you need to use your calculator implementation here
            CalculatorImpl calc = new CalculatorImpl();
            reg.bind("mycalc", calc);

            System.out.println("Server is ready...");


        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
