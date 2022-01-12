package com.brandon.designPattern._17_interpreter;

public class InterpreterDemo {
}

interface Expression {
    boolean interpret(String context);
}

class TerminalExpression implements Expression {
    private String data;

    public TerminalExpression(String data) {
        this.data = data;
    }

    public boolean interpret(String context) {
        if (context.contains(data)) {
            return true;
        }

        return false;
    }
}


