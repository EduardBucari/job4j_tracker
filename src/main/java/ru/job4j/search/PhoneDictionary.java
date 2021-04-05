package ru.job4j.search;

import java.util.ArrayList;
import java.util.function.Predicate;

/**
 * Каркас класса.
 * Условие задания: Есть список абонентов. Нужно их отфильтровать по ключу.
 * Метод поиска должен фильтровать все поля модели.
 * Если изменится модель, то нам нужно будет дописать условия.
 */
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }

    /**
     * Метод поиска по ключу.
     * Дописать метод find с использованием функции высшего порядка.
     * Применим функциональный интерфейс java.util.function.Predicate и метода or.
     * @param key отфильтровать список абонетов по данному ключу пользователя.
     * @return вернуть список соответствующих пользователей.
     */
    public ArrayList<Person> find(String key) {
        Predicate<Person> name = person -> person.getName().contains(key);
        Predicate<Person> surname = person -> person.getSurname().contains(key);
        Predicate<Person> address = person -> person.getAddress().contains(key);
        Predicate<Person> phone = person -> person.getPhone().contains(key);
        Predicate<Person> compound = name.or(surname).or(address).or(phone);

        ArrayList<Person> result = new ArrayList<>();
        for (Person person : persons) {
            if (compound.test(person)) {
                result.add(person);
            }
        }
        return result;
    }
}
