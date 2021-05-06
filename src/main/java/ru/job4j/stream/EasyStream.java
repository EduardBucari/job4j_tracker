package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * В этом задании Вам нужно реализовать каркас упрощенного Stream API.
 * class EasyStream работает только с типом Integer. В нем есть четыре метода:
 * of - получает исходные данные.
 * map - преобразует число в другое число.
 * filter - фильтрует поток элементов.
 * collect - собирает все элементы из source по заданным условиям map и filter.
 *
 * Проверьте реализацию тестами.
 */
public class EasyStream {
    public static EasyStream of(List<Integer> source) {
        throw new UnsupportedOperationException();
    }

    public EasyStream map(Function<Integer, Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public EasyStream filter(Predicate<Integer> fun) {
        throw new UnsupportedOperationException();
    }

    public List<Integer> collect() {
        throw new UnsupportedOperationException();
    }
}
