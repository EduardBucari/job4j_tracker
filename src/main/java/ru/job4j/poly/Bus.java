package ru.job4j.poly;

public class Bus implements Transport{
    @Override
    public String go() {
        return null;
    }

    @Override
    public int quantityOfPassengers(int quantity) {
        return 0;
    }

    @Override
    public int fill(int fuelQuantity, int price) {
        return price;
    }
}
