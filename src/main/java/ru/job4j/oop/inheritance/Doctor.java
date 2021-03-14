package ru.job4j.oop.inheritance;

public class Doctor extends Profession {

    private String diplomaID;

    public Doctor(String name, String surname, String birthday, String education,
                  String diplomaID) {
        super(name, surname, birthday, education);
        this.diplomaID = diplomaID;
    }

        public String getDiplomaID() {
          return diplomaID;
         }

    public static void main(String[] args) {
        Doctor doctor = new Doctor("John", "Conor", "22.01.90",
                 "higher", "DRV 567");

        doctor.getName();
        doctor.getSurname();
        doctor.getBirthday();
        doctor.getEducation();
    }
}

