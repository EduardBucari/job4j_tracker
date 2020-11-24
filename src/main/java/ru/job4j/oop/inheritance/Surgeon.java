package ru.job4j.oop.inheritance;

public class Surgeon extends Doctor {
    private String typeOfSurgery;
    private String hospitalName;
    private String surgicalDepartmentNumber;

    public String getTypeOfSurgery() {
        return typeOfSurgery;
    }

    public String getHospitalName() {
        return hospitalName;
    }

    public String getSurgicalDepartmentNumber() {
        return surgicalDepartmentNumber;
    }
}
