package ru.job4j.collection;

import java.util.Comparator;

// Задача - Реализуйте класс ru.job4j.collection.StringCompare.
// Необходимо реализовать поэлементное сравнение двух списков,
// т.е. сравниваем элементы двух списков, находящихся на одних и тех же позициях
// (под одним и тем же индексом). Сравнение в лексикографическом порядке.
// В этом задании нельзя использовать метод String.compareTo.
// Нужно использовать:
// String.charAt(int index);
// Integer.compare(int left, int right);
// Character.compare(char left, char right);

public class StringCompare implements Comparator<String> {
    @Override
    public int compare(String left, String right) {

        int leftLength = left.length();
        int rightLength = right.length();
        int result = 0;
        int wordSize = Math.min(leftLength, rightLength);

        for (int i = 0; i < wordSize; i++) {
            result = Character.compare(left.charAt(i), right.charAt(i));
            if (result != 0) {
                return result;
            }
        }
        return Integer.compare(leftLength, rightLength);
    }
}
