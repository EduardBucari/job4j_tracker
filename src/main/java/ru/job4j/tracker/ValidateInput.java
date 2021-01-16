package ru.job4j.tracker;

/* Ошибка со стороны пользователя - Ввод строки вместо числа.
  метод ConsoleInput.askInt(String question), в нём предусмотрены не все действия пользователя.
  Давайте добавим в него нужное поведение за счет механизма переопределения (override).
  Чтобы использовать переопределение метода, нужно создать класс(ValidateInput),
  который будет наследовать ConsoleInput.
  Смысл введения этого класса - это добавление новой логики в существующий метод.
  Что делает класс ValidateInput - он получает данные из системы ввода до тех пор,
  пока не введут правильные символы.
  Источник данных находится в классе ConsoleInput.  */

/*
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
        } while (invalid);
        return value;
    }
}
*/

// избавимся от наследования за счет использования композиции.
// Создадим поле, которое будет содержать источник данных.
// В данном случае он описывается нашим интерфейсом Input.

public class ValidateInput implements Input {
    private final Output out;
    private final Input in;

    public ValidateInput(Output out, Input input) {
        this.out = out;
        this.in = input;
    }

    @Override
    public String askStr(String question) {
        return in.askStr(question);
    }

    @Override
    public int askInt(String question) {
        boolean invalid = true;
        int value = -1;
        do {
            try {
                value = in.askInt(question);
                invalid = false;
            } catch (NumberFormatException nfe) {
                out.println("Please enter validate data again.");
            }
        } while (invalid);
        return value;
    }
}
// Эти изменения позволили избавиться от связи с классом ConsoleInput.
// Часть реализации мы получаем за счет ссылки на реализацию private Input input;
// То есть мы можем в это поле передать класс ConsoleInput или StubInput и
// к их поведению добавить поведение валидации.
// Адаптируем StartUI.main