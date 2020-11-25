package ru.job4j.oop.inheritance_Jobs;

import ru.job4j.tracker.StartUI;

public class Surgeon extends Doctor {
    private String typeOfSurgery;
    private String hospitalName;
    private String surgicalDepartmentNumber;

    public Surgeon(String typeOfSurgery, String hospitalName, String surgicalDepartmentNumber) {
        this.typeOfSurgery = typeOfSurgery;
        this.hospitalName = hospitalName;
        this.surgicalDepartmentNumber = surgicalDepartmentNumber;
    }

    public String getTypeOfSurgery() {
        return typeOfSurgery;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getSurgicalDepartmentNumber() {
        return surgicalDepartmentNumber;
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Heart surgery", "NY Hospital N3",
                "Department N18");
        surgeon.getName();
        surgeon.getSurname();
        surgeon.getBirthday();
        surgeon.getEducation();
        surgeon.getDiplomaID();
        surgeon.getLengthOfService();
        surgeon.getNameOfTheMedicalUniversity();
    }
}
