package ru.job4j.io;

import org.w3c.dom.ls.LSOutput;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfMatchesOnTheTable = 11;


        while (numberOfMatchesOnTheTable > 0) {
            System.out.println("Вы можете взять одну, две или три спички: ");
            int select = Integer.valueOf(input.nextLine());
            boolean firstPlayer;
            if (select >= 1 && select <= 3) {
                System.out.println("Игрок N1 взял колличество спичек " + select);
                numberOfMatchesOnTheTable = numberOfMatchesOnTheTable - select;
                System.out.println("Осталось " + numberOfMatchesOnTheTable + " спичек");
                firstPlayer = true;
            } else {
                firstPlayer = false;
                System.out.println("Вы взяли не правильное колличество спичек. Повторите попытку.");
            }

            if (select >= 1 && select <= 3) {
                System.out.println("Игрок N2 взял колличество спичек " + select);
                numberOfMatchesOnTheTable = numberOfMatchesOnTheTable - select;
                System.out.println("Осталось " + numberOfMatchesOnTheTable + " спичек");
            } else {
                System.out.println("Вы взяли не правильное колличество спичек. Повторите попытку.");
            }
        }

    }
}
