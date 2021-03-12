package ru.job4j.poly;

public class Bus2 implements Vehicle {
    
    @Override
    public void move() {
        System.out.println(getClass().getSimpleName() 
                + " - автобус двигается по скоростным трассам.");
    }

    @Override
    public void makeNoise() {
        System.out.println(getClass().getSimpleName() 
                + " - произносит звук: TR-TR-TR.");
    }
}
