package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class ItemSorter {
    public static void main(String[] args) {
        List<Item> items = Arrays.asList(
                new Item(3, "Oleg"),
                new Item(1, "Ivan"),
                new Item(2, "Victor")
        );
        Collections.sort(items);
        Collections.sort(items, new ItemSortByName());
    }
}
