package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction {
    private final Output out;
    public FindItemsByNameAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Find items by name";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String orderNames = input.askStr("Enter order names: ");
        Item[] rsl = tracker.findByName(orderNames);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                out.println(rsl[i]);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
