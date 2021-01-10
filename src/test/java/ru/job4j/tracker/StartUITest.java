package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenAddItem() {
        String[] answers = {"Fix PC"};
        Input input = new StubInput(answers);
        Tracker tracker = new Tracker();
        StartUI.createItem(input, tracker);
        Item created = tracker.findAll()[0];
        Item expected = new Item(0,"Fix PC");
        assertThat(created.getName(), is(expected.getName()));
    }
 //------------------------------------------
  /*  @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "new item");
        tracker.add(item);
        String[] answers = {
               String.valueOf(item.getId()), // id сохраненной заявки в объектк tracker.
               "replaced item"
        };
        StartUI.replaceItem(new StubInput(answers), tracker);
        Item replaced = tracker.findById(item.getId());
        assertThat(replaced.getName(), is("replaced item"));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = new Item(1, "new item");
        String[] answers = {
                String.valueOf(item.getId()),
        };
        StartUI.deleteItem(new StubInput(answers), tracker);
        Item deleted = tracker.findById(item.getId());
        assertNull(deleted);
    } */
  // --------------------------------------
    // Напишем тест, который добавляет данные в трекер.
    //Сценарий теста:
    // 1. Показать меню.
    // 2. Выбрать пункт "Создание заявки"
    // 3. Выбрать пункт "Выйти"
    // 4. Проверить, что в объект Tracker появилась новая заявка с именем "Item name".
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
          new  String[] {"0", "Item name", "1"}  // 0 - это пункт меню "Создать новую заявку"
                                                 // "Item name" - это имя новой заявки.
                                                 // 1 - это пункт меню "Выйти".
        );
        Tracker tracker = new Tracker();
        UserAction[] actions = {
                new CreateAction(new StubOutput()),
                new Exit(new StubOutput())
        };
       new StartUI(new StubOutput()).init(in, tracker, actions);
       assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    //Допишим тест на пункты ReplaceAction, DeleteAction.
    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item(2, "Replace item")); //Добавим в tracker новую заявку.
       // Входные данные должны содержать ID добавленной заявки item.getId();
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", "1"} // 0 - это входные параметры для ReplaceAction;
        );
        UserAction[] action = {
                new ReplaceAction(new StubOutput()),
                new Exit(new StubOutput())
        };
        new StartUI(new StubOutput()).init(in, tracker, action);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item(2, "Deleted item")); //Добавим в tracker новую заявку.
        Input in = new StubInput(
                new String[] {"0", "1"} // 0 - это входные параметры для DeleteAction;
        );
        UserAction[] actions = {
                new DeleteItemAction(new StubOutput()),
                new Exit(new StubOutput())
        };
        new StartUI(new StubOutput()).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }


    //мы избавились от зависимости к System.out.
    //Это дает возможность написать тесты на оставшиеся Actions.
    //Произвести тестирование классов FindAllAction, FindByNameAction, FindByIdAction.
    @Test
    public  void whenFindAllAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1"}
        );
        Tracker tracker = new Tracker();
        Item findAll = tracker.add(new Item(0, "Find ALL"));
        UserAction[] actions = {
                new FindAllItemsAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln + "=== Show all items ===" + ln
                        + findAll + ln
                        + "Menu." + ln
                        + "0. Show all items" + ln
                        + "1. Exit" + ln + "=== Exit ===" + ln
        ));
    }

    @Test
    public  void whenFindByNameAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "Find by name", "1"}
        );
        Tracker tracker = new Tracker();
        Item findByName = tracker.add(new Item(0, "Find by name"));
        UserAction[] actions = {
                new FindItemsByNameAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln + "=== Find items by name ===" + ln
                        + findByName + ln
                        + "Menu." + ln
                        + "0. Find item by name" + ln
                        + "1. Exit" + ln + "=== Exit ===" + ln
        ));
    }

    @Test
    public  void whenFindByIdAction() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"0", "1", "1"}
        );
        Tracker tracker = new Tracker();
        Item findById = tracker.add(new Item(0, "Find by Id"));
        UserAction[] actions = {
                new FindItemByIdAction(out),
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "0. Find item by Id" + ln
                        + "1. Exit" + ln + "=== Find item by Id ===" + ln
                        + findById + ln
                        + "Menu." + ln
                        + "0. Find item by Id" + ln
                        + "1. Exit" + ln + "=== Exit ===" + ln
        ));
    }


    //Напишем тест whenExit()
    //Сценарий теста.
    // 1. Трекер загружается с одним действием - "выйти".
    // 2. На консоль выводится пункт "Выйти".
    // 3. В тесте проверяем, что StubInput содержит вывод меню.

    @Test
    public  void whenExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"1"}
        );
        Tracker tracker = new Tracker();
        Item exit = tracker.add(new Item(1, "Exit"));
        UserAction[] actions = {
                new Exit(out)
        };
        new StartUI(out).init(in, tracker, actions);
        String ln = System.lineSeparator();
        assertThat(out.toString(), is(
                "Menu." + ln
                        + "1. Exit" + ln + "=== Exit ===" + ln
                        + exit + ln
                        + "Menu." + ln
                        + "1. Exit" + ln + "=== Exit ===" + ln
        ));
    }
}
