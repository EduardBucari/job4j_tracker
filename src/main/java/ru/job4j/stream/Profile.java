package ru.job4j.stream;

/**
 * Модель данных - Анкета клиента.
 * В анкете у клиента, есть адрес проживания.
 */
public class Profile {
    private Address address;

    public Profile(Address address) {
        this.address = address;
    }

    public Address getAddress() {
        return address;
    }
}
