package ru.job4j.tracker;

import java.util.Arrays;
import java.util.Scanner;

public class StartUI {

    public void init(Scanner scanner, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            int select = Integer.valueOf(scanner.nextLine());
            if (select == 0) {
                System.out.println("=== Create a new Item ===");
                System.out.print("Enter name: ");
                String name = scanner.nextLine();
                Item item = new Item(0, "......");
                tracker.add(item);

            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                tracker.findAll();
                Item rsl =  ;   //Результат вызова поместить в переменную - это массив элементов класса Item;
                System.out.println(rsl);//  Вывести в консоль все элементы массива;

            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                System.out.println("Enter id name: ");
                String id = scanner.nextLine(); //Получить id заявки, которую мы будем изменять, через объект scanner;
                String idName = scanner.nextLine();//Получить имя заявки на которую мы будем заменять через объект scanner;
                Item item = new Item(2, "......"); //Создаем объект класса Item
                tracker.replace(2, ); //Вызвать метод replace у объекта tracker



            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                tracker.delete(3);

            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                tracker.findById(4);

            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                tracker.findByName("......");

            } else if (select == 6) {
                run = false;
            }
        }
    }
        private void showMenu() {
            System.out.println("Menu.");
            System.out.println("0. Add new Item");
            System.out.println("1. Show all items");
            System.out.println("2. Edit item");
            System.out.println("3. Delete item");
            System.out.println("4. Find item by Id");
            System.out.println("5. Find items by name");
            System.out.println("6. Exit Program");
           // System.out.println("Select:");


        }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Tracker tracker = new Tracker();
        new StartUI().init(scanner, tracker);
    }
}
