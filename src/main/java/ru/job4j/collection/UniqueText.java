package ru.job4j.collection;

import java.util.HashSet;

/*
 Алгоритм решения задания.
1. Преобразовать строку в массив слов. Для этого используется метод String.split(" ").
2. Массив строк вставить через цикл for-each в коллекцию HashSet.
3. Преобразовать проверяемый текст в массив слов по аналогии с пунктом 1.
4. Проверить массив строк через цикл for-each в коллекции HashSet используя метод contains.
 */
public class UniqueText {
    public static boolean isEquals(String originText, String duplicateText) {
        boolean rsl = true;
        String[] origin = originText.split(" ");
        String[] text = duplicateText.split(" ");
        HashSet<String> check = new HashSet<>();
        // for-each origin -> new HashSet
        for (String st : origin) {
            check.add(st);
        }
        // for-each text -> hashSet.contains
        for (String str : text) {
            if (!check.contains(str)) {
                return false;
            }
        }
        return rsl;
    }
}
