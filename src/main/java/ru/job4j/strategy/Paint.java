package ru.job4j.strategy;

// В классе Paint реализовать метод public void draw(Shape shape).
// Метод draw() должен печатать псевдокартинку на консоль
// через метод System.out.println(shape.draw());
public class Paint {
    public void draw(Shape shape) {
        System.out.println(shape.draw());
    }

    public static void main(String[] args) {
        Paint context = new Paint();
        context.draw(new Triangle());
        context.draw(new Square());
    }
}
