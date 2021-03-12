package ru.job4j.collection;

import java.util.HashMap;
import java.util.List;

public class OrderConvert {
    // Внутри метода process нужно пройти по всем элементам списка orders и вставить их в map.
    // Чтобы пройти по элементам orders используйте цикл for-each.
    // Чтобы вставить данные в map используйте метод map.put.
    // Первый параметр будет номер, а второй заявка.
    public static HashMap<String, Order> process(List<Order> orders) {
        HashMap<String, Order> map = new HashMap<>();
        for (Order temp : orders) {
             map.put(temp.getNumber(), temp);
        }
        return map;
    }
}
