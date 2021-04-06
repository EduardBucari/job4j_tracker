package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.Arrays;

/**
 * Задание.
 * 1. Создайте ArrayList. Заполните его числами Integer.
 * 2. Получите из ArrayList поток данных. Отфильтруйте поток так,
 *   чтобы в нем остались только положительные числа.
 * 3. Отфильтрованный поток запишите в List.
 */
public class StreamUsage {
    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(11, 3, -20, 18, 30, 5, -19, 77);
        List<Integer> result = numbers.stream().filter(number -> number > 0)
                .collect(Collectors.toList());
        System.out.println(result);
    }
}