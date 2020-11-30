package ru.job4j.pojo;

public class College {
    public static void main(String[] args) {
        Student student = new Student();
        student.setNameSurname("Eduard Bucari");
        student.setGroupNumber("MG-945");
        student.setEnterInstituteDate("september 1994.");

        System.out.println(student.getNameSurname() + " was study in group: " +
                student.getGroupNumber() + ", the Enter of Institute Date is " +
                student.getEnterInstituteDate());
    }
}
