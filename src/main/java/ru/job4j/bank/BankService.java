package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Класс описывает создание хэш-карты на основе пользователя в качестве ключа и список.
 *   Создаем главный сервис, основная функция которого:
 * 1 Регистрировать пользователя.
 * 2 Удалять пользователя из системы.
 * 3 Добавлять пользователю банковский счет. (У пользователя системы могут быть несколько счетов).
 * 4 Поиск пользователя по паспорту.
 * 5 Переводить деньги с одного банковского счета на другой счет.
 * 6 В задаче Банковские переводы из модуля Коллекции Lite и переделать методы поиска по паспорту
 *   и реквизитам на использование вместо циклов - Stream API.
 * @author Eduard Bucari
 * @version 1.0
 */
public class BankService {
    /**
     *  Поле users содержит всех пользователей системы с привязанными к ним счетами.
     */
    private Map<User, List<Account>> users = new HashMap<>();

    /**
     * Чтобы добавить пользователя в систему нужно использовать метод putIfAbsent
     * Этот метод принимает два параметра: пользователя и список счетов.
     * @param user - пользователь.
     * В методе должна быть проверка, что такого пользователя
     * еще нет в системе. Если он есть, то нового добавлять не надо.
     */
    public void addUser(User user) {
          this.users.putIfAbsent(user, new ArrayList<>());
      }

    /**
     *Чтобы удалить пользователя из системы нужно использовать метод remove(),
     * Этот метод принимает один параметр: (пользователь)
     * @param user - пользователь
     */
      public void deleteUser(User user) {
          this.users.remove(user);
      }

    /**
     * Этот метод должен добавить новый счет к пользователю.
     * @param passport Первоначально пользователя нужно найти по паспорту.
     *       Для этого нужно использовать метод findByPassport.
     * @param account После этого мы получим список всех счетов пользователя
     *                и добавим новый счет к ним.
     *       В этом методе должна быть проверка, что такого счета у пользователя еще нет.
     *  Нашли user, проверили его на null, потом получили список аккаунтов
     *       List Account accounts = users.get(user);
     *       и вот уже этот список проверяем нет ли там еще добавляемого
     *       аккаунта с помощью метода contains()
     *       и вот после проверки добавляем в список аккаунтов
     *       необходимый аккаунт с помощью метода add()
     */
      public void addAccount(String passport, Account account) {
          User user = findByPassport(passport);
          if (user != null) {
              List<Account> accounts = users.get(user);
                  if (!accounts.contains(account)) {
                      accounts.add(account);
                  }

          }
      }

    /**
     * Этот метод ищет пользователя по номеру паспорта.
     * - Переделать метод поиска по паспорту,
     *   вместо циклов пишем Stream API.
     * @param passport для этого нужно использовать перебор всех элементов
     *                 через цикл for-each и метод Map.keySet
     * @return возвращает пользователя или null если пользователь не найден.
     */
      public User findByPassport(String passport) {
          return users.keySet()
                  .stream()
                  .filter(key -> key.getPassport().equals(passport))
                  .findFirst()
                  .orElse(null);
      }

    /**
     * Этот метод ищет счет пользователя по реквизитам. Сначала нужно найти пользователя.
     *       Потом получить список счетов этого пользователя и в нем найти нужный счет.
     *  - Переделать метод поиска по реквизитам,
     *     вместо циклов пишем Stream API.
     * @param passport - поиск пользователя по паспорту, с помощью метода findByPassport
     * @param requisite - поиск по реквизитам, проверяем найденного пользователя на null,
     *   если не null - получаем список аккаунтов с помощью get() из карты
     *   перебираем в цикле аккаунты и сравниваем с реквизитами которые передали в метод.
     *    В цикле мы перебираем список аккаунтов и сравниваем реквизиты
     *    каждого аккаунта с этими реквизитами,
     *    и как только нашли совпадение - вернули найденный аккаунт.
     *    Внутри цикла должна быть проверка поля requisite у аккаунта.
     * @return нашли совпадение и вернули этот аккунт, если ничего не нашли - возвращаем null
     */
      public Account findByRequisite(String passport, String requisite) {
          User user = findByPassport(passport);
            if (user != null) {
                List<Account> accounts = users.get(user);
                return accounts
                        .stream()
                        .filter(a -> a.getRequisite().equals(requisite))
                        .findFirst()
                        .orElse(null);
            }
          return null;
      }

      /*Метод для перечисления денег с одного счёта на другой счёт.
        Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
        то метод должен вернуть false.*/

    /**
     * Метод предназначен для перечисления денег с одного счёта на другой счёт.
     * @param srcPassport - паспорт отправителя,
     * @param srcRequisite - банковские реквизиты отправителя,
     * @param destPassport - паспорт получателя,
     * @param destRequisite - банковские реквизиты получателя,
     * @param amount - сумма денег на счету для перевода.
     * @return Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
     *         то метод должен вернуть false.
     */
      public boolean transferMoney(String srcPassport, String srcRequisite,
                                   String destPassport, String destRequisite, double amount) {
          boolean rsl = false;
          Account srcAccount = findByRequisite(srcPassport, srcRequisite);
          Account destAccount = findByRequisite(destPassport, destRequisite);
          if (srcAccount != null && destAccount != null && srcAccount.getBalance() >= amount) {
              srcAccount.setBalance(srcAccount.getBalance() - amount);
              destAccount.setBalance(destAccount.getBalance() + amount);
              rsl = true;
          }
          return rsl;
      }
}
