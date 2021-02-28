package ru.job4j.collection;


//Теперь давайте создадим класс ru.job4j.collection.JobSortByName,
// который будет реализовывать интерфейс java.util.Comparator.
import java.util.Comparator;

public class JobSortByName implements Comparator<Job> {
    @Override
    public int compare(Job first, Job second) {
        return first.getName().compareTo(second.getName());
    }
}
