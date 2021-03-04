package ru.job4j.bank;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

// 3. Создаем главный сервис:
//1 Регистрировать пользователя.
//2 Удалять пользователя из системы.
//3 Добавлять пользователю банковский счет. У пользователя системы могут быть несколько счетов.
//4 Переводить деньги с одного банковского счета на другой счет.
public class BankService {

    // Это поле содержит всех пользователей системы с привязанными к ним счетами.
      private Map<User, List<Account>> users = new HashMap<>();


     /* Чтобы добавить пользователя в систему нужно использовать метод Map.put
      Этот метод принимает два параметра: пользователя и список счетов.
      По умолчанию нужно добавить пустой список - new ArrayList<Account>().
      В методе должна быть проверка, что такого пользователя еще нет в системе.
      Если он есть, то нового добавлять не надо. */
      public void addUser(User user) {
          this.users.putIfAbsent(user, new ArrayList<>());
      }

      public void deleteUser(User user) {
          this.users.remove(user);  // Удалять пользователя из системы.
      }



      /* Этот метод должен добавить новый счет к пользователю.
      Первоначально пользователя нужно найти по паспорту.
      Для этого нужно использовать метод findByPassport.
      После этого мы получим список всех счетов пользователя и добавим новый счет к ним.
      В этом методе должна быть проверка, что такого счета у пользователя еще нет.
      -------
      Нашли user, проверили его на null, потом получили список аккаунтов
      List<Account> accounts = users.get(user);
      и вот уже этот список проверяем нет ли там еще добавляемого
      аккаунта с помощью метода contains()
      и вот после проверки добавляем в список аккаунтов
      необходимый аккаунт с помощью метода add()
      */
      public void addAccount(String passport, Account account) {
          User user = user.findByPassport(passport);
          if (user != null) {
              List<Account> accounts = users.get(user);
                  if (!accounts.contains(account)){
                      accounts.add(account);
                  }
          }
      }

      /* Этот метод ищет пользователя по номеру паспорта.
      Здесь нужно использовать перебор всех элементов через цикл for-each и метод Map.keySet.*/
      public User findByPassport(String passport) {
          for (User user : users.keySet()) {
              if (user.getPassport().equals(passport)) {
                   return user;
              }
          }
          return null;
      }

      /*
      Этот метод ищет счет пользователя по реквизитам. Сначала нужно найти пользователя.
      Потом получить список счетов этого пользователя и в нем найти нужный счет.
      Поиск по реквизитам:
- находим пользователя с помощью findByPassport
- проверяем найденного пользователя на null
- если не null - получаем список аккаунтов с помощью get() из карты
- перебираем в цикле аккаунты и сравниваем с реквизитами которые передали в метод
- нашли совпадение и вернули этот аккунт
- если ничего не нашли - возвращаем null
*/
      public Account findByRequisite(String passport, String requisite) {
          User user = user.findByPassport(passport);
            if (user != null) {
                List<Account> accounts = users.get(user);

                // В цикле мы перебираем список аккаунтов и сравниваем реквизиты
                // каждого аккаунта с этими реквизитами
                // и как только нашли совпадение - вернули найденный аккаунт.
                // Внутри цикла должна быть проверка поля requisite у аккаунта
                for (Account account  : accounts) {
                   if (requisite.equals(account.getRequisite())) {
                       return account;
                   }
                }
            }
          return null;
      }

      /*Метод для перечисления денег с одного счёта на другой счёт.
        Если счёт не найден или не хватает денег на счёте srcAccount (с которого переводят),
        то метод должен вернуть false.*/
      public boolean transferMoney(String srcPassport, String srcRequisite,
                                   String destPassport, String destRequisite, double amount) {
          boolean rsl = false;
          Account srcAccount = findByRequisite(srcPassport, srcRequisite);
          Account destAccount = findByRequisite(destPassport, destRequisite);
          if (srcAccount.getBalance() >= amount) {
              srcAccount.setBalance(srcAccount.getBalance() - amount);
              destAccount.setBalance(destAccount.getBalance() + amount);
              rsl = true;
          }
          if (srcAccount == null && destAccount == null) {
              return false;
          }
          return rsl;
      }
}
