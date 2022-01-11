package com.brandon.designPattern._9_bridge;

public class BridgeDemo {

    public static void main(String[] args) {
        Shape redCircle = new Circle(new RedCircle(), 1, 1, 2);
        Shape greenCircle = new Circle(new GreenCircle(), 2, 2, 3);
        redCircle.draw();
        greenCircle.draw();
    }
}

interface DrawAPI {
    public void drawCircle(int radius, int x, int y);
}

class RedCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println(String.format("Drawing circle [color: %s, radius: %d, x: %d, y: %d]", "red", radius, x, y));
    }
}

class GreenCircle implements DrawAPI {
    public void drawCircle(int radius, int x, int y) {
        System.out.println(String.format("Drawing circle [color: %s, radius: %d, x: %d, y: %d]", "Green", radius, x, y));
    }
}

// 使用一个抽象类作为桥，将drawApi桥接掉Circle对象上
abstract class Shape {
    protected DrawAPI drawAPI;

    protected Shape(DrawAPI drawAPI) {
        this.drawAPI = drawAPI;
    }

    public abstract void draw();
}


class Circle extends Shape {
    private int x, y, radius;

    public Circle(DrawAPI drawAPI, int x, int y, int radius) {
        super(drawAPI);
        this.x = x;
        this.y = y;
        this.radius = radius;
    }

    public void draw() {
        drawAPI.drawCircle(radius, x, y);
    }
}