package ru.job4j.oop;

public class Jukebox {
    public void music(int position) {
        if (position == 1) {
            System.out.println("Пусть бегут неуклюже");
        }
        if (position == 2) {
            System.out.println("Спокойной ночи");
        } else {
            System.out.println("Песня не найдена");
        }
    }


    public static void main(String[] args) {
        Student john = new Student();
        john.music(1);
        john.music(2);
        john.music(3);
    }
}
