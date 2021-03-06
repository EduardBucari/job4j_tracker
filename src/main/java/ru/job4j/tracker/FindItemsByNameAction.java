package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindItemsByNameAction implements UserAction {
    private final Output out;

    public FindItemsByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find items by name";
    }

     // заменим массивы на java.util.ArrayList.
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find items by name ===");
        String orderNames = input.askStr("Enter order names: ");
     //   Item[] rsl = tracker.findByName(orderNames);
     //   if (rsl.length > 0) {
     //       for (int i = 0; i < rsl.length; i++) {
     //           out.println(rsl[i]);
        List<Item> rsl = tracker.findByName(orderNames);
        if (rsl.size() > 0) {
            for (Item i : rsl) {
                out.println(i);
            }
        } else {
            out.println("Заявки с таким именем не найдены");
        }
        return true;
    }
}
