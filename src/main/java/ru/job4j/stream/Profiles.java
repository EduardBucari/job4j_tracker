package ru.job4j.stream;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Задача - составить список адресов клиентов.
 * В задании про список адресов пришло новое требование:
 * 1. Так как часть людей живет по одному и тому же адресу,
 * нужно в списке клиентов оставить только уникальные элементы
 * используя метод distinct(), (distinct() позволяет убрать дублирующие элементы).
 * 2. Для быстрого поиска по адресам, список нужно отсортировать по полю String city.
 * Для сортировки нужно использовать метод sorted(Comparator^Address>()).
 * 3. Чтобы сравнить объекты класса Address,
 * нужно в классе Address определить два методы equals и hashCode.
 * 4. Написать тесты для проверки публичных методов.
 */

public class Profiles {
    public List<Address> collect(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .collect(Collectors.toList());
    }

    public List<Address> distinct(List<Profile> profiles) {
        return profiles.stream()
                .map(Profile::getAddress)
                .sorted(((o1, o2) -> o1.getCity().compareTo(o2.getCity())))
                .distinct()
                .collect(Collectors.toList());
    }
}
