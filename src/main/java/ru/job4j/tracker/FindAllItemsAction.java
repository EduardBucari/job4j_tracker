package ru.job4j.tracker;

import java.util.ArrayList;
import java.util.List;

public class FindAllItemsAction implements UserAction {
    private final Output out;

    public FindAllItemsAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Show all items";
    }
    //заменим массивы на java.util.ArrayList.

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Show all items ===");
     //   Item[] rsl = tracker.findAll();
     //   for (int i = 0; i < rsl.length; i++) {
     //       out.println(rsl[i]);
        List<Item> rsl = tracker.findAll();
        if (rsl.size() > 0) {
            for (Item i : rsl) {
                out.println(i);
            }
        }
        return true;
    }
}
