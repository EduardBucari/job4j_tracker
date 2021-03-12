package ru.job4j.tracker;

public class FindItemByIdAction implements UserAction {
    private final Output out;

    public FindItemByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "Find item by Id";
    }

    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println("=== Find item by Id ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            out.println(rsl);
        } else {
            out.println("Заявка с таким id не найдена");
        }
        return true;
    }
}
