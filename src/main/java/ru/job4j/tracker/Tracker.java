package ru.job4j.tracker;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;

public final class Tracker {

    private static Tracker instance = null;

 //  нужно будет заменить массивы на java.util.ArrayList.
 //Основное изменение будет в получении и вставки данных в коллекцию.

 //   private final Item[] items = new Item[100];
    ArrayList<Item> items = new ArrayList<>();
    private int ids = 1;
    private int size = 0;




     Tracker() {   // private Tracker()
    }

    public  static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }

    public Item add(Item item) {
        item.setId(ids++);
      //  items[size++] = item;
        items.add(item);
        return item;
    }

    //public Item[] findAll() {
       // return Arrays.copyOf(items, size);
    public List<Item> findAll() {
        return items;
    }

  /*  public Item[] findByName(String key) {
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
    */

    public List<Item> findByName(String key) {
        List<Item> rsl = new ArrayList<>();
        for (Item i : items) {
            if (i.getName().equals(key)) {
                rsl.add(i);
            }
        }
        return rsl;
    }

        public Item findById(int id) {
      //  int index = indexOf(id);
      //  return index != -1 ? items[index] : null;
            Item rsl  = null;
            for (Item i : items) {
                if (i.getId() == id) {
                    rsl = i;
                    break;
                }
            }
            return rsl;
    }

    public boolean replace(int id, Item item) {
      /*  int index = indexOf(id);
        item.setId(id);
        boolean rsl = index  != -1;
        if (rsl) {
            items[index] = item;
        }  */

        boolean rsl = false;
        for (int i = 0; i != items.size(); i++) {
            if (items.get(i).getId() == id) {
                items.set(i, item);
                rsl = true;
                break;
            }
        }
        return rsl;
    }

  /*  private int indexOf(int id) {
        int rsl = -1;
        for (int index = 0; index < size; index++) {
            if (items[index].getId() == id) {
                rsl = index;
                break;
            }
        }
        return rsl;
    }  */

 /*   public boolean delete(int id) {
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
    }  */

    public boolean delete(int id) {
        boolean rsl = false;
        for (int i = 0; i != items.size(); i++) {
          if (items.get(i).getId() == id) {
              items.remove(i);
              rsl = true;
              break;
          }
        }
        return rsl;
    }
}
