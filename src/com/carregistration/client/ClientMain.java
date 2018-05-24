package com.carregistration.client;

import com.carregistration.controller.CalculatorInterface;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.*;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.BorderPane;
import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.rmi.NotBoundException;
import java.rmi.RemoteException;
import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;

public class ClientMain extends Application {

    @Override
    public void start(Stage stage) throws RemoteException, NotBoundException {
        //Parent root = FXMLLoader.load(getClass().getResource("sample.fxml"));
        Registry registry = LocateRegistry.getRegistry("localhost", 1099);
        CalculatorInterface calc = (CalculatorInterface) registry.lookup("mycalc");

       VBox root = new  VBox();
        Label lblRegister = new Label("Car Registration Client");
        Button btnProcess = new Button("Register Your Car");

        btnProcess.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                try{
                    CarRegistrationFX carReg = new CarRegistrationFX();
                    stage.getScene().setRoot(carReg.getRootPane());
                }catch (Exception e){}
            }
        });

        root.getChildren().addAll(lblRegister, btnProcess);
        stage.setScene(new Scene(root, 400, 700));
        stage.setTitle("RMI GUI Client");
        stage.show();

    }


    public static void main(String[] args) {
        launch(args);
    }
}
