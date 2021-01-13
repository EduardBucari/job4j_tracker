package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int index = 0; index < users.length; index++) {
            if (users[index] == null) { //если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.
                throw new UserNotFoundException();
            }
        }
        return null;
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user == null || ? ) {//если имя пользователя состоит из менее трех символов, то кинуть исключение UserInvalidException
              throw new UserInvalidException();
        }
        if (!user.isValid()) { //Если метод isValid() false, то нужно кинуть исключение UserInvalidException.
             throw new UserInvalidException();
        }
        if() {
            // String.length()
        }


        return true;
    }

    public static void main(String[] args) throws UserNotFoundException {
        User[] users = {
                new User("Petr Arsentev", true)
        };
        User user = findUser(users, "Petr Arsentev");
        if (validate(user)) {
            System.out.println("This user has an access");
        }
    }
}
