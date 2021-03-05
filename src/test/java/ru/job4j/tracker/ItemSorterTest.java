package ru.job4j.tracker;

import org.junit.Test;

import java.security.PublicKey;
import java.util.*;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

  //тесты с демонстрацией сортировки по возрастанию и убыванию.
public class ItemSorterTest {

    @Test
      public void whenAscendingOrderTest() {
        List<Item> items = Arrays.asList(
                new Item(3, "Oleg"),
                new Item(1, "Ivan"),
                new Item(2, "Victor")
        );
        List<Item> expected = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(3, "Oleg"),
                new Item(2, "Victor")
        );
        items.sort(new ItemSortByName());
        assertThat(items, is(expected));

    }

    @Test
      public void whenDescendingOrderTest() {
        List<Item> items = Arrays.asList(
                new Item(3, "Oleg"),
                new Item(1, "Ivan"),
                new Item(2, "Victor")
        );
        List<Item> expected = Arrays.asList(
                new Item(2, "Victor"),
                new Item(3, "Oleg"),
                new Item(1, "Ivan")
        );
        Collections.sort(items, new ItemSortByName());
        assertThat(items, is(expected));
    }
}