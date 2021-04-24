package ru.job4j.stream.attestation;

/**
 * Модель данных номер 1 - Subject.
 * Класс Subject описывает:
 * name - название школьного предмета,
 * score - аттестационный балл ученика.
 */
public class Subject {
    private String name;
    private int score;

    public Subject(String name, int score) {
        this.name = name;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public int getScore() {
        return score;
    }
}
