package ru.job4j.tracker;

public class StartUI {

    public static void createItem(Input input, Tracker tracker) {
        System.out.println("=== Create a new Item ===");
        String name = input.askStr("Enter name: ");
        Item item = new Item(0, name);
        tracker.add(item);
    }

    public static void findAllItems(Tracker tracker) {
        System.out.println("=== Show all items ===");
        Item[] rsl = tracker.findAll();
        for (int i = 0; i < rsl.length; i++) {
            System.out.println(rsl[i]);
        }
    }

    public static void replaceItem(Input input, Tracker tracker) {
        System.out.println("=== Edit item ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        String idName = input.askStr("Enter id name: ");
        Item item = new Item(id, idName);
        boolean rsl = tracker.replace(id, item);
        if (rsl) {
            System.out.println("Замена заявки прошла успешно!");
        } else {
            System.out.println("Произошла ошибка замены заявки");
        }
    }

    public static void deleteItem(Input input, Tracker tracker) {
        System.out.println("=== Delete item ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        boolean rsl = tracker.delete(id);
        if (rsl) {
            System.out.println("Удаление заявки прошло успешно!");
        } else {
            System.out.println("Произошла ошибка в удалении заявки!");
        }
    }

    public static void findItemById(Input input, Tracker tracker) {
        System.out.println("=== Find item by Id ===");
        int id = Integer.parseInt(input.askStr("Enter id: "));
        Item rsl = tracker.findById(id);
        if (rsl != null) {
            System.out.println(rsl);
        } else {
            System.out.println("Заявка с таким id не найдена");
        }
    }

    public static void findItemByName(Input input, Tracker tracker) {
        System.out.println("=== Find items by name ===");
        String orderNames = input.askStr("Enter order names: ");
        Item[] rsl = tracker.findByName(orderNames);
        if (rsl.length > 0) {
            for (int i = 0; i < rsl.length; i++) {
                System.out.println(rsl[i]);
            }
        } else {
            System.out.println("Заявки с таким именем не найдены");
        }
    }

    public static void exit(Input input, Tracker tracker) {
        System.out.println("=== Exit ===");
    }

    private final Output out;
    public StartUI(Output out) {
        this.out =out;
    }

    public void init(Input input, Tracker tracker, UserAction[] actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            // Рефакторинг кода. Добавим обработку ситуаций: ввод несуществующего пункта меню.
          //  Доработаем класс StartUI, чтобы он проверял, есть ли такой пункт в меню.
            if (select < 0 || select >= actions.length) {
                out.println("Wrong input, you can select: 0 .. " + (actions.length - 1));
                continue;
            }
            UserAction action = actions[select];
            run = action.execute(input, tracker);
        }
    }
        private void showMenu(UserAction[] actions) {
            out.println("Menu.");
            for(int index = 0; index < actions.length; index++) {
                out.println(index + ". " + actions[index].name());
            }
        }

    public static void main(String[] args) {
        //Рефакторинг кода. Добавим обработку ситуаций: ввод строки вместо числа.
        Output output = new ConsoleOutput();
        Input input = new ValidateInput();
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(output),
                new FindAllItemsAction(output),
                new ReplaceAction(output),
                new DeleteItemAction(output),
                new FindItemByIdAction(output),
                new FindItemsByNameAction(output),
                new Exit(output),
                new ValidateAction(input)
        };
        new StartUI(output).init(input, tracker, actions);
    }
}
