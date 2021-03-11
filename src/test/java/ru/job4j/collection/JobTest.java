package ru.job4j.collection;

import org.junit.Test;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.hamcrest.Matchers.lessThan;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;

public class JobTest {

    // Тесты сортировки по имени(по возрастанию и по убыванию):
    @Test
    public void compareByNameAscending() {
        List<Job> jobs = Arrays.asList(
                new Job("ccc", 3),
                new Job("aaa", 1),
                new Job("bbb", 2)
        );
        jobs.sort(new JobSortByNameAscending());
        assertThat(jobs.get(0).getName(), is("aaa"));
    }

    @Test
    public void compareByNameDescending() {
        List<Job> jobs = Arrays.asList(
                new Job("ccc", 3),
                new Job("aaa", 1),
                new Job("bbb", 2)
        );
        jobs.sort(new JobSortByNameDescending());
        assertThat(jobs.get(0).getName(), is("ccc"));
    }

    // Тесты сортировки по приоритету (по возрастанию и по убыванию):
    @Test
    public void compareByPriorityAscending() {
        List<Job> jobs = Arrays.asList(
                new Job("ccc", 3),
                new Job("aaa", 1),
                new Job("bbb", 2)
        );
        jobs.sort(new JobSortByPriorityAscending());
        assertThat(jobs.get(0).getPriority(), is(1));
    }


    @Test
    public void compareByPriorityDescending() {
        List<Job> jobs = Arrays.asList(
                new Job("ccc", 3),
                new Job("aaa", 1),
                new Job("bbb", 2)
        );
        jobs.sort(new JobSortByPriorityDescending());
        assertThat(jobs.get(0).getPriority(), is(3));
    }


    
    //Тест для комбинированного компаратора.
    // Протестировать работу комбинированного компаратора так,
    // чтобы отрабатывали обе его части - для этого первый компаратор должен вернуть 0,
    // т.е. если первый компаратор сравнивает по имени, то имена должны быть одинаковыми.
    @Test
    public void whenComparatorByNameAndPriorityDescending() {
        Comparator<Job> cmpNamePriorityDes =
                new JobSortByNameDescending().
                        thenComparing(new JobSortByPriorityDescending());
        int rsl = cmpNamePriorityDes.compare(
                new Job("iii", 0),
                new Job("iii", 1)
        );
        assertThat(rsl, greaterThan(0));
    }
}