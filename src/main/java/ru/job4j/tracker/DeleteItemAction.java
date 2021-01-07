package ru.job4j.tracker;

public class DeleteItemAction implements UserAction {
    private final Output out;
    public DeleteItemAction(Output out) {
        this.out = out;
    }
    @Override
    public String name() {
        return "Delete item";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
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
