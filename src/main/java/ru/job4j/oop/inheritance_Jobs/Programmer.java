package ru.job4j.oop.inheritance_Jobs;

public class Programmer extends Engineer {
    private String knowledgeOfTheProgrammingLanguage;


    public Programmer(String name, String surname, String birthday, String education,
                      String specializationCertificateID,
                      String knowledgeOfTheProgrammingLanguage) {
        super(name, surname, birthday, education, specializationCertificateID);
        this.knowledgeOfTheProgrammingLanguage = knowledgeOfTheProgrammingLanguage;
    }

    public String getKnowledgeOfTheProgrammingLanguage() {
        return knowledgeOfTheProgrammingLanguage;
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer("Tony","Stark", "11.03.63",
                "higher", "IronMan 01",
                "Java");
        programmer.getName();
        programmer.getSurname();
        programmer.getBirthday();
        programmer.getEducation();
        programmer.getSpecializationCertificateID();

    }
}
