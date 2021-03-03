package ru.job4j.tracker;

import org.junit.Test;

import java.security.PublicKey;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

  //тесты с демонстрацией сортировки по возрастанию и убыванию.
public class ItemSorterTest {

    @Test
      public void whenAscendingOrderTest() {
        List<Item> items = Arrays.asList(
                new Item(1, "Ivan"),
                new Item(2, "Victor"),
                new Item(3, "Oleg")
        );
        List<Item> items1 = ItemSorter.main(items);
        assertThat(items1.sort(), is(new Item()));

    }

    @Test
      public void whenDescendingOrderTest() {
        List<Item> items = Arrays.asList(
                new Item(3, "Oleg"),
                new Item(2, "Victor"),
                new Item(1, "Ivan")
        );
    }
}