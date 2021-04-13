package ru.job4j.stream;

import java.util.stream.Stream;

enum Suit {
    Diamonds, Hearts, Spades, Clubs
}

enum Value {
    V_6, V_7, V_8, V_9, V_10, Jack, Queen, King, Ace
}

/**
 * Приведена модель данных карточной колоды.
 */
public class Card {
    private Suit suit;
    private Value value;

    public Card(Suit suit, Value value) {
        this.suit = suit;
        this.value = value;
    }

    public Suit getSuit() {
        return suit;
    }

    public Value getValue() {
        return value;
    }

    @Override
    public String toString() {
        return "Card{"
                + "suit="
                + suit
                + ", value=" + value
                + '}';
    }
}
