package ru.job4j.oop.inheritance;

public class Dentist extends Doctor {
    private String typeOfDentistry;
    private String typesOfProsthetics;
    private String nameOfDentalClinic;

    public String getTypeOfDentistry() {
        return typeOfDentistry;
    }

    public String getTypesOfProsthetics() {
        return typesOfProsthetics;
    }

    public String getNameOfDentalClinic() {
        return nameOfDentalClinic;
    }
}
