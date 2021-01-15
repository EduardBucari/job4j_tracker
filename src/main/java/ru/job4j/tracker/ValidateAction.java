package ru.job4j.tracker;

public class ValidateAction implements UserAction {

    private final Input input;
    public ValidateAction(Input input) {
        this.input = input;
    }

    @Override
    public String name() {
        return "Validate";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        return true;
    }
}
