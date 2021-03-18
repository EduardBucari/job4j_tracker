package ru.job4j.collection.department;

import java.util.Collections;
import java.util.ArrayList;
import java.util.LinkedHashSet;
import java.util.List;

/**
 * Задача - разработать справочник подразделений, где
 * класс Departments будет добавлять пропущенные подразделения,
 * а также производить сортировку подразделений.
 * Каждое подразделение имеет свой код.
 * Так же требуется реализовать возможность сортировки массива кодов подразделений
 * по возрастанию и убыванию, при которых сохранялась бы иерархическая структура
 * т.к. отсортированный массив используется для отображения категорий пользователю.
 * @author Eduard Bucari
 * @version 1.0
 */
public class Departments {

    /**
     * Реализовать метод fillGaps:
     * нужно определить, какие элементы отсутствуют в системе.
     * Для этого каждую входящую строку нужно разбить на одиночные элементы.
     * Для этого можно использовать метод String.split("/").
     * Этот метод вернет массив одиночных элементов.
     * Далее нужно через цикл последовательно складывать элементы и добавлять их в множество.
     * Используйте в качестве промежуточного хранения LinkedHashSet.
     * Промежуточная коллекция LinkedHashSet позволяет устранить дубликаты из коллекции,
     * которые будут получаться в результате последовательного складывания единичных департаментов.
     * При этом данные в LinkedHashSet будут отсортированы в том порядке,
     * в котором они добавляются в LinkedHashSet.
     * Так же в задаче требуется реализовать возможность сортировки массива кодов подразделений
     * по возрастанию и убыванию, при которых сохранялась бы иерархическая структура,
     * т.к. отсортированный массив используется для отображения категорий пользователю.
     * Необходимо сравнить первые элементы по убыванию, если они равны,
     * то сравнить последующие элементы, но в возрастающем порядке.
     * Для сортировки по убыванию необходимо реализовать отдельный компаратор.
     * @param deps спписок неотсортированных департаментов
     * @return возвращает отсортированный исходный список без пробелов.
     */
    public static List<String> fillGaps(List<String> deps) {
        final String slash = "/";
        LinkedHashSet<String> rsl = new LinkedHashSet<String>();
        for (String dep : deps) {
            String[] temp = dep.split("/");
            String loadedString = "";
            for (int i = 0; i < temp.length; i++) {
                loadedString = (temp.length != 1 && (i > 0 || i == temp.length - 1))
                        ?
                        loadedString + slash + temp[i]
                        :
                        loadedString + temp[i];
                rsl.add(loadedString);
            }
        }
        return new ArrayList<>(rsl);
    }

    /**
     * Естественная сортировка списка по возрастанию.
     * @param orgs - несортированный список подразделений.
     */
    public static void sortAsc(List<String> orgs) {
        Collections.sort(orgs);
        for (String temp : orgs) {
            System.out.println(temp);
        }
    }

    /**
     *Сортировка полученного списка в порядке убывания,
     * учитывая, что первые элементы могут быть равны.
     * @param orgs - несортированный список подразделений.
     */
    public static void sortDesc(List<String> orgs) {
        Collections.sort(orgs, new DepDescComp());
        for (String temp : orgs) {
            System.out.println(temp);
        }
    }
}
