package ru.job4j.tracker;

public class StubInput implements Input{
    // Проблема в том, что ввод данных осуществляет пользователь, а он может ввести что угодно.
    //  доработаем данный класс, чтобы метод askStr возвращал параметры, которые мы хотим.
    private String[] answers;
    private int position = 0;

    public StubInput(String[] answers) {
        this.answers = answers;
    }

    // добавим в этот класс поле с вариантами ответов пользователя.
    // Это поле будет описывать массив строк, а так же добавим счетчик,
    // чтобы при повторном вызове метода askStr мы получали следующую ячейку из нашего массива.

    @Override
    public String askStr(String question) {
        return answers[position++];
    }

    @Override
    public int askInt(String question) {
        return Integer.parseInt(askStr(question));
    }
}
