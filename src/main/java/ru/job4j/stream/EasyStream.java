package ru.job4j.stream;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Function;
import java.util.function.Predicate;

/**
 * В этом задании Вам нужно реализовать каркас упрощенного Stream API.
 * class EasyStream работает только с типом Integer. В нем есть четыре метода:
 * of - получает исходные данные.
 * map - преобразует число в другое число.
 * filter - фильтрует поток элементов.
 * collect - собирает все элементы из source по заданным условиям map и filter.
 *
 * В этом задании нужно использовать шаблон Builder.
 * Проверьте реализацию тестами.
 */
public class EasyStream {
    private final List<Integer> source;

    public EasyStream(List<Integer> source) {
        this.source = source;
    }

    /**
     * метод of - получает исходные данные.
     * @param source - Список данных целочисленного типа.
     * @return - Объект типа EasyStream.
     */
    public static EasyStream of(List<Integer> source) {
        return new EasyStream(source);
    }

    /**
     * метод map - преобразует число в другое число.
     * @param fun - Функция преобразования Integer в Integer.
     * @return - Объект типа EasyStream.
     */
    public EasyStream map(Function<Integer, Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (Integer element : source) {
            list.add(fun.apply(element));
        }
        return new EasyStream(list);
    }

    /**
     * метод filter - фильтрует поток элементов.
     * @param fun - Предикат целочисленного типа.
     * @return - Объект типа EasyStream.
     */
    public EasyStream filter(Predicate<Integer> fun) {
        List<Integer> list = new ArrayList<>();
        for (Integer element : source) {
            if (fun.test(element)) {
                list.add(element);
            }
        }
        return new EasyStream(list);
    }

    /**
     * метод collect - собирает все элементы из source по заданным условиям map и filter.
     * @return - Коллекцию ArrayList с числами целочисленного типа.
     */
    public List<Integer> collect() {
        return new ArrayList<>(source);
    }
}
