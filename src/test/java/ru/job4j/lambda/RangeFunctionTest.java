package ru.job4j.lambda;

import org.junit.Test;

import java.util.Arrays;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

/**
 * Реализации функций в тестах.
 *     - линейная (f(x)=kx+m, где x — независимая переменная, k и m — некоторые числа);
 *     - квадратичная (f(x) = ax2 + bx + c, где a, b и с — заданные числа);
 *     - показательная - математическая функция f(x)=a^x;
 */

public class RangeFunctionTest {

    @Test
    public void whenLinearFunctionThenLinearResults() {
        List<Double> result = new RangeFunction().diapason(5, 7, x -> 2 * x + 1);
        List<Double> expected = Arrays.asList(11D, 13D, 15D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenQuadraticFunctionThenQuadraticResults() {
        List<Double> result = new RangeFunction()
                .diapason(2, 4, x -> 2 * Math.pow(x, 2) + 5);
        List<Double> expected = Arrays.asList(13D, 23D, 37D);
        assertThat(result, is(expected));
    }

    @Test
    public void whenExponentialFunctionThenExponentialResult() {
        List<Double> result = new RangeFunction()
                .diapason(2, 3, x -> Math.pow(3, x));
        List<Double> expected = Arrays.asList(9D, 27D);
        assertThat(result, is(expected));
    }
}