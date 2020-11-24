package ru.job4j.oop.inheritance;

public class Builder extends Engineer {
    private String professionalSkillLevel;
    private String experience;
    private String specialty;

    public String getProfessionalSkillLevel() {
        return professionalSkillLevel;
    }

    public String getExperience() {
        return experience;
    }

    public String getSpecialty() {
        return specialty;
    }
}
