package ru.job4j.stream.attestation;

import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.stream.Stream;
import java.util.stream.Collectors;

/**
 * Класс Analyze, где будет выполнена реализация логики.
 * В этом классе главная задача это - реализовать класс для подсчета
 * статистики по аттестатам учеников, т.е. получить статистику по аттестатам.
 * Для реализации класса Analyze необходимо реализовать 5 следующих методов:
 * - averageScore()
 * - averageScoreBySubject()
 * - averageScoreBySubject()
 * - bestStudent()
 * - bestSubject()
 *
 * Все методы нужно реализовывать в одном потоке, т.е.
 * пишете return и последовательно вызываете все методы.
 *
 * Результат протестировать на готовых тестах класса AnalyzeTest.
 */
public class Analyze {

    /**
     * 1. Метод averageScore вычисляет общий средний балл.
     *    для реализации понадобятся методы:
     * - flatMap() для преобразования в поток объектов Subject;
     * - mapToInt() для последующего преобразования в потом оценок по каждому предмету;
     * - average() для расчета среднего бала по предмету;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * @param stream Поток объектов типа Pupil;
     * @return Возвращает общий средний балл.
     */
    public static double averageScore(Stream<Pupil> stream) {
        return stream
                .flatMap(str -> str.getSubjects().stream())
                .mapToInt(Subject::getScore)
                .average()
                .orElse(0D);
    }

    /**
     * 2. Метод averageScoreBySubject вычисляет средний балл ученика по его предметам.
     *    Поскольку нам надо выполнить преобразование в поток объектов класса Tuple,
     *    последовательность будет следующей:
     * - метод map() для преобразования в поток объектов класса Tuple,
     *   внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - при этом в конструктор первым параметром будет передаваться
     *   имя текущего объекта Pupil - используем соответствующий геттер;
     * - вторым параметром рассчитанный средний балл - расчет можно произвести
     *   по той же последовательности, что описана для метода averageScore;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     *
     * @param stream Поток объектов типа Pupil;
     * @return Возвращает список из объекта Tuple (имя ученика и средний балл).
     */
    public static List<Tuple> averageScoreBySubject(Stream<Pupil> stream) {
        return stream
                .map(e -> new Tuple(e.getName(), e.getSubjects()
                    .stream()
                    .mapToInt(Subject::getScore)
                    .average()
                    .orElse(0D)))
                .collect(Collectors.toList());
    }

    /**
     * 3. Метод averageScoreByPupil вычисляет средний балл
     *    по всем предметам для каждого ученика.
     *    Реализация этого метода сложнее, поскольку в данном случае требуется выполнить
     *    промежуточный сбор данных в Map(). Опишем вкратце алгоритм:
     * - flatMap() для преобразования в поток объектов Subject;
     * - метод collect() в который мы передаем метод groupingBy()
     *   (минимум с двумя параметрами) класса Collectors.
     *   При этом карта собирается следующим образом: ключ - это имя предмета,
     *   значение - средний балл по этому предмету для каждого ученика.
     *   Для расчета среднего балла используйте метод averagingDouble() класса Collectors;
     * - после этого собранную карту мы разбираем с помощью entrySet()
     *   и открываем поток с помощью stream();
     * - полученный поток с помощью map() преобразуем в поток объектов класса Tuple,
     *   внутри метода мы будем создавать эти объекты - там будет фигурировать строка new Tuple();
     * - в конструктор мы будем передавать параметры с помощью методов getKey()
     *   и getValue() интерфейса Entry;
     * - последним методом будет collect(), с помощью которого мы все соберем в коллекцию List.
     *
     * @param stream Поток объектов типа Pupil;
     * @return Возвращает список из объекта Tuple (название предмета и средний балл).
     */
    public static List<Tuple> averageScoreByPupil(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName, LinkedHashMap::new,
                       Collectors.averagingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .collect(Collectors.toList());
    }

    /**
     * 4. Метод bestStudent - возвращает лучшего ученика.
     *    Лучшим считается ученик с наибольшим баллом по всем предметам.
     *    Для реализации данного метода можно использовать метод averageScoreBySubject
     *    за исключением следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл,
     *   а не средний - поэтому вместо average() нужно использовать метод sum();
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     *   в который будем передавать компаратор.
     *   При этом компаратор определит объект Tuple, у которого
     *   значение Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * @param stream Поток объектов типа Pupil;
     * @return Возвращает лучшего ученика, с наибольшим баллом по всем предметам.
     */
    public static Tuple bestStudent(Stream<Pupil> stream) {
        return stream
                .map(pupil -> new Tuple(pupil.getName(), pupil.getSubjects()
                    .stream()
                    .mapToInt(Subject::getScore)
                    .sum()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }

    /**
     * 5. Метод bestSubject - возвращает предмет с наибольшим баллом для всех студентов.
     *    Возвращает объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету).
     *    Для реализации данного метода можно использовать метод averageScoreByPupil
     *    за исключением следующих особенностей:
     * - в данном методе мы рассчитываем суммарный балл, а не средний - поэтому
     *   вместо averagingDouble() нужно использовать метод summingDouble();
     * - терминальной операцией будет не метод collect(), а использование метода max(),
     *   в который будем передавать компаратор.
     *   При этом компаратор определит объект Tuple, у которого значение Score будет максимальным;
     * - orElse() для того чтобы вернуть значение по умолчанию.
     *
     * Все методы нужно реализовывать в одном потоке, т.е. пишете return
     * и последовательно вызываете все методы, о которых было указано выше.
     *
     * @param stream Поток объектов типа Pupil;
     * @return Возвращает предмет с наибольшим баллом для всех студентов т.е.
     *         объект Tuple (имя предмета, сумма баллов каждого ученика по этому предмету)
     */
    public static Tuple bestSubject(Stream<Pupil> stream) {
        return stream
                .flatMap(pupil -> pupil.getSubjects().stream())
                .collect(Collectors.groupingBy(Subject::getName,
                        Collectors.summingDouble(Subject::getScore)))
                .entrySet()
                .stream()
                .map(e -> new Tuple(e.getKey(), e.getValue()))
                .max(Comparator.comparing(Tuple::getScore))
                .orElse(null);
    }
}
