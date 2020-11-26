package ru.job4j.oop.inheritance_Jobs;

public class Builder extends Engineer {
    private String professionalSkillLevel;

    public Builder(String name, String surname, String birthday, String education,
                   String specializationCertificateID,
                   String professionalSkillLevel) {
        super(name, surname, birthday, education, specializationCertificateID);
        this.professionalSkillLevel = professionalSkillLevel;
    }

    public String getProfessionalSkillLevel() {
        return professionalSkillLevel;
    }

    public static void main(String[] args) {
        Builder builder = new Builder("Hulk", "Incredible", "30.05.62",
                "higher", "Marvel 5.62",
                "Super Level");
        builder.getName();
        builder.getSurname();
        builder.getBirthday();
        builder.getEducation();
        builder.getSpecializationCertificateID();
    }
}
