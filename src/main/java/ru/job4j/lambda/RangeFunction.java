package ru.job4j.lambda;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;

/**
 * Основная задача - реализовать метод подсчета функции в диапазоне от start до end.
 *
 * В задании необходимо использовать только встроенные функциональные интерфейсы.
 * ФункциональныЙ интерфейс Function представляет функцию,
 * которая принимает аргумент и выдает результат используя метод apply();
 * Function используется для преобразования входных параметров, т.е.
 * тип возвращаемого значения может не совпадать с типом входных параметров.
 *
 * Для перебора коллекции в цикле for необходимо учитывать первый и последний элемент,
 * поэтому используем индекс в диапозоне от i = start до i <= end;
 *
 * Реализовать функции в тестах через new RangeFunction().
 */
public class RangeFunction {
    List<Double> diapason(int start, int end, Function<Double, Double> func) {
        List<Double> result = new ArrayList<>();
        for (double i = start; i <= end; i++) {
            result.add(func.apply(i));
        }
        return result;
    }
}


