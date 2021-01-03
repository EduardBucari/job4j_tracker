package ru.job4j.tracker;

// Для разрыва зависимости вывод в консоль мы заменяем интерфейсом Output.,
//Он имеет две реализации: 1. Заглушка - public class StubOutput implements Output
//                         2. Консольный вывод - public class ConsoleOutput implements Output
public interface Output {
    void println(Object obj);
}
