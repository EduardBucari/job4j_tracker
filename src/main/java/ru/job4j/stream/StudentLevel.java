package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Задание
 * 1. Используя модель данных class Student,
 *    реализовать фильтрацию учеников по проходному баллу (score).
 * 2. Необходимо реализовать метод List^Student> levelOf(List^Student> students, int bound);
 *    Метод должен вернуть список студентов, у которых балл аттестата больше bound.
 *
 *    Во входящем списке могут быть null элементы,
 *
 * Порядок действий.
 * - Используя метод filter убрать null;  .filter(st -> st != null) но
 *   (Stream.ofNullable - сделает из элемента поток, если элемент равен null,
 *   то элемент пропускается. Этот метод позволяет фильтровать поток с null элементами).
 * - Отсортировать список;
 * - Используя метод takeWhile, получить нужный поток;
 * - Сохранить поток в List.
 *
 * 3. Протестировать в готовом тесте StudentLevelTest
 */
public class StudentLevel {
    public static List<Student> levelOf(List<Student> students, int bound) {
        return students.stream()
                .flatMap(student -> Stream.ofNullable(student))
             // или .flatMap(Stream::ofNullable)
                .sorted((left, right) -> Integer.compare(right.getScore(), left.getScore()))
                .takeWhile(st -> st.getScore() > bound)
                .collect(Collectors.toList());
    }
}
