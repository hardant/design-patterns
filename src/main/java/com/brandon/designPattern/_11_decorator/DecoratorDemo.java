package com.brandon.designPattern._11_decorator;

public class DecoratorDemo {

    public static void main(String[] args) {
        Rectangle rectangle = new Rectangle();
        RedShapeDecorator redShapeDecorator = new RedShapeDecorator(rectangle);
        redShapeDecorator.draw();

        Circle circle = new Circle();
        ShapeDecorator greenShapeDecorator = new GreenShapeDecorator(circle);
        greenShapeDecorator.draw();
    }
}

interface Shape {
    void draw();
}

class Rectangle implements Shape {

    public void draw() {
        System.out.println("Shape: Rectangle");
    }
}

class Circle implements Shape {
    public void draw() {
        System.out.println("Shape: Circle");
    }
}

abstract class ShapeDecorator implements Shape {
    protected Shape decoratedShape;

    public void draw() {
        decoratedShape.draw();
    }
}

class RedShapeDecorator extends ShapeDecorator {

    public RedShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw() {
        super.draw();
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Border color: Red");
    }
}

class GreenShapeDecorator extends ShapeDecorator {
    public GreenShapeDecorator(Shape decoratedShape) {
        this.decoratedShape = decoratedShape;
    }
    @Override
    public void draw() {
        super.draw();
        setRedBorder();
    }

    private void setRedBorder() {
        System.out.println("Border color: Green");
    }
}