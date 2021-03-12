package ru.job4j.collection;

import java.util.Comparator;

// Задача - отсортировать элементы по номеру, а не целиком строку.
// Так как Компаратор сравнивает строки, а не номера,
// необходимо дописать компаратор, чтобы он сравнивал начальный номер.

// (использовать: метод split(); метод parseInt(); экранировать разделитель ("\\.") в методе split();)
/*
 Метод split в Java разделяет строку на подстроки, используя разделитель,
 принимает строку regex в качестве параметра.

 Метод parseInt() — в Java используется для получения примитивного типа данных определенной строки,
 другими словами — преобразует строку в число.
 */

public class LexSort implements Comparator<String> {

    @Override
    public int compare(String left, String right) {
       // return left.compareTo(right);
        return Integer.compare(Integer.parseInt(left.split("\\.")[0]),
                               Integer.parseInt(right.split("\\.")[0]));
    }
}
