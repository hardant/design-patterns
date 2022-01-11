package com.brandon.designPattern._3_singleton;

public class B {
    private static B b;

    private static B getB() {
        if (b == null) {
            synchronized (B.class) {
                if (b == null) {
                    b = new B();
                }
            }
        }
        return b;
    }
}
