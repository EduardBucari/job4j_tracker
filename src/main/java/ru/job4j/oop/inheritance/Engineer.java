package ru.job4j.oop.inheritance;

public class Engineer extends Profession {
    private String specializationCertificateID;
    private String lengthOfPractice;
    private String nameOfTheTechnicalUniversity;

    public String getSpecializationCertificateID() {
        return specializationCertificateID;
    }

    public String getLengthOfPractice() {
        return lengthOfPractice;
    }

    public String getNameOfTheMedicalUniversity() {
        return nameOfTheTechnicalUniversity;
    }
}
