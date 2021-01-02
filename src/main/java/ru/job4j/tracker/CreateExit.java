package ru.job4j.tracker;

public class CreateExit implements UserAction {
    @Override
    public String name() {
        return "=== Exit ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Exit.");
        return false;
    }
}
