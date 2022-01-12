package com.brandon.designPattern._21_observer;

import java.util.ArrayList;
import java.util.List;

public class ObserverDemo {
    public static void main(String[] args) {
        Subject subject = new Subject();
        Observer binaryObserver = new BinaryObserver();
        Observer octalObserver = new OctalObserver();
        Observer hexObserver = new HexObserver();
        subject.attachObserver(binaryObserver).attachObserver(octalObserver).attachObserver(hexObserver);

        subject.setState(1);
        subject.setState(15);
    }
}

class Subject {
    private int state;
    private List<Observer> observers = new ArrayList<>();

    void setState(int state) {
        this.state = state;
        notifyObservers();
    }


    public Subject attachObserver(Observer observer) {
        this.observers.add(observer);
        return this;
    }

    void notifyObservers() {
        observers.forEach(observer -> observer.update(this.state));
    }
}

abstract class Observer {
    abstract void update(int state);
}

class BinaryObserver extends Observer {

    @Override
    void update(int state) {
        System.out.println("BinaryObserver : " + Integer.toBinaryString(state));
    }
}

class OctalObserver extends Observer {

    @Override
    void update(int state) {
        System.out.println("OctalObserver: " + Integer.toOctalString(state));
    }
}

class HexObserver extends Observer {
    @Override
    void update(int state) {
        System.out.println("HexObserver: " + Integer.toHexString(state));
    }
}
