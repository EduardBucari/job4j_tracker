package ru.job4j.oop.inheritance;

public class Doctor extends Profession {

    private String diplomaID;
    private String lengthOfService;
    private String nameOfTheMedicalUniversity;

        public String getDiplomaID () {
          return diplomaID;
         }

        public String getLengthOfService () {
            return lengthOfService;
        }

        public String getNameOfTheMedicalUniversity () {
            return nameOfTheMedicalUniversity;
        }
    public static void main(String[] args) {
        Doctor doctor = new Doctor();
        doctor.getName();
        doctor.getSurname();
        doctor.getBirthday();
        doctor.getEducation();
    }
}