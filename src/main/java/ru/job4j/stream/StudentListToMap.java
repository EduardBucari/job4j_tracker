package ru.job4j.stream;

import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

/**
 * Задание:
 * 1. Создать список учеников. В качестве модели данных
 *    использовать класс Student из задания "Фильтрация учеников".
 * 2. Преобразовать список учеников в Map.
 *    Для этого нужно использовать collect c аргументом Collectors.toMap.
 * 3. В качестве ключа использовать фамилию ученика(String).
 * 4. В качестве значение использовать объект ученика(Student).
 * 5. Реализуйте следующую логику:
 *    Collectors.toMap(
 *         e -> e,
 *         e -> e * e )
 *   в методе, который на вход принимает список учеников.
 * 6. На реализованный метод напишите тесты.
 *    Важно! В исходном списке должны содержаться дубликаты.
 */
public class StudentListToMap {
    public Map<String, Student> listToMap(List<Student> students) {
        return students.stream()
                .collect(Collectors.toMap(
                        student -> student.getSurname(),
                        student -> student,
                        (o1, o2) -> o1
                ));
    }
}
