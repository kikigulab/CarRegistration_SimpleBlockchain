package com.carregistration.model;

import java.io.Serializable;

public class Car implements Serializable{
    private String plate;
    private String color;
    private String brand;
    private String ownerName;
    private String ownerLastName;

    public Car(String ownerName, String ownerLastName, String brand, String color, String plate) {
        this.ownerName = ownerName;
        this.ownerLastName = ownerLastName;
        this.brand = brand;
        this.color = color;
        this.plate = plate;

    }

    public String getPlate() {
        return plate;
    }

    public void setPlate(String plate) {
        this.plate = plate;
    }

    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
    }

    public String getOwnerName() {
        return ownerName;
    }

    public void setOwnerName(String ownerName) {
        this.ownerName = ownerName;
    }

    public String getOwnerLastName() {
        return ownerLastName;
    }

    public void setOwnerLastName(String ownerLastName) {
        this.ownerLastName = ownerLastName;
    }
}
