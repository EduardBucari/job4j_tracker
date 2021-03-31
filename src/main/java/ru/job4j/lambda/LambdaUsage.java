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

            Comparator<Attachment> byLength = (s1, s2) -> {
                System.out.println("compare - " + s1.getSize() + " : " + s2.getSize());
                return s1.getSize() - s2.getSize();
            };
    }
}