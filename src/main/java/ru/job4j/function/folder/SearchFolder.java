package ru.job4j.function.folder;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Predicate;

public class SearchFolder {
    public static List<Folder> filterSize(List<Folder> list) {
        Predicate<Folder> predicate = new Predicate<Folder>() {
            @Override
            public boolean test(Folder folder) {
                return folder.getSize() > 100;
            }
        };
        return filter(list, predicate);
    }

    public static List<Folder> filterName(List<Folder> list) {
        Predicate<Folder> predicate = new Predicate<Folder>() {
            @Override
            public boolean test(Folder folder) {
                return folder.getName().contains("bug");
            }
        };
        return filter(list, predicate);
    }

    public static List<Folder> filter(
            List<Folder> list,
            Predicate<Folder> pred
    ) {
        List<Folder> result = new ArrayList<>();
        for (Folder folder : list) {
            if (pred.test(folder)) {
                result.add(folder);
            }
        }
        return result;
    }
}
