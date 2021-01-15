package ru.job4j.tracker;

//Ошибка со стороны пользователя - Ввод строки вместо числа.
//метод ConsoleInput.askInt(String question), в нём предусмотрены не все действия пользователя.
//Давайте добавим в него нужное поведение за счет механизма переопределения (override).
//Чтобы использовать переопределение метода, нужно создать класс, который будет наследовать ConsoleInput.

public class ValidateInput extends ConsoleInput {
    @Override
    public int  askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try{
                value = super.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                System.out.println("Please enter validate data again.");
            }
        }while (invalid);
        return value;
    }
}
