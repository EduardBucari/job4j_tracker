package ru.job4j.collection;

import org.junit.Test;

import java.util.Comparator;
import java.util.List;

import static org.hamcrest.Matchers.greaterThan;
import static org.junit.Assert.assertThat;

public class JobTest {

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