package ru.job4j.stream;

import org.junit.Test;

import java.util.Map;
import java.util.List;
import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class StudentListToMapTest {

    @Test
    public void whenStudentListToMap() {
        List<Student> students = Arrays.asList(
                new Student(20, "Alex"),
                new Student(80, "David"),
                new Student(40, "Victor"),
                new Student(80, "David")
        );
        Map<Integer, Student> result = new StudentListToMap().listToMap(students);
        assertThat(result.size(), is(3));
    }
}