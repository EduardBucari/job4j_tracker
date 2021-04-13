package ru.job4j.stream;

import java.util.stream.Stream;

/**
 * Задание.
 * Приведен каркас класса карточной колоды.
 * 1. Напишите метод main, в котором генерируется колода карт.
 *    Чтобы получить поток из перечисления, нужно использовать метод
 *    Stream.of(Suit.values())
 */
public class Cards {
    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(
                        suit -> Stream.of(Value.values())
                                .map(value -> new Card(suit, value))
                )
                .forEach(System.out::println);
    }
}
