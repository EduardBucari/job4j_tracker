package ru.job4j.poly;

public class Train implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - поезд передвигается по рельсам.");
    }

    @Override
    public void makeNoise() {
        System.out.println(getClass().getSimpleName() + " - произносит звук: CHUH-CHUH-CHUH.");
    }
}
