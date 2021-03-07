package ru.job4j.collection;

import java.util.Comparator;

// создаем компаратор по имени и по возрастанию
public class JobSortByNameAscending implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
