package ru.job4j.collection;

import java.util.List;

public class ConvertList2Array {
    public static int[][] toArray(List<Integer> list, int cells) {
        int groups = (int) Math.ceil((double) list.size() / (double)cells);
        int[][] array = new int[groups][cells];
        int row = 0, cell = 0;
        for (int rowIndex = 0; rowIndex < cells; rowIndex++) {
            for (int cellIndex = 0; cellIndex < cells; cellIndex++) {
                if (row < list.size()) {
                    array[rowIndex][cellIndex] = list.get(row++);
                } else {
                    array[rowIndex][cellIndex] = 0;
                }
            }
        }
        return array;
    }

    public static void main(String[] args) {
        List<Integer> list = List.of(1, 2, 3, 4, 5, 6, 7);
        int[][]rsl = toArray(list, 3);
        for (int[] row : rsl) {
            for (int cell : row) {
                System.out.println(cell + " ");
            }
            System.out.println();
        }
    }
}
