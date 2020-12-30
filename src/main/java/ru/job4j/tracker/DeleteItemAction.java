package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("Удаление заявки прошло успешно!");
        } else {
            System.out.println("Произошла ошибка в удалении заявки!");
        }
        return true;
    }
}
