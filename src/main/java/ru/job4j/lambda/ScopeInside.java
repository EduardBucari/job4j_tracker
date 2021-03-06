package ru.job4j.lambda;

import java.util.function.Supplier;

/**
 * Ниже приведен код, который складывает числа массива.
 * Код не компилируется.
 * Задача - Исправьть ошибку.
 */
public class ScopeInside {
    public static void main(String[] args) {
        int[] number = {1, 2, 3};
        int total = 0;
        for (int i = 0; i < number.length; i++) {
            int num = number[i];
            total += add(
                    () -> num
            );
        }
        System.out.println(total);
    }

    private static Integer add(Supplier<Integer> calc) {
        return calc.get();
    }
}
