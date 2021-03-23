package ru.job4j.lambda;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;

/**
 * Задача - создать компаратор на основе анонимного класса.
 * Для этого создаем анонимный класс для компаратора Attachment.
 * Класс должен сравнивать имена и размер объектов Attachment.
 * Класс AttachmentSort реализует два логических варианта компаратора.
 * Первый вариант сортирует список по размеру,
 * Второй - по  имени.
 * @author Eduard Bucari
 * @version 1.0.
 */
public class AttachmentSort {

    /**
     * Метод main создает компаратор для сортировки по размеру,
     *  затем переопределяет компаратор для сортировки по именам.
     * @param args - массив параметров командной строки.
     */
    public static void main(String[] args) {
        Comparator<Attachment> comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return Integer.compare(o1.getSize(), o2.getSize());
            }
        };
        output(comparator, "Sorted by size");
        comparator = new Comparator<Attachment>() {
            @Override
            public int compare(Attachment o1, Attachment o2) {
                return o1.getName().compareTo(o2.getName());
            }
        };
        output(comparator, "Sorted by name");
    }

    /**
     * Метод output принимает 2 параметра компаратор и строку prompt.
     * Создаём списк, сортируем списк с помощью
     * компаратора и выводим на экран отсортированный список.
     * @param comparator является экземпляром анонимного класса,
     * @param prompt заголовок в виде страки.
     */
    private static void output(Comparator comparator, String prompt) {
        List<Attachment> attachments = Arrays.asList(
                new Attachment("image 1", 100),
                new Attachment("image 2", 34),
                new Attachment("image 3", 13)
        );
        attachments.sort(comparator);
        System.out.println(prompt);

        for (Attachment temp : attachments) {
            System.out.println(temp);
        }
    }
}
