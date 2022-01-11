package com.brandon.designPattern._2_abstractFactory.example2.ballFactory;

import com.brandon.designPattern._2_abstractFactory.example2.ball.Ball;

public abstract class BallFactory {
    public abstract Ball getBoll(String size);
}
