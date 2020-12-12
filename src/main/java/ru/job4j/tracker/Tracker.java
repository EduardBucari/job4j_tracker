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
        for (int index  = 0; index < this.size; index++) {
            Item name = items[index];
            if (items[index].getName().equals(key)) {
                findByName[sizeFBN] = name;
                sizeFBN++;
            }
        }
        return Arrays.copyOf(findByName, sizeFBN);
    }

    public Item findById(int id) {
      //  Item rsl = null;
      //  for (int index = 0; index < size; index++) {
       //     Item item = items[index];
       //     if (item.getId() == id) {
       //         rsl = item;
        //        break;
        //   }
       //  }
       // return rsl;

      // Упрощаем метод  findById
        int index = indexOf(id);
        return index != -1 ? items[index] : null;
    }

     public boolean replace(int id, Item item) {
        int index = indexOf(id);
             if (index != -1) {
                 item.setId(id);
                 items[index] = item;
                 return true;
             }
         return false;
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
            items[indexOf(id)] = null;
            return true;

            System.arraycopy(items, int start, items, int distPos, int length);
                int index = indexOf(id);
                start = index + 1;
                distPos = index;
                length = size - index;
                items[size - 1] = null;
                size--;

     }
}

