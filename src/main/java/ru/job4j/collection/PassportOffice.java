package ru.job4j.collection;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

public class PassportOffice {
    private Map<String, Citizen> citizens = new HashMap<>();

    // Метод add вернет true, если пользователя еще нет в HashMap. Если он уже есть, то вернуть false.
    public boolean add(Citizen citizen) {
        boolean rsl = false;
        //Для решения этой задачи потребуются методы Map.containsKey(key) и Map.get(key).
        if (!citizens.containsKey(citizen.getPassport())) {
            citizens.put(citizen.getPassport(), citizen);
            return true;
        }
        return rsl;
    }

    public Citizen get(String passport) {
        // return null;
        return citizens.get(passport);
    }
}
