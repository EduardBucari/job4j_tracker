package ru.job4j.map;

import java.util.Map;
import java.util.Set;

/**
 *  Тема Optional.
 *  Задание.
 * 1. Ниже представлен код, который описывает работу колледжа.
 *    Есть 2 модели: Student и Subject, и класс College в котором определены
 *    методы поиска студента и предмета (по аккаунту и имени),
 *    который изучает этот студент.
 * 2. Обратите внимание - методы поиска в классе College могут вернуть null.
 *    Ваша задача - переписать эти методы поиска студента и предмета (по аккаунту и имени),
 *    чтобы они возвращали тип Optional, по умолчанию нужно возвращать Optional.empty().
 *
 *  Проверить исправленный код готовыми тестами CollegeTest (они написаны уже на Optional).
 */
public class College {
    private final Map<Student, Set<Subject>> students;
    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Student findByAccount(String account) {
        Student rsl = null;
        for (Student s : students.keySet()) {
            if (account.equals(s.getAccount())) {
                rsl = s;
                break;
            }
        }
        return rsl;
    }

    public Subject findBySubjectName(String account, String name) {
        Subject rsl = null;
        Student s = findByAccount(account);
        if (s != null) {
            Set<Subject> subjects = students.get(s);
            for (Subject subj : subjects) {
                if (name.equals((subj.getName()))) {
                    rsl = subj;
                    break;
                }
            }
        }
        return rsl;
    }
}
