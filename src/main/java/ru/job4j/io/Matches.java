package ru.job4j.io;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfMatchesOnTheTable = 11;
        boolean player = true;

        while (numberOfMatchesOnTheTable > 0) {
            System.out.println("Вы можете взять одну, две или три спички: ");
            int select = Integer.valueOf(input.nextLine());
            if (select >= 1 && select <= 3) {
                System.out.println("Вы взяли колличество спичек: " + select);
                numberOfMatchesOnTheTable = numberOfMatchesOnTheTable - select;
                System.out.println("Осталось " + numberOfMatchesOnTheTable + " спичек");
                String name = player ? "Игрок N1" : "Игрок N2";
                player = !player;  // Конструкция замены играков.
            }
        }
        if (numberOfMatchesOnTheTable == 0) {
            System.out.println("ВЫ ПОБЕДИТЕЛЬ!"); // Контрукция вывода победителя.
        }
    }
}
