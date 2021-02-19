package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class FullSearch {
    public static HashSet<String> extractNumber(List<Task> list) {
        HashSet<String> numbers = new HashSet<>();
        // в цикле мы должны перебирать список list и складывать номера задач в numbers
        for (String n : list) {
             numbers.add(n);
        }
        return numbers;
    }
}
