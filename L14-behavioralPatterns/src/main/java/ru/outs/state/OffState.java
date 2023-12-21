package ru.outs.state;


public class OffState implements State {
    @Override
    public State action() {
        System.out.println("off");
        return StateProvider.getOnState();
    }
}
