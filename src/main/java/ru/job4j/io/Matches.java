package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        int numberOfMatchesOnTheTable = 11;

        while (numberOfMatchesOnTheTable > 0) {
            System.out.println("Игра началась. Вы можете взять одну, две или три спички: ");
            int select = Integer.valueOf(input.nextLine());
            if (select > 1 && select < 4) {
                System.out.println("Player N1");
                numberOfMatchesOnTheTable = numberOfMatchesOnTheTable - select;
                System.out.println("Player N2");
                numberOfMatchesOnTheTable = numberOfMatchesOnTheTable - select;
            }
        }

    }
}
