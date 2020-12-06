package ru.job4j.tracker;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class StartUI {

    public static void main(String[] args) {

        Tracker tracker = new Tracker();

        tracker.add(Item);
        tracker.findById(Item);

        Item startItem = new Item(1103, "David");
        LocalDateTime created = startItem.getCreated();

        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd-MMMM-EEEE-yyyy HH:mm:ss");
        String createdFormat = created.format(formatter);
        System.out.println("Текущие дата и время после форматирования: " + createdFormat);

        System.out.println(startItem);

        System.out.println(Item);
    }
}

