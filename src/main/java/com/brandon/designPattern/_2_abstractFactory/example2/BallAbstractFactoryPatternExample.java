package com.brandon.designPattern._2_abstractFactory.example2;

import com.brandon.designPattern._2_abstractFactory.example2.ball.Ball;
import com.brandon.designPattern._2_abstractFactory.example2.ballFactory.BallFactory;
import com.brandon.designPattern._2_abstractFactory.example2.ballFactory.BallFactoryCreator;

public class BallAbstractFactoryPatternExample {
    public static void main(String[] args) {
        BallFactory redBallFactory = BallFactoryCreator.getBallFactory("Red");
        Ball largeRedBall = redBallFactory.getBoll("large");
        largeRedBall.show();
        Ball smallRedBall = redBallFactory.getBoll("small");
        smallRedBall.show();
    }
}
