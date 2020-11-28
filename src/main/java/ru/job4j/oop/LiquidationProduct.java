package ru.job4j.oop;

public final class LiquidationProduct {  // запретим наследовать класс LiquidationProduct
                                         // используя ключевое слово final
    private Product product;

    public LiquidationProduct(String name, int price) {
        product = new Product(name, price);
    }

    public String label() {
        return product.label();
    }
}
