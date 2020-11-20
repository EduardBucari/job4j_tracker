package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] array) {
        array = array; // я думаю здесь ошибка, т.к.
                       // есть две переменные с одинаковым именем внутри метода.
                       // но как исправить, пока не понимаю.
    }                   //

    public void print() {
        for (int index = 0; index < array.length; index++) {
            System.out.println(array[index]);
        }
    }

    public static void main(String[] args) {
        int[] array = {1, 2, 3};
        Reduce reduce = new Reduce();
        reduce.to(array);
        reduce.print();
    }
}
