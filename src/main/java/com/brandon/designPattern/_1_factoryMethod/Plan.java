package com.brandon.designPattern._1_factoryMethod;

public abstract class Plan {
    protected double rate;

    public void calculateBill(int units) {
        System.out.println(units * rate);
    }
}
