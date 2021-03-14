package ru.job4j.oop.inheritance;

public class Dentist extends Doctor {
    private String typeOfDentistry;

    public Dentist(String name, String surname, String birthday, String education,
                   String diplomaID, String typeOfDentistry) {
        super(name, surname, birthday, education, diplomaID);
        this.typeOfDentistry = typeOfDentistry;
    }

    public String getTypeOfDentistry() {
        return typeOfDentistry;
    }

    public static void main(String[] args) {
        Dentist dentist = new Dentist("Hannibal", "Lecter", "23.04.63",
                "higher", "drtv-6397", "Adult dentistry");
        dentist.getName();
        dentist.getSurname();
        dentist.getBirthday();
        dentist.getEducation();
        dentist.getDiplomaID();
    }
}
