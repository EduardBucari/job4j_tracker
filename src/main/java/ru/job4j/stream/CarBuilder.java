package ru.job4j.stream;

/**
 * Шаблоны проектирования Builder в Stream API.
 * Задание.
 * 1. Создайте произвольную модель данных, определите в ней 5-7 полей с различным типами,
 *    которые максимально подробно описывают выбранную Вами модель данных.
 * 2. За счет шаблона проектирования Builder напишите реализацию класса,
 *    который будет строить наш объект.
 */
public class CarBuilder {
    private String model;
    private String color;
    private int wheels;
    private int doors;
    private boolean ready;

    @Override
    public String toString() {
        return "CarBuilder{"
                + "model='" + model + '\''
                + ", color='" + color + '\''
                + ", wheels=" + wheels
                + ", doors=" + doors
                + ", ready=" + ready
                + '}';
    }

    /**
     * Шаблон проектирования Builder предлагает разбить процесс
     * конструирования объекта на отдельные шаги.
     *   1 шаг - мы убираем конструктор и добавляем вложенный статический класс Builder
     *   2 шаг - мы копируем в наш вложенный класс поля, которые объявлены
     *   внутри класса CarBuilder - и наш вложенный класс приобретет вид:
     */
    static class Builder {
        private String model;
        private String color;
        private int wheels;
        private int doors;
        private boolean ready;

        /**
         * 3 шаг - добавление методов, которые будут инициализировать поля,
         * объявленные внутри вложенного класса и при этом возвращать тип Builder
         */
        Builder buildModel(String model) {
            this.model = model;
            return this;
        }

        Builder buildColor(String color) {
            this.color = color;
            return this;
        }

        Builder buildWheels(int wheels) {
            this.wheels = wheels;
            return this;
        }

        Builder buildDoors(int doors) {
            this.doors = doors;
            return this;
        }

        Builder buildReady(boolean ready) {
            this.ready = ready;
            return this;
        }


        /**
         * 4 шаг - Реализация шаблона т.е. реализация метода, который
         * построит нам готовый объект и вернет его экземпляр:
         */
        CarBuilder build() {
            CarBuilder carBuilder = new CarBuilder();
            carBuilder.model = model;
            carBuilder.color = color;
            carBuilder.wheels = wheels;
            carBuilder.doors = doors;
            carBuilder.ready = ready;
            return carBuilder;
        }
    }

    /**
     * Выведем результат на экран.
     * Метод build() мы будем вызывать последним для того, чтобы вернуть готовый объект.
     * Его поведение схоже с терминальными операциями в Stream API,
     * которые возвращают результат из потока, а не поток, как это делают конвейерные методы.
     * Давайте попробуем использовать эту реализацию шаблона в методе main:
     */
    public static void main(String[] args) {
        CarBuilder carBuilder = new CarBuilder.Builder()
                .buildModel("BMW")
                .buildColor("Black")
                .buildWheels(4)
                .buildDoors(2)
                .buildReady(true)
                .build();
        System.out.println(carBuilder);
    }
}
