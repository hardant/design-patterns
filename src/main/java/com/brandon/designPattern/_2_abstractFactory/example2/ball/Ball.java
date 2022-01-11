package com.brandon.designPattern._2_abstractFactory.example2.ball;

public class Ball {
    private String color;
    private String size;

    public Ball(String color, String size) {
        this.color = color;
        this.size = size;
    }

    public void show() {
        System.out.println(String.format("%s Ball with %s size", color, size));
    }
}
