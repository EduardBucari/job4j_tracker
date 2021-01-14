package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int index = 0; index < users.length; index++) {
            if (users[index] != null) {
                return users[index];
            }
        }  //если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.
        throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (user.isValid() || user.getUsername().length() >= 3) {
            return true;
        } //если пользователь не валидный или если имя пользователя состоит из менее трех символов,
        // то кинуть исключение UserInvalidException
        throw new UserInvalidException();

        if (user.isValid()) {
            return true;
        } //Если метод isValid() false, то нужно кинуть исключение UserInvalidException.
        throw new UserInvalidException();

        if (user.getUsername().length() >= 3) {
            return true;
        }// у объекта user количество символов в поле username меньше 3.
        // Если оно меньше, то нужно выкинуть исключение UserInvalidException.
        throw new UserInvalidException();
    }

    public static void main(String[] args) throws UserNotFoundException, UserInvalidException {
        User[] users = {
                new User("Petr Arsentev", true)
        };

        User user = findUser(users, "Petr Arsentev");

        if (validate(user)) {
            System.out.println("This user has an access");
        }
        try {
            if () {

            }
        } catch (UserNotFoundException en) {
            System.out.println("This user is not found");;
        } catch (UserInvalidException ea) {
            System.out.println("This user is not valid");
        }
    }
}
