package ru.job4j.stream;

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
}
