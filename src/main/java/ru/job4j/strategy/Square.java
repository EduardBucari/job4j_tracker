package ru.job4j.strategy;

// Реализовать интерфейс Shape для квадрата (Square);
public class Square implements Shape {
    @Override
    public String draw() {
        String ln2 = System.lineSeparator();
        return "-------" + ln2
            +  "|     |" + ln2
            +  "|     |" + ln2
            +  "-------" + ln2;
    }

    public static void main(String[] args) {
        System.out.println(new Square().draw());
    }
}