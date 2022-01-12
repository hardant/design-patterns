package com.brandon.designPattern._22_statePattern;

/**
 * In State pattern a class behavior changes based on its state.
 *
 * In state pattern we create object which represent various states and a
 * context object whose behavior varies as its state object changes;
 */
public class StatePatternDemo {
    public static void main(String[] args) {
        Context context = new Context();
        StartState startState = new StartState();
        context.setState(startState);
        context.doAction();
        System.out.println(context.getState());

        StopState stopState = new StopState();
        context.setState(stopState);
        context.doAction();

        System.out.println(context.getState());
    }
}

class Context {
    private State state;

    public State getState() {
        return state;
    }

    public void setState(State state) {
        this.state = state;
    }

    public void doAction() {
        this.state.doAction(this);
    }
}

interface State {
    void doAction(Context context);
}

class StartState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in start state");
    }

    @Override
    public String toString() {
        return "Start state";
    }
}

class StopState implements State {
    @Override
    public void doAction(Context context) {
        System.out.println("Player is in Stop state");
    }

    @Override
    public String toString() {
        return "Stop state";
    }
}