package ru.job4j.tracker;

public class FindItemsByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find items by name ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String orderNames = input.askStr("Enter order names: ");
        Item[] rsl = tracker.findByName(orderNames);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
