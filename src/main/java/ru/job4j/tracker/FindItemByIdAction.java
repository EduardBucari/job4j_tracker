package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find item by Id ===";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            System.out.println(rsl);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
