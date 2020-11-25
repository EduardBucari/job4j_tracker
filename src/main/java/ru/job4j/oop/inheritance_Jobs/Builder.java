package ru.job4j.oop.inheritance_Jobs;

public class Builder extends Engineer {
    private String professionalSkillLevel;
    private String experience;
    private String specialty;

    public Builder(String professionalSkillLevel, String experience, String specialty) {
        this.professionalSkillLevel = professionalSkillLevel;
        this.experience = experience;
        this.specialty = specialty;
    }

    public String getProfessionalSkillLevel() {
        return professionalSkillLevel;
    }

    public String getExperience() {
        return experience;
    }

    public String getSpecialty() {
        return specialty;
    }

    public static void main(String[] args) {
        Builder builder = new Builder("Level 4", "12 years",
                "welder");
        builder.getName();
        builder.getSurname();
        builder.getBirthday();
        builder.getEducation();
        builder.getSpecializationCertificateID();
        builder.getLengthOfPractice();
        builder.getNameOfTheTechnicalUniversity();
    }
}
