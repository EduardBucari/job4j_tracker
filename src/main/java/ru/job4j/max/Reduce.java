package ru.job4j.max;

public class Reduce {
    private int[] array;

    public void to(int[] array) {
        this.array = array; // я думаю здесь ошибка (array = array;), т.к.
                       // есть две переменные с одинаковым именем внутри метода.
    }                   //Для решения этой проблемы необходимо использовать ключевое слово this,
                        // которое в данном случае укажет, что нужно вызывать переменную не метода to,
                        //а класса Reduce

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
