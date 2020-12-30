package ru.job4j.tracker;

public class FindAllItemsAction implements UserAction {
    @Override
    public String name() {
        return "=== Show all items ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        Item[] rsl = tracker.findAll();
        for (int i = 0; i < rsl.length; i++) {
            System.out.println(rsl[i]);
        }
        return true;
    }
}
