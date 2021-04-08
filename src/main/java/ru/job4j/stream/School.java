package ru.job4j.stream;

import java.util.List;
import java.util.function.Predicate;
import java.util.stream.Collectors;

/**
 * Задание:
 * Студентов нужно поделить на следующие классы.
 * А диапазон балла [70: 100],
 * B диапазон балла [50: 70);
 * C диапазон балла (0: 50);
 * Создайте класс School c методом public List^Student> collect(
 * List^Student> students,
 * Predicate^Student> predict
 * ){
 * Так же нужно использовать Stream API. метод filter и метод collect(Collectors.toList())
 */
public class School {
    public List<Student> collect(
            List<Student> students,
            Predicate<Student> predict
    ) {
        return students.stream()
                .filter(predict)
                .collect(Collectors.toList());
    }
}
