package ru.job4j.oop;

public class DummyDic {
    public String engToRus(String eng) {
        return "Неизвестное слово - " + eng;
    }

    public static void main(String[] args) {
        DummyDic dummy = new DummyDic();
        dummy.engToRus("independent");
        String eng = "independent";
        System.out.println("Неизвестное слово - " + eng);
    }
}