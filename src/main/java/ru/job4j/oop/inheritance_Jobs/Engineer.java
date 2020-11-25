package ru.job4j.oop.inheritance_Jobs;

public class Engineer extends Profession {
    private String specializationCertificateID;
    private String lengthOfPractice;
    private String nameOfTheTechnicalUniversity;

    public Engineer(String specializationCertificateID, String lengthOfPractice,
                    String nameOfTheTechnicalUniversity) {
        this.specializationCertificateID = specializationCertificateID;
        this.lengthOfPractice = lengthOfPractice;
        this.nameOfTheTechnicalUniversity = nameOfTheTechnicalUniversity;

    }

    public String getSpecializationCertificateID() {
        return specializationCertificateID;
    }

    public String getLengthOfPractice() {
        return lengthOfPractice;
    }

    public String getNameOfTheTechnicalUniversity() {
        return nameOfTheTechnicalUniversity;
    }
    public static void main(String[] args) {
        Engineer engineer = new Engineer("electronic", "2 years",
                "London Technical University");
        engineer.getName();
        engineer.getSurname();
        engineer.getBirthday();
        engineer.getEducation();
    }
}
