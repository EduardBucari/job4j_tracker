package ru.job4j.stream;

import java.util.List;
import java.util.function.Function;
import java.util.stream.Collectors;

/**
 * Задача - составить список адресов клиентов.
 * В решении должно быть 3 класса: 2 модели Address и Profile
 * и данный класс с логикой - Profiles.
 *
 * В класс Profiles создать метод List^Address> collect(List^Profile> profiles);
 * При решении задания нужно использовать:
 * - Stream API,
 * - метод map,
 * - метод collect(Collectors.toList());
 *
 * Метод Stream.map - принимает элемент потока и возвращает другой элемент,
 * т.е. используем функциональный интерфейс Function^T,R>.
 *
 * Исходя из этого импортируем следующие утилиты:
 * List, function.Function, stream.Collectors;
 *
 * Написать тесты на метод, который реализовали.
 */

public class Profiles {
    public List<Address> collect(
            List<Profile> profiles,
            Function<Profile, Address> profileAddressFunction
    ) {
        return profiles.stream()
                .map(profileAddressFunction)
                .collect(Collectors.toList());
    }
}
