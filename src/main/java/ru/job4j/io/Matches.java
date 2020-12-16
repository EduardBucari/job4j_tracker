package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        boolean run = true;
        int numberOfMatchesOnTheTable = 11;
        int maxNumberOfMatchesYouCanTake = 3;
        int countMatches = input.nextInt();

        while (run) {
            System.out.println("Введите колличество спичек(Вы можете взять одну, две или три спички): ");
            int select = Integer.valueOf(input.nextLine());
            if (select == 1) {
                System.out.println("Вы взяли одну спичку.");
            } else if (select == 2) {
                System.out.println("Вы взяли две спачки.");
            } else if (select == 3) {
                System.out.println("Вы взяли три спички.");
            } else {
                System.out.println("Вы взяли неверное колличество спичек.");
            }
        }

    }
}
