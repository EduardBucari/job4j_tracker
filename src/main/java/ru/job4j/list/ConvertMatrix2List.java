package ru.job4j.list;

import java.util.ArrayList;
import java.util.List;

/*
Метод toList - принимает двухмерный массив array.
нужно пройти по всем элементам этого массива и добавить его в одномерный список list.
Для прохода по двухмерному массиву нужно использовать вложенный цикл for-each.
 */

public class ConvertMatrix2List {
    public List<Integer> toList(int[][] array) {
        List<Integer> list = new ArrayList<>();
         for (int[] row : array) {
            for (int cell : row) {
                list.add(cell);
            }
         }
        return list;
    }
}
