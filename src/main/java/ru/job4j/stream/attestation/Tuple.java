package ru.job4j.stream.attestation;

import java.util.Objects;

/**
 * Модель данных номер 3 - Tuple.
 * Класс Tuple содержит результаты:
 * name - Имя и Фамилия ученика,
 * score - результат или оценка ученика в баллах.
 * Этот класс используется как для учеников, так и для предметов.
 */
public class Tuple {
    private String name;
    private double score;

    public Tuple(String name, double score) {
        this.name = name;
        this.score = score;
    }

    public double getScore() {
        return score;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Tuple tuple = (Tuple) o;
        return Double.compare(tuple.score, score) == 0
                && Objects.equals(name, tuple.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, score);
    }
}
