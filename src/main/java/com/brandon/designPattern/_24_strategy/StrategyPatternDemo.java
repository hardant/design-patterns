package com.brandon.designPattern._24_strategy;

import javax.swing.*;

public class StrategyPatternDemo {


    public static void main(String[] args) {
        Context context = new Context(5, 4);
        context.setStrategy(new OperationAdd());
        context.exeStrategy();

        context.setStrategy(new OperationSubtract());
        context.exeStrategy();

        context.setStrategy(new OperationMultiply());
        context.exeStrategy();
    }
}

interface Strategy {
    void doOperation(int num1, int num2);
}

class OperationAdd implements Strategy {
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println(String.format("num1 + num2 = %d", num1 + num2));
    }
}

class OperationSubtract implements Strategy {
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println(String.format("num1 - num2 = %d", num1 - num2));
    }
}

class OperationMultiply implements Strategy {
    @Override
    public void doOperation(int num1, int num2) {
        System.out.println(String.format("num1 * num2 = %d", num1 * num2));
    }
}

class Context {
    int num1, num2;
    Strategy strategy;

    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public Context(int num1, int num2) {
        this.num1 = num1;
        this.num2 = num2;
    }

    void exeStrategy() {
        strategy.doOperation(num1, num2);
    }
}
