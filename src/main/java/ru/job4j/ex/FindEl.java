package ru.job4j.ex;

public class FindEl {
    public static int indexOf(String[] value, String key) throws ElementNotFoundException { //метод поиска индекса элемента в строковом массиве.
        int rsl = -1;
          for (int index = 0; index < value.length; index++) {
             if (value[index] == null) {
                 throw new ElementNotFoundException("The element is not found.");
             }
          }
        return rsl;
    }

    public static void main(String[] args) {
        try {
            indexOf("", "");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
