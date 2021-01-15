package ru.job4j.ex;

public class UserStore {

    public static User findUser(User[] users, String login) throws UserNotFoundException {
        for (int index = 0; index < users.length; index++) {
            if (users[index].getUsername().equals(login)) {
                return users[index];
            }
        }  //если пользователя не нашли в списке, то кинуть исключение UserNotFoundException.
        throw new UserNotFoundException();
    }

    public static boolean validate(User user) throws UserInvalidException {
        if (!user.isValid() || user.getUsername().length() <= 3) {
            throw new UserInvalidException();
        } //если пользователь не валидный или если имя пользователя состоит из менее трех символов,
        // то кинуть исключение UserInvalidException
        return true;
    }

    public static void main(String[] args) throws UserNotFoundException, UserInvalidException {

        User[] users = {
                new User("Petr Arsentev", true)
        };
            try {
                User user = findUser(users, "Petr");
                if (validate(user)) {
                    System.out.println("This user has an access");
                }
            } catch (UserInvalidException ea) {
                System.out.println("This user is not valid");

            } catch (UserNotFoundException en) {
                System.out.println("This user is not found");
            }

    }
}
