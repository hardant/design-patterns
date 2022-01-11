package com.brandon.designPattern._2_abstractFactory.example2.ballFactory;

import com.brandon.designPattern._2_abstractFactory.example2.ball.Ball;

public class RedBallFactory extends BallFactory {
    public Ball getBoll(String size) {
        return new Ball("Red", size);
    }
}
