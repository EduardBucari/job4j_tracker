package ru.job4j.bank;

import java.util.*;

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
 *
 * 7 Задание.
 *   Поправьте методы поиска элементов в задании "Банковские переводы".
 *   Метод должны использовать Stream API и вернуть Optional.
 *   Обратите внимание, что метод findFirst() возвращает тип Optional.
 *
 *   Терминальные методы поиска в Stream API возвращают объект Optional.
 *   Методы поиска могут вернуть null. C null объектом в потоке данных работать уже нельзя,
 *   поэтому все null оборачиваются в Optional.
 *   Метод findFirst вернет первый элемент отфильтрованного потока.
 *   Если отфильтрованный поток пустой, то нужно вернуть null.
 *   Поэтому здесь используется Optional.
 *
 *   Объект Optional предупреждает программиста, что метод может вернуть null
 *   и нужно добавить проверку, что объект не null-ссылка.
 *   Чтобы проверить, что объект не null используйте метод if (opt.isPresent())
 *   Чтобы получить значение этого объекта, используйте метод opt.get()
 *
 *   Метод .get() добавить в тестах BankServiceTest:
 *    в тесте addAccount() добавим get().getBalance()
 *    и в тесте transferMoney() добавим get().getBalance()
 *
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
          this.users.putIfAbsent(user, new ArrayList<Account>());
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
          Optional<User> user = findByPassport(passport);
          if (user.isPresent()) {
              List<Account> accounts = users.get(user.get());
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
      public Optional<User> findByPassport(String passport) {
          return users.keySet()
                  .stream()
                  .filter(key -> key.getPassport().equals(passport))
                  .findFirst();
      }

    /**
     * Этот метод ищет счет пользователя по реквизитам.
     * Сначала нужно найти пользователя.
     * Потом получить список счетов этого пользователя и в нем найти нужный счет.
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
      public Optional<Account> findByRequisite(String passport, String requisite) {
          Optional<User> user = findByPassport(passport);
            if (user.isPresent()) {
                List<Account> accounts = users.get(user.get());
                return accounts
                        .stream()
                        .filter(a -> a.getRequisite().equals(requisite))
                        .findFirst();
            } else {
                return Optional.empty();
            }
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
          Optional<Account> srcAccount = findByRequisite(srcPassport, srcRequisite);
          Optional<Account> destAccount = findByRequisite(destPassport, destRequisite);
          if (srcAccount.isPresent() && destAccount.isPresent()
                  && srcAccount.get().getBalance() >= amount) {
              srcAccount.get().setBalance(srcAccount.get().getBalance() - amount);
              destAccount.get().setBalance(destAccount.get().getBalance() + amount);
              rsl = true;
          }
          return rsl;
      }
}
