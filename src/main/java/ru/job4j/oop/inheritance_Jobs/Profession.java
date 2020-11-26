package ru.job4j.oop.inheritance_Jobs;

public class Profession {

        private String name;
        private String surname;
        private String birthday;
        private String education;

        public Profession(String name, String surname, String birthday, String education) {
            this.name = name;
            this.surname = surname;
            this.birthday = birthday;
            this.education = education;
        }

        public String getName() {
            return name;
        }

        public String getSurname() {
            return surname;
        }

        public String getBirthday() {
            return birthday;
        }

        public String getEducation() {
            return education;
        }
    }
