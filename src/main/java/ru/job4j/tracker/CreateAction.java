package ru.job4j.tracker;

//на методы createItem, replaceItem, deleteItem и тд. создать класс,
// который реализует интерфейс UserAction.
public class CreateAction implements UserAction {
    @Override
    public String name() {
        return "=== Create a new Item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item item = new Item(1, name);
        tracker.add(item);
        return true;
    }
}
