package ru.job4j.poly;

public class PolyUsage {
    public static void main(String[] args) {
        Vehicle plane = new Plane();
        Vehicle train = new Train();
        Vehicle bus2 = new Bus2();

        Vehicle[] vehicles = new Vehicle[]{plane, train, bus2};
        for (Vehicle v : vehicles) {
            v.move();
            v.makeNoise();
        }
    }
}
