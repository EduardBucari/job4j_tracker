package ru.job4j.oop;

public class College {
    public static void main(String[] args) {
        Freshman freshman = new Freshman();  //Создаем объект класса Freshman.
        Student2 st2 = freshman;  // Делаем приведение к типу родителя Student2.
        Object obj = freshman; // Делаем приведение к типу родителя Object.
        Object objectFreshman = new Freshman(); // Приведение типа при создании объекта Freshman.
        Freshman freshmanFromObject = (Freshman) objectFreshman; // Приведение типа
                                                                // за счет понижения по иерархии.
        System.out.println(new Freshman());
        System.out.println(new Object());
    }
}
