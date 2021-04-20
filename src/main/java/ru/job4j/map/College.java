package ru.job4j.map;

import java.util.Map;
import java.util.Optional;
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
 * 3. Объект Optional предупреждает программиста, что метод может вернуть null
 *    и нужно добавить проверку, что объект не null-ссылка.
 *    Чтобы проверить, что объект не null используйте метод
 *    if (opt.isPresent()) {
 *    Чтобы получить значение этого объекта, используйте метод
 *    opt.get()
 *
 * 4. Проверить исправленный код готовыми тестами CollegeTest (они написаны уже на Optional).
 */
public class College {
    private final Map<Student, Set<Subject>> students;

    public College(Map<Student, Set<Subject>> students) {
        this.students = students;
    }

    public Optional<Student> findByAccount(String account) {
        Optional<Student> rsl = Optional.empty();
        for (Student s : students.keySet()) {
            if (s.getAccount().equals(account)) {
                rsl = Optional.of(s);
                break;
            }
        }
        return rsl;
    }

    public Optional<Subject> findBySubjectName(String account, String name) {
        Optional<Subject> rsl = Optional.empty();
       Optional<Student> s = findByAccount(account);
        if (s.isPresent()) {
            Set<Subject> subjects = students.get(s.get());
            for (Subject subj : subjects) {
                if (subj.getName().equals(name)) {
                    rsl = Optional.of(subj);
                    break;
                }
            }
        }
        return rsl;
    }
}
