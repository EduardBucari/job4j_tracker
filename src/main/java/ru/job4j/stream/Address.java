package ru.job4j.stream;

import java.util.Objects;

/**
 * Модель данных:
 * Задача - составить список адресов клиентов.
 * В анкете у клиента, есть адрес проживания.
 * Адрес, который используется в этой модели описывается следующим классом:
 */
public class Address {
    private String city;
    private String street;
    private int home;
    private int apartment;

    // создаем конструктор и генирируем гетеры:
    public Address(String city, String street,
                   int home, int apartment) {
        this.city = city;
        this.street = street;
        this.home = home;
        this.apartment = apartment;
    }

    public String getCity() {
        return city;
    }

    public String getStreet() {
        return street;
    }

    public int getHome() {
        return home;
    }

    public int getApartment() {
        return apartment;
    }

    //Чтобы сравнить объекты класса Address,
    // нужно в классе Address определить два методы equals и hashCode.

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Address address = (Address) o;
        return home == address.home
                && apartment == address.apartment
                && Objects.equals(city, address.city)
                && Objects.equals(street, address.street);
    }

    @Override
    public int hashCode() {
        return Objects.hash(city, street, home, apartment);
    }
}
