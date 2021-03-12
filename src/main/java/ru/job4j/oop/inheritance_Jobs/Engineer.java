package ru.job4j.oop.inheritance_Jobs;

public class Engineer extends Profession {
    private String specializationCertificateID;

    public Engineer(String name, String surname, String birthday, String education,
                    String specializationCertificateID) {
        super(name, surname, birthday, education);
        this.specializationCertificateID = specializationCertificateID;
    }

    public String getSpecializationCertificateID() {
        return specializationCertificateID;
    }

    public static void main(String[] args) {
        Engineer engineer = new Engineer("Peter", "Parker", "5.04.99",
                 "technical", "electronic452-VD");
        engineer.getName();
        engineer.getSurname();
        engineer.getBirthday();
        engineer.getEducation();
    }
}
