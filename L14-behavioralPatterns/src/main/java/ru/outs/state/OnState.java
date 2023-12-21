package ru.outs.state;

public class OnState implements State {
    @Override
    public State action() {
        System.out.println("on");
        return StateProvider.getOffState();
    }
}
