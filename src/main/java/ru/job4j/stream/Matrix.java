package ru.job4j.stream;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

/**
 *Задание:
 * 1. Создайте матрицу Integer[][].
 * 2. Напишите преобразование этой матрицы в список чисел.
 *    Для того, чтобы преобразовать матрицу в список чисел нужно использовать flatMap().
 *    Метод flatMap() -  принимает элемент потока и преобразовывает его в новый поток.
 * 3. При решении этой задачи нужно использовать методы flatMap(), collect(), Stream.of().
 * 4. Реализуйте логику в методе, который на вход принимает двумерный массив Integer[][].
 * 5. Дополнительно используйте метод boxed (), чтобы вернуть поток,
 *    состоящий из элементов этого потока, каждый из которых упакован в целое число.
 * 6. На реализованный метод напишите тесты.
 */
public class Matrix {
    public List<Integer> convertMatrixToList(int[][] matrix) {
        return Arrays.stream(matrix)
                .flatMapToInt(e -> Arrays.stream(e))
                .boxed()
                .collect(Collectors.toList());
    }
}
