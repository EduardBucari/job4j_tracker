package ru.job4j.lambda;

import java.util.Arrays;
import java.util.ArrayList;
import java.util.List;
import java.util.Comparator;

public class LambdaUsage {
    public static void main(String[] args) {

            List<String> books = new ArrayList<>(Arrays.asList(
                    "Effective Java",
                    "Algorithms",
                    "Refactoring"
            ));

        System.out.println("Before sort:");
         for (String temp : books) {
             System.out.println(temp);
         }

            Comparator<String> comparator = (s1, s2) -> {
                System.out.println("After sort:");
                 return s1.length() - s2.length();
                 books.sort(comparator.reversed());
            };

        for (String temp : books) {
            System.out.println(temp);
        }

    }
}