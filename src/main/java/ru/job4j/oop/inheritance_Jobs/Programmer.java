package ru.job4j.oop.inheritance_Jobs;

public class Programmer extends Engineer {
    private String knowledgeOfTheProgrammingLanguage;
    private String knowledgeOfFrameworks;
    private String additionalKnowledge;

    public Programmer(String knowledgeOfTheProgrammingLanguage, String knowledgeOfFrameworks,
                      String additionalKnowledge) {
        this.knowledgeOfTheProgrammingLanguage = knowledgeOfTheProgrammingLanguage;
        this.knowledgeOfFrameworks = knowledgeOfFrameworks;
        this.additionalKnowledge = additionalKnowledge;
    }

    public String getKnowledgeOfTheProgrammingLanguage() {
        return knowledgeOfTheProgrammingLanguage;
    }

    public String getKnowledgeOfFrameworks() {
        return knowledgeOfFrameworks;
    }

    public String getAdditionalKnowledge() {
        return additionalKnowledge;
    }

    public static void main(String[] args) {
        Programmer programmer = new Programmer("Java",
                "Spring", "Hibernate");
        programmer.getName();
        programmer.getSurname();
        programmer.getBirthday();
        programmer.getEducation();
        programmer.getSpecializationCertificateID();
        programmer.getLengthOfPractice();
        programmer.getNameOfTheTechnicalUniversity();
    }
}
