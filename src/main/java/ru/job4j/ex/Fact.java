package ru.job4j.ex;

//класс вычисления факториала.

public class Fact {
    public static void main(String[] args) {
        System.out.println("The result is : " + calc(5));
    }

    public static int calc(int n) {
        //Добавим проверку входного параметра в метод calc. Если n < 0, то нужно
        // прервать программу с исключением IllegalArgumentException.
        if (n < 0) {
           throw new IllegalArgumentException("n has to be more or equal to zero");
        }
        int rsl = 1;

        for (int index = 1; index <= n; index++) {
            rsl *= index;
        }
        return  rsl;
    }
}
