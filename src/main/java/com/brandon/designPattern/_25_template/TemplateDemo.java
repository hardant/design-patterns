package com.brandon.designPattern._25_template;

public class TemplateDemo {

    public static void main(String[] args) {
        Game footBall = new FootBall();
        footBall.play();

        System.out.println("--------");

        Game cricket = new Cricket();
        cricket.play();
    }
}

abstract class Game {
    protected abstract void initialize();
    protected abstract void startPlay();
    protected abstract void stopPlay();

    // template method
    public final void play() {
        // initialize the game;
        initialize();
        // start game
        startPlay();
        // end game
        stopPlay();
    }
}

class FootBall extends Game {
    @Override
    protected void initialize() {
        System.out.println("Foot ball game initialized! start playing");
    }

    @Override
    protected void startPlay() {
        System.out.println("Foot ball game started, enjoy the game!");
    }

    @Override
    protected void stopPlay() {
        System.out.println("Foot ball game finished");
    }
}

class Cricket extends Game {
    @Override
    protected void initialize() {
        System.out.println("Cricket ball game initialized! start playing");
    }

    @Override
    protected void startPlay() {
        System.out.println("Cricket ball game started, enjoy the game!");
    }

    @Override
    protected void stopPlay() {
        System.out.println("Cricket ball game finished");
    }
}
