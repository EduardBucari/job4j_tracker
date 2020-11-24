package ru.job4j.oop.inheritance;

public class Programmer extends Engineer {
    private String knowledgeOfTheProgrammingLanguage;
    private String knowledgeOfFrameworks;
    private String additionalKnowledge;

    public String getKnowledgeOfTheProgrammingLanguage() {
        return knowledgeOfTheProgrammingLanguage;
    }

    public String getKnowledgeOfFrameworks() {
        return knowledgeOfFrameworks;
    }

    public String getAdditionalKnowledge() {
        return additionalKnowledge;
    }
}
