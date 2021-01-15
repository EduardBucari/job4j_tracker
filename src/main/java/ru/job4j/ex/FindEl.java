package ru.job4j.ex;

public class FindEl {
    //indexOf - метод поиска индекса элемента в строковом массиве.
    public static int indexOf(String[] value, String key) throws ElementNotFoundException {
        int rsl = -1;
          for (int index = 0; index < value.length; index++) {
             if (value[index].equals(key)) {
                 return index;
             }
          }
        throw new ElementNotFoundException("The element is not found.");
    }

    public static void main(String[] args) {
        try {
            indexOf(new String[]{"1", "2", "3", "4", "5"}, "20");
        } catch (ElementNotFoundException e) {
            e.printStackTrace();
        }
    }
}
