package ru.job4j.encapsulation;

public class Config {
    private String name;
    private int position;
    private String[] properties;
    private String key;

    private Config(String name) {
        this.name = name;
    }

    void print() {
        System.out.println(position);
    }

    private String getProperty() {
        return search(key);
    }

    private String search(String key) {
        return key;
    }
}
