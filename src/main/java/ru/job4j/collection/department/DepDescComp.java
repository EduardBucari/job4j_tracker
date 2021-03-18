package ru.job4j.collection.department;

import java.util.Comparator;

public class DepDescComp implements Comparator<String> {
    @Override
    public int compare(String first, String second) {
        return first.split("/")[0].equals(second.split("/")[0])
                        ?
                        first.compareTo(second)
                        :
                        second.compareTo(first);
    }
}
