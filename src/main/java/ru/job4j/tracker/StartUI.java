package ru.job4j.tracker;

//Если класс зависит от внешних ресурсов (системы ввода-вывода, баз данных, веб-сервисов),
// то эти зависимости нужно разрывать.
//1.Удаляем строчку с import java.util.Scanner.
//import java.util.Scanner;

public class StartUI {
// /*     //2.Вместо объявленныx переменных Scanner scanner написать Input input.
 //   public void init(Scanner scanner, Tracker tracker) {
        public void init(Input input, Tracker tracker) {
       //Вместо вызова scanner.nextLine() написать input.askStr(msg), где msg - это сообщение,
            // которое вы хотели бы вывести пользователю перед его вводом.
        boolean run = true;
        while (run) {
            this.showMenu();
            System.out.println("Select: ");
            //  int select = Integer.valueOf(scanner.nextLine());
            int select = Integer.valueOf(input.askStr("Enter name: "));
            if (select == 0) {
                System.out.println("=== Create a new Item ===");


                // String name = scanner.nextLine();
                String name = input.askStr("Enter name: ");
                Item item = new Item(0, name);
                tracker.add(item);

            } else if (select == 1) {
                System.out.println("=== Show all items ===");
                Item[] rsl = tracker.findAll();//Результат вызова поместить в переменную - это массив элементов класса Item;
                for (int i = 0; i < rsl.length; i++) {
                    System.out.println(rsl[i]);//  Выводим в консоль все элементы массива;
                }
            } else if (select == 2) {
                System.out.println("=== Edit item ===");

                // int id = Integer.parseInt(scanner.nextLine()); //Получить id заявки, которую мы будем изменять, через объект scanner;
                // String idName = scanner.nextLine();//Получить имя заявки на которую мы будем заменять через объект scanner;
                int id = Integer.parseInt(input.askStr("Enter id: "));
                String idName = input.askStr("Enter id name: ");
                Item item = new Item(id, idName); //Создаем объект класса Item
                //Вызвать метод replace у объекта tracker
                boolean rsl = tracker.replace(id, item);  //Валидация.
                if (rsl) {  //если true то выводим строку об успешности операции, иначе - ошибка замены.
                    System.out.println("Замена заявки прошла успешно!");
                } else {
                    System.out.println("Произошла ошибка замены заявки");
                }


            } else if (select == 3) {
                System.out.println("=== Delete item ===");
                // int id = Integer.parseInt(scanner.nextLine()); // Получить id заявки, которую мы будем удалять, через объект scanner;
                // Вызвать метод delete у объекта tracker, в него передать id
                int id = Integer.parseInt(input.askStr("Enter id: "));
                boolean rsl = tracker.delete(id); //Результат работы метода delete необходимо валидировать
                if (rsl) {  //если true то выводим строку об успешности операции, иначе - ошибка удаления.
                    System.out.println("Удаление заявки прошло успешно!");
                } else {
                    System.out.println("Произошла ошибка в удалении заявки!");
                }

            } else if (select == 4) {
                System.out.println("=== Find item by Id ===");
                // int id = Integer.parseInt(scanner.nextLine());// Получить id заявки, которую мы будем искать в хранилище, через объект scanner;
                // Вызвать метод findById() у объекта tracker, в него передать id
                //Результат вызова метода поместить в переменную - это будет объект класса Item;
                int id = Integer.parseInt(input.askStr("Enter id: "));
                Item rsl = tracker.findById(id);//Результат работы метода findById() необходимо валидировать, поскольку метод может вернуть null;
                if (rsl != null) { //Если заявка не равна null -  мы печатаем в консоль заявку, иначе - фразу: "Заявка с таким id не найдена".
                    System.out.println(rsl);
                } else {
                    System.out.println("Заявка с таким id не найдена");
                }

            } else if (select == 5) {
                System.out.println("=== Find items by name ===");
                // String orderNames = scanner.nextLine(); // Получить имя заявок, которые мы будем искать, через объект scanner
                // Вызвать метод findByName() у объекта tracker, в него передать имя из пункта 1
                // Результат вызова метода поместить в переменную - это будет массив объектов класса Item;
                String orderNames = input.askStr("Enter order names: ");
                Item[] rsl = tracker.findByName(orderNames);// Результат работы метода findByName() необходимо валидировать, поскольку метод может вернуть пустой массив;
                if (rsl.length > 0) {
                    for (int i = 0; i < rsl.length; i++) {
                        System.out.println(rsl[i]);// Если длина массива больше 0 - выводим массив в соответствии с примечанием 1, иначе фразу - "Заявки с таким именем не найдены".
                    }
                } else {
                    System.out.println("Заявки с таким именем не найдены");
                }

            } else if (select == 6) {
                run = false;
            }
            //  */
            //-------------------------------------------------------------------

            // Задание 4.2. В классе StartUI есть метод init в
            // котором содержится блок из множественного if.
            // Давайте все блоки в условии вынесем в статические методы.

 /*
  public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(0, name);
        tracker.add(item);
    }

    public static void findAllItems() {
        System.out.println("=== Show all items ===");
        Item[] rsl = tracker.findAll();//Результат вызова поместить в переменную - это массив элементов класса Item;
        for (int i = 0; i <rsl.length; i++) {
            System.out.println(rsl[i]);//  Выводим в консоль все элементы массива;
        }
    }

    public void init(Input input, Tracker tracker) {
        boolean run = true;
        while (run) {
            this.showMenu();
            int select = input.askInt("Select: ");
            if (select == 0) {
                StartUI.createItem(input, tracker);
            } else if (select == 1) {
                StartUI.findAllItems();
            }
        }

        //-------------------------------------------------------------
              */
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
        }

    public static void main(String[] args) {
       //3. Что бы разорвать зависимости, нужно в методе main вместо объекта new Scanner
        // прописать объект реализации интерфейса Input.
        //сделаем новый класс, который реализует интерфейс Input и который внутри будет работать с классом Scanner.
        //Создадим класс ru.job4j.tracker.ConsoleInput.

       // Scanner scanner = new Scanner(System.in);
        Input input = new ConsoleInput();
        Tracker tracker = new Tracker();
        //new StartUI().init(scanner, tracker);
        new StartUI().init(input, tracker);
    }
}
