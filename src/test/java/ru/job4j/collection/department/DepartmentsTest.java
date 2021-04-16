package ru.job4j.collection.department;

import org.junit.Test;
import java.util.List;

import static org.hamcrest.Matchers.*;
import static org.junit.Assert.assertThat;

public class DepartmentsTest {
    @Test
    public void whenMissed() {
        List<String> input = List.of("k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenNonChange() {
        List<String> input = List.of("k1", "k1/sk1");
        List<String> expect = List.of("k1", "k1/sk1");
        List<String> result = Departments.fillGaps(input);
        assertThat(result, is(expect));
    }

    @Test
    public void whenAscendingSorting() {
        List<String> input = List.of("k2/sk3/ssk1", "k2", "k1", "k2/sk1", "k1/sk1/ssk1");
        Departments.sortAsc(Departments.fillGaps(input));
    }

    @Test
    public void whenDescendingSorting() {
        List<String> input = List.of("k2/sk3/ssk1", "k2", "k1", "k2/sk1", "k1/sk1/ssk1");
        Departments.sortDesc(Departments.fillGaps(input));
    }

    @Test
    public void whenFirstElementsDescendingEquals() {
        assertThat(new DepDescComp().compare("k1/sk1/ssk2", "k1/sk1/ssk1"), greaterThan(0));
    }

    @Test
    public void whenFirstElementsDescendingDifferent() {
        assertThat(new DepDescComp().compare("k2/sk1/ssk1", "k1/sk1/ssk1"), lessThan(0));
    }

}