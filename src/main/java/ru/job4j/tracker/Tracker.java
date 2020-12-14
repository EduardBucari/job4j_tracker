package ru.job4j.tracker;

import java.util.Arrays;


public class Tracker {
    private final Item[] items = new Item[100];
    private int ids = 1;
    private int size = 0;

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

  /* public Item findById(int id) {
          Item rsl = null;
          for (int index = 0; index < size; index++) {
             Item item = items[index];
             if (item.getId() == id) {
                 rsl = item;
                break;
           }
          }
         return rsl; */

        // Упрощаем метод  findById
        public Item findById(int id) {
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

   /* public boolean replace(int id, Item item) {
        int index = indexOf(id);
        if (index != -1) {
            item.setId(id);
            items[index] = item;
            return true;
        }
        return false;
    } */

      //добавляем валидацию параметров в метод replace();
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

   /* public boolean delete(int id) {
        int index = indexOf(id);
        if (index != -1) {
            int start = index + 1;
            int distPos = index;
            int length = size - index;

            System.arraycopy(items, start, items, distPos, length);
            items[size - 1] = null;
            size--;
          return true;
        }
        return false;
    }  */

    //добавляем валидацию параметров в метод delete();
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
