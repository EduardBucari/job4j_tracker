package ru.job4j.tracker;

import java.util.Arrays;

// Переделаем класс Tracker под шаблон singleton.

// 2. Так же нужно запретить наследование этого класса. Для этого используем ключевое слово final.
public final class Tracker {

    // 3.1 Добавим public static instance.
    private static Tracker instance = null;

    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

    // 1. Создать явный конструктор и указать у него модификатор private.
    // Таким образом, никто не сможет создать объект этого класса.
     Tracker() {   // private Tracker()
    }

    // 3. Добавим public static метод, чтобы другие классы могли получить ссылку на объект Tracker.
    // 3.2 Чтобы получить объект класса Tracker мы используем метод Tracker.getInstance().
    // в public class StartUI в методе main.
    public  static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
        items[size++] = item;
        return item;
    }

    public Item[] findAll() {
        return Arrays.copyOf(items, size);
    }

    public Item[] findByName(String key) {
        Item[] findByName = new Item[size];
        int sizeFBN = 0;
        for (int index = 0; index < this.size; index++) {
            Item name = items[index];
            if (items[index].getName().equals(key)) {
                findByName[sizeFBN] = name;
                sizeFBN++;
            }
        }
        return Arrays.copyOf(findByName, sizeFBN);
    }

        public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

    public boolean replace(int id, Item item) {
        int index = indexOf(id);
        item.setId(id);
        boolean rsl = index  != -1;
        if (rsl) {
            items[index] = item;
        }
        return rsl;
    }

    private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }

    public boolean delete(int id) {
        int index = indexOf(id);
        boolean rsl = index != -1;
        if (rsl) {
            int start = index + 1;
            int distPos = index;
            int length = size - index;

            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
            return rsl;
        }
        return false;
    }
}
