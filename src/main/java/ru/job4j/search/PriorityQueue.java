package ru.job4j.search;

import java.util.LinkedList;

public class PriorityQueue {
    private LinkedList<Task> tasks = new LinkedList<>();
    /*
     * Метод должен вставлять в нужную позицию элемент.
     * Позиция определяется по полю приоритет.
     * Для вставки использовать add(int index, E value)
     * @param task задача
     */

    //В методе put нужно найти index нужного элемента. Если элементов нет, тогда index будет равен 0.
    //Если нужно вставить элемент в конец списка, тогда необходимо пройти по всем элементам,
    // и индекс будет равен размеру всей коллекции.

   public void put(Task task) {
       int index = 0;

       for (Task element : tasks) {
            if (element.getPriority() < task.getPriority()) {
                index ++;
            } else {
                break;

               // Необходимо пройти циклом по tasks, сравнивая в if приоритет element с приоритетом task.
               // Если приоритет больше у task, index увеличить на 1. Если приоритет больше у element,
               // прервать цикл и по текущему индексу записать task в tasks.
             }
       }
       this.tasks.add(index, task);
   }

    //Метод take возвращает первый элемент из списка и удаляет его. Эти действия мы делаем через метод poll().
   public Task take() {
       return tasks.poll();
   }
}
