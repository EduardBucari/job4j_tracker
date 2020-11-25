package ru.job4j.oop.inheritance_Jobs;

public class Dentist extends Doctor {
    private String typeOfDentistry;
    private String typesOfProsthetics;
    private String nameOfDentalClinic;

    public Dentist(String typeOfDentistry, String typesOfProsthetics, String nameOfDentalClinic) {
        this.typeOfDentistry = typeOfDentistry;
        this.typesOfProsthetics = typesOfProsthetics;
        this.nameOfDentalClinic = nameOfDentalClinic;
    }

    public String getTypeOfDentistry() {
        return typeOfDentistry;
    }

    public String getTypesOfProsthetics() {
        return typesOfProsthetics;
    }

    public String getNameOfDentalClinic() {
        return nameOfDentalClinic;
    }

    public static void main(String[] args) {
        Dentist dentist = new Dentist("Kids dentistry", "Standard  SGP",
                "L.A. DENTAL");
        dentist.getName();
        dentist.getSurname();
        dentist.getBirthday();
        dentist.getEducation();
        dentist.getDiplomaID();
        dentist.getLengthOfService();
        dentist.getNameOfTheMedicalUniversity();
    }
}
