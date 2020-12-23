package ru.job4j.poly;

public class Plane implements Vehicle {
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() + " - самолет летает по воздуху.");
    }

    @Override
    public void makeNoise() {
        System.out.println(getClass().getSimpleName() + " - произносит звук: SH-SH-SH.");
    }
}
