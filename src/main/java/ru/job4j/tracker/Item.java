package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class Item {
    private int id;
    private String name;
    LocalDateTime created = LocalDateTime.now();

    public Item() { // Конструктор без параметров.

    }

    public Item(int id) { // конструктор с параметром id

    }

    public Item(int id, String name) {  // конструктор с параметрами id и name

    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public LocalDateTime getCreated() {
        return created;
    }
}
