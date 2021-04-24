package ru.job4j.stream.attestation;

import java.util.List;

/**
 * Модель данных номер 2 - Pupil.
 * Класс Pupil описывает ученика.
 * name - Имя, Фамилия ученика,
 * subjects - Список предметов, которые ученик изучает.
 */
public class Pupil {
    private String name;
    private List<Subject> subjects;

    public Pupil(String name, List<Subject> subjects) {
        this.name = name;
        this.subjects = subjects;
    }

    public String getName() {
        return name;
    }

    public List<Subject> getSubjects() {
        return subjects;
    }
}
