package ru.job4j.stream;

import org.junit.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Создайте класс - тест SchoolTest с тремя методами для получения
 * списка учеников для классов: А, B, C.
 * В тесте необходимо дописать Predicate^Student> с помощью лямбда:
 */
public class SchoolTest {

    @Test
    public void whenCollectClassA() {
        List<Student> students = List.of(
            new Student(10, "Surname1"),
            new Student(40, "Surname4"),
            new Student(50, "Surname5"),
            new Student(70, "Surname7"),
            new Student(90, "Surname9")
        );
        School sc = new School();

      //  Predicate<Student> pr = ... (необходимо дописать Predicate^Student> с помощью лямбда);
        Predicate<Student> pr1 = student -> student.getScore() >= 70;
        Predicate<Student> pr2 = student -> student.getScore() <= 100;
        Predicate<Student> pr = pr1.and(pr2);

        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(70, "Surname7"));
        expected.add(new Student(90, "Surname9"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassB() {
        List<Student> students = List.of(
                new Student(20, "Surname2"),
                new Student(30, "Surname3"),
                new Student(50, "Surname5"),
                new Student(60, "Surname6"),
                new Student(80, "Surname8")
        );
        School sc = new School();

        //  Predicate<Student> pr = ... (необходимо дописать Predicate^Student> с помощью лямбда);
        Predicate<Student> pr1 = student -> student.getScore() >= 50;
        Predicate<Student> pr2 = student -> student.getScore() < 70;
        Predicate<Student> pr = pr1.and(pr2);

        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(50, "Surname5"));
        expected.add(new Student(60, "Surname6"));
        assertThat(rsl, is(expected));
    }

    @Test
    public void whenCollectClassC() {
        List<Student> students = List.of(
                new Student(10, "Surname1"),
                new Student(30, "Surname3"),
                new Student(40, "Surname4"),
                new Student(60, "Surname6"),
                new Student(90, "Surname9")
        );
        School sc = new School();

        //  Predicate<Student> pr = ... (необходимо дописать Predicate^Student> с помощью лямбда);
        Predicate<Student> pr1 = student -> student.getScore() > 0;
        Predicate<Student> pr2 = student -> student.getScore() < 50;
        Predicate<Student> pr = pr1.and(pr2);

        List<Student> rsl = sc.collect(students, pr);
        List<Student> expected = new ArrayList<>();
        expected.add(new Student(10, "Surname1"));
        expected.add(new Student(30, "Surname3"));
        expected.add(new Student(40, "Surname4"));
        assertThat(rsl, is(expected));
    }
}