package ru.job4j.collection;

import java.util.HashSet;
import java.util.List;

public class NotifyAccount {
    public static HashSet<Account> sent(List<Account> accounts) {
        HashSet<Account> rsl = new HashSet<>();
        // Решение этой задачи сводиться к преобразованию List в Set.
        // HashSet устранит дубликаты клиентов банка самостоятельно.
        // for-each account to HashSet;

        for (Account a : rsl) {

        }
        return rsl;
    }
}
