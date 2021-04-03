package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;
import java.util.function.Function;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Реализации функций в тестах.
 *     - линейная - (Х);
 *     - квадратичная - (x*x);
 *     - показательная - (Х в степени Х);
 */
public class RangeFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = function.diapason(5, 8, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        asertThat(result,is(expected));
    }

}