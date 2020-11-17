package ru.job4j.oop;

import org.junit.Test;
import static org.hamcrest.core.Is.is;
import static org.junit.Assert.assertThat;
import static org.junit.Assert.*;

public class MaxFrom3And4Test {

    @Test
    public void whenMax1To2To3Then3() {
        int result = MaxFrom3And4.max3(1, 2, 3);
        assertThat(result, is(3));
    }

    @Test
    public void whenMax1To2To3To4Then3() {
        int result = MaxFrom3And4.max4(1, 2, 3, 4);
        assertThat(result, is(4));
    }
}
