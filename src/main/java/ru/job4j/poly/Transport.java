package ru.job4j.poly;

public interface Transport {
    String go();
    int quantityOfPassengers(int quantity);
    int fill(int fuelQuantity, int price);
}
