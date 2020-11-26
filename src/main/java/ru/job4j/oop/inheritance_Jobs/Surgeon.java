package ru.job4j.oop.inheritance_Jobs;

import ru.job4j.tracker.StartUI;

public class Surgeon extends Doctor {
    private String typeOfSurgery;

    public Surgeon(String name, String surname, String birthday, String education,
                   String diplomaID, String typeOfSurgery) {
        super(name, surname, birthday, education, diplomaID);
        this.typeOfSurgery = typeOfSurgery;
    }

    public String getTypeOfSurgery() {
        return typeOfSurgery;
    }

    public static void main(String[] args) {
        Surgeon surgeon = new Surgeon("Bruce", "Wayne", "30.05.77",
                "higher", "Gothem 77", "Heart surgery");
        surgeon.getName();
        surgeon.getSurname();
        surgeon.getBirthday();
        surgeon.getEducation();
        surgeon.getDiplomaID();

    }
}
