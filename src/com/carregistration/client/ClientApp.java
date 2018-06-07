package com.carregistration.client;

import com.carregistration.model.Car;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.geometry.Pos;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.stage.Stage;

public class ClientApp extends Application {
    Client client = new Client();

    GridPane rootPane = new GridPane();
    private TextArea serverResponseArea = new TextArea();
    private Car car;

    private Parent createContent() {
        serverResponseArea.setPrefHeight(100);
        TextField input = new TextField();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);
        rootPane.add(serverResponseArea, 0, 0);
        rootPane.setPrefSize(700, 600);

        //owner first name
        Label ownerName = new Label("Owner First Name:");
        rootPane.add(ownerName, 0, 1);

        TextField nameTextField = new TextField();
        rootPane.add(nameTextField, 1, 1);

        //owner last name
        Label ownerLastName = new Label("Owner Last Name:");
        rootPane.add(ownerLastName, 0, 2);

        TextField lastNameTextField = new TextField();
        rootPane.add(lastNameTextField, 1, 2);

        //carbrand
        Label carBrand = new Label("CarBrand:");
        rootPane.add(carBrand, 0, 3);

        TextField carBrandTextField = new TextField();
        rootPane.add(carBrandTextField, 1, 3);

        //car color
        Label carColor = new Label("Car Color:");
        rootPane.add(carColor, 0, 4);

        TextField carColorTextField = new TextField();
        rootPane.add(carColorTextField, 1, 4);

        //car plate
        Label carPlate = new Label("Car Plate:");
        rootPane.add(carPlate, 0, 5);

        TextField carPlateTextField = new TextField();
        rootPane.add(carPlateTextField, 1, 5);

        Button btnRegistration = new Button("Submit for Registration");
        rootPane.add(btnRegistration, 0, 6);
        btnRegistration.setOnAction(new EventHandler<ActionEvent>(){
            public void handle(ActionEvent t){
                try{
                    car = new Car(nameTextField.getText(), lastNameTextField.getText(), carBrandTextField.getText(),
                            carColorTextField.getText(), carPlateTextField.getText());
                    //and send it to server
                    client.send(car);

                }catch (Exception e){}
            }
        });
        return rootPane;
    }

    @Override
    public void init() throws Exception{
        client.main();
    }

    @Override
    public void start(Stage primaryStage) throws Exception {
        primaryStage.setScene(new Scene(createContent()));
        primaryStage.setTitle("Car Registration");
        primaryStage.show();

    }

    public static void main(String[] args) {
        launch(args);
    }
}
