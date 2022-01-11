package com.brandon.designPattern._3_singleton;

public class A {
    private static A a = new A();
    private A() {}

    public static A getA(){
        return a;
    }
}
