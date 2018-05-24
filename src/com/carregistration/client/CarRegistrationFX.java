package com.carregistration.client;

import javafx.geometry.Pos;
import javafx.scene.Scene;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Font;
import javafx.scene.text.FontWeight;
import javafx.scene.text.Text;

public class CarRegistrationFX {

    private final GridPane rootPane;

    public CarRegistrationFX(){
        rootPane = new GridPane();
        rootPane.setAlignment(Pos.CENTER);
        rootPane.setHgap(10);
        rootPane.setVgap(10);

        Text scenetitle = new Text("Car Registration Info");
        scenetitle.setFont(Font.font("Tahoma", FontWeight.NORMAL, 20));
        rootPane.add(scenetitle, 0, 0, 2, 1);

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

    }

    public Pane getRootPane(){
        return rootPane;
    }



}
