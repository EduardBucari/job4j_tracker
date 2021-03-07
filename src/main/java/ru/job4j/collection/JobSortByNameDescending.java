package ru.job4j.collection;

import java.util.Comparator;

// создаем компаратор по имени и по убыванию
public class JobSortByNameDescending implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return second.getName().compareTo(first.getName());
    }
}
