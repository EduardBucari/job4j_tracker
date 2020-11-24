package ru.job4j.oop.inheritance;

public class Doctor extends Profession {
    private String diplomaID;
    private String lengthOfService;
    private String nameOfTheMedicalUniversity;

    public String getDiplomaID() {
        return diplomaID;
    }

    public String getLengthOfService() {
        return lengthOfService;
    }

    public String getNameOfTheMedicalUniversity() {
        return nameOfTheMedicalUniversity;
    }
}