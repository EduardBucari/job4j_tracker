package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {
        LocalDateTime created = LocalDateTime.now();
        Item startItem = new Item();
            startItem.getCreated();
        }
        LocalDateTime created = LocalDateTime.now();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = created.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + createdFormat);
}


