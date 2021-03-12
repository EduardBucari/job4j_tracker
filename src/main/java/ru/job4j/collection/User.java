package ru.job4j.collection;

//нужно осуществить сортировку для модели ru.job4j.collection.User.
//В модели должны быть поля: имя и возраст. Предусмотреть ситуацию, когда два пользователя
// имеют одинаковое имя. В этом случае нужно сравнить их возраст.
//Класс User должен реализовать интерфейс Comparable.

import java.util.Objects;

public class User implements Comparable<User> {
    private String name;
    private int age;

    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    // Для выполнения задания нужно реализовать метод compareTo
   // Он должен сравнить имена, если они равны, то сравнить возраст.
    // Перед этим реализовать гетеры

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(User o) {
        int nameCompare = name.compareTo(o.name);
        return nameCompare == 0 ? Integer.compare(age, o.getAge()) : nameCompare;
    }

    //методы equals и hashCode нужны для тестов, где мы используем
    // методы сравнения моделей user.equals
    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        User user = (User) o;
        return age == user.age
                && Objects.equals(name, user.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, age);
    }
}
