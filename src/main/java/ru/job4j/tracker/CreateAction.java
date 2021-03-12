package ru.job4j.tracker;

//на методы createItem, replaceItem, deleteItem и тд. создать класс,
// который реализует интерфейс UserAction.
public class CreateAction implements UserAction {
    // Произведем рефакторинг проекта.
    // Нам нужно заменить вывод в консоль на интрефейс Output.
    // Внедрение зависимости будем делать через конструторы.
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Create";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(1, name);
        tracker.add(item);
        return true;
    }
}
