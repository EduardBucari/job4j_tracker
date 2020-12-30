package ru.job4j.tracker;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit item ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String idName = input.askStr("Enter id name: ");
        Item item = new Item(id, idName);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Замена заявки прошла успешно!");
        } else {
            System.out.println("Произошла ошибка замены заявки");
        }
        return true;
    }
}
