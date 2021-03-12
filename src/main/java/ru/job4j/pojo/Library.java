package ru.job4j.pojo;

public class Library {

    public static void main(String[] args) {
        Book cleanCode = new Book("Clean code", 25);
        Book studyJava = new Book("Study Java", 53);
        Book spring = new Book("Spring & Java", 74);
        Book dataBase = new Book("Data base", 32);

        Book[] arrayBook = new Book[4];
        arrayBook[0] = cleanCode;
        arrayBook[1] = studyJava;
        arrayBook[2] = spring;
        arrayBook[3] = dataBase;

        for (int index = 0; index < arrayBook.length; index++) {
            Book bk = arrayBook[index];
            System.out.println(bk.getBookName() + ": " + bk.getPageQuantity() + " pages.");
        }

        System.out.println("------------");
        System.out.println("Swap index 0 and 3: ");
        arrayBook[0] = dataBase;
        arrayBook[3] = cleanCode;
        for (int index = 0; index < arrayBook.length; index++) {
            Book bk = arrayBook[index];
            System.out.println(bk.getBookName() + ": " + bk.getPageQuantity() + " pages.");
        }

        System.out.println("-------------");
        System.out.println("Show only book 'Clean Code' ");
        for (int index = 0; index < arrayBook.length; index++) {
            Book bk = arrayBook[index];
            if (bk.getBookName().equals("Clean code")) {
                System.out.println(bk.getBookName() + ": " + bk.getPageQuantity() + " pages.");
            }
        }
    }
}