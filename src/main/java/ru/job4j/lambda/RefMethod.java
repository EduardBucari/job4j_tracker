package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;

/**
 * Класс RefMethod выводит на консоль список имен.
 * Если имя больше 10 символов, то вывод обрезается.
 * Нужно упростить вызов лямбда за счет оператора (::)
 */
public class RefMethod {
    public static void main(String[] args) {
        List<String> names = Arrays.asList(
                "Ivan",
                "Petr Arsentev"
        );
        Consumer<String> out = (name) -> cutOut(name);
    }
    public static void cutOut(String value) {
        if (value.length() > 10) {
            System.out.println(value.substring(0, 10) + "...");
        } else {
            System.out.println(value);
        }
    }
}
