package com.brandon.designPattern._2_abstractFactory.example2.ballFactory;

import com.brandon.designPattern._2_abstractFactory.example2.ball.Ball;

public class GreenBallFactory extends BallFactory {

    public Ball getBoll(String size) {
        return new Ball("Green", size);
    }
}
