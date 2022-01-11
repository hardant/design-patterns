package com.brandon.designPattern._2_abstractFactory.example2.ballFactory;

public class BallFactoryCreator {

    public static BallFactory getBallFactory(String color) {
        if (color ==  null ) {
            return null;
        } else if (color.equals("Red")) {
            return new RedBallFactory();
        } else if (color.equals("Green")) {
            return new GreenBallFactory();
        }
        return  null;
    }
}
