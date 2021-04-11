package ru.job4j.stream;

import org.junit.Test;

import java.util.Arrays;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class MatrixTest {
    @Test
    public void whenConvertMatrixToList() {
        int[][] matrix = {
                {1, 2},
                {10, 20}
        };
        assertThat(
                new Matrix().convertMatrixToList(matrix),
                is(Arrays.asList(1, 2, 10, 20))
        );
    }
}