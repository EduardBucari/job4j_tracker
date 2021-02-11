package ru.job4j.search;

import java.security.PublicKey;
import java.util.ArrayList;


//составим модель справочника
public class PhoneDictionary {
    private ArrayList<Person> persons = new ArrayList<Person>();

    public void add(Person person) {
        this.persons.add(person);
    }
    /*
      Поиск мы должны осуществлять по всем полям через метод String.contains.
      String contains()- метод чтобы проверить, содержит ли String указанную последовательность символов.
      Этот метод возвращает логический тип данных, который является результатом тестирования.

      Вернуть список всех пользователей, который содержат key в любых полях.
      @param key Ключ поиска.
      @return Список подощедщих пользователей.
     */

   /*
   Чтобы узнать, есть в массиве какой-либо элемент, можно воспользоваться методом contains(),
   который вернёт true или false". В List "элемент" - это строка!
   циклом for () происходит перебор массива на составляющие элементы.
   В данном случае на строки (тип String). Т.е. в оператор сравнения уже попадает строка.
   А уже у строк есть метод contains, который ищет в ней символы.
   */
 for (Object value : persons) {
        return value;
    }

//===================================================================
    public ArrayList<Person> find(String key) {
        ArrayList<Person> result = new ArrayList<>();
        return result;
    }
}
