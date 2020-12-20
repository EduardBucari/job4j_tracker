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
                Item[] rsl = tracker.findAll();//Результат вызова поместить в переменную - это массив элементов класса Item;
                for (int i = 0; i <rsl.length; i++) {
                    System.out.println(rsl[i]);//  Выводим в консоль все элементы массива;
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");
                System.out.print("Enter id: ");
                System.out.println("Enter id name: ");
                int id = Integer.parseInt(scanner.nextLine()); //Получить id заявки, которую мы будем изменять, через объект scanner;
                String idName = scanner.nextLine();//Получить имя заявки на которую мы будем заменять через объект scanner;
                Item item = new Item(id, idName); //Создаем объект класса Item
                tracker.replace(id, item); //Вызвать метод replace у объекта tracker
                boolean rsl = tracker.replace(id, item);  //Валидация.
                if (rsl = true) {  //если true то выводим строку об успешности операции, иначе - ошибка замены.
                    System.out.println("Замена заявки прошла успешно!");
                } else {
                    System.out.println("Произошла ошибка замены заявки");
                }


            } else if (select == 3) {
                System.out.println("=== Delete item ===");
               int id = Integer.parseInt(scanner.nextLine()); // Получить id заявки, которую мы будем удалять, через объект scanner;
                tracker.delete(id); // Вызвать метод delete у объекта tracker, в него передать id
               boolean rsl = tracker.delete(id); //Результат работы метода delete необходимо валидировать
                if (rsl = true) {  //если true то выводим строку об успешности операции, иначе - ошибка удаления.
                    System.out.println("Удаление заявки прошло успешно!");
                } else {
                    System.out.println("Произошла ошибка в удалении заявки!");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                int id = Integer.parseInt(scanner.nextLine());// Получить id заявки, которую мы будем искать в хранилище, через объект scanner;
                tracker.findById(id);// Вызвать метод findById() у объекта tracker, в него передать id
               Item item = tracker.findById(id);//Результат вызова метода поместить в переменную - это будет объект класса Item;
               Item rsl = tracker.findById(id);//Результат работы метода findById() необходимо валидировать, поскольку метод может вернуть null;
               if (rsl != null) { //Если заявка не равна null -  мы печатаем в консоль заявку, иначе - фразу: "Заявка с таким id не найдена".
                   System.out.println(rsl);
               } else {
                   System.out.println("Заявка с таким id не найдена");
               }

            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
               // Получить имя заявок, которые мы будем искать, через объект scanner
                tracker.findByName("...."); // Вызвать метод findByName() у объекта tracker, в него передать имя из пункта 1
               Item[] rslArray = tracker.findByName("....");// Результат вызова метода поместить в переменную - это будет массив объектов класса Item;
               Item[] rsl = tracker.findByName("....");// Результат работы метода findByName() необходимо валидировать, поскольку метод может вернуть пустой массив;
               if (rsl.length > 0) {
                   System.out.println(rsl);// Если длина массива больше 0 - выводим массив в соответствии с примечанием 1, иначе фразу - "Заявки с таким именем не найдены".
               } else {
                   System.out.println("Заявки с таким именем не найдены");
               }

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
