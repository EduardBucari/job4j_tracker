package ru.job4j.oop.inheritance_Jobs;

public class Doctor extends Profession {

    private String diplomaID;
    private String lengthOfService;
    private String nameOfTheMedicalUniversity;

    public Doctor(String diplomaID, String lengthOfService, String nameOfTheMedicalUniversity) {
        this.diplomaID = diplomaID;
        this.lengthOfService = lengthOfService;
        this.nameOfTheMedicalUniversity = nameOfTheMedicalUniversity;
    }

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
        Doctor doctor = new Doctor("DRV 567", "6 years",
                "Boston Medical University");
        doctor.getName();
        doctor.getSurname();
        doctor.getBirthday();
        doctor.getEducation();
    }
}

