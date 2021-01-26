package ru.job4j.ooa;

import jdk.swing.interop.SwingInterOpUtils;

public class Airport {
    public static void main(String[] args) {
     //   final Airbus airbus = new Airbus("A320");
        final Airbus AIRBUS = new Airbus("A320");
        System.out.println(AIRBUS);
        AIRBUS.printModel();
        AIRBUS.printCountEngine();

      //  AIRBUS = new Airbus("A380");

        System.out.println(AIRBUS);

        AIRBUS.setName("A380");
        System.out.println(AIRBUS);
    }
}
