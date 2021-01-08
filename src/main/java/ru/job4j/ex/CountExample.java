package ru.job4j.ex;

//программа подсчета чисел от start до finish.
public class CountExample {
    public static int add(int start, int finish) {
        //Бросим исключение в случае не правильного ввода данных;
        if (start > finish) {
            throw new IllegalArgumentException("Start should be less then finish.");
        }
        int rsl = 0;
        for (int index = start; index != finish; index++) {
            rsl += index;
        }
        return rsl;
    }

    public static void main(String[] args) {
        System.out.println("Sum of 2 to 10 is : " + add(2, 10));
        // + add(10, 2) - не корректное использование параметров.
    }
}
