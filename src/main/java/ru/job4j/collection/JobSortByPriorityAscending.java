package ru.job4j.collection;

import java.util.Comparator;

// создаем компаратор по приоритету и по возрастанию
public class JobSortByPriorityAscending implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return Integer.compare(first.getPriority(), second.getPriority());
    }
}
