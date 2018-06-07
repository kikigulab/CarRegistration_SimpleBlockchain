package com.carregistration.model;

import java.util.Arrays;

public class MyBlock {
    private int previousHash;
    Car car;
    private int blockHash;

    public MyBlock(int previousHash, Car car) {
        this.previousHash = previousHash;
        this.car = car;

        //generating the hash of this block using the previous block hash and the car object
        Object[] contents = {car.hashCode(), previousHash};
        this.blockHash = Arrays.hashCode(contents);
    }

    public int getPreviousHash() {
        return previousHash;
    }

    public Car getCar() {
        return car;
    }

    public int getBlockHash() {
        return blockHash;
    }
}
