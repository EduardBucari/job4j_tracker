package ru.job4j.stream;

import java.util.List;

/**
 * Задание.
 * 1. Произведите рефакторинг кода по принципу строка занимает 80 символов.
 * 2. Проанализируйте следующий код. Найдите в нем ошибку.
 * Программа должна выводить задачи имя которых "Bug" и значение scope > 30.
 */

public class StreamUsage {
    public static class Task {
        private final String name;
        private final long spent;

        public Task(String name, long spent) {
            this.name = name;
            this.spent = spent;
        }
    }

    public static void main(String[] args) {
        List<Task> tasks = List.of(
                new Task("BUG #1", 10),
                new Task("Bug #2", 20),
                new Task("Bug #3", 40)
        );
        tasks.stream().filter(task -> task.name.contains("Bug")).filter(task -> task.spent == 30).map(task -> task.name + " " + task.spent).forEach(System.out::println);
    }
}
