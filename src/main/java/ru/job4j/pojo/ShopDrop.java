package ru.job4j.pojo;

public class ShopDrop {
    public static Product[] leftShift(Product[] products, int index) {

        for (int i = 0; i < products.length; i++) {
            Product product = products[i];
            if (product != null) {
                int j = i + 1;
                    products[i] = products[j];
                    products[j] = null;
                }
            }
        return products;
    }
}

