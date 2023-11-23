package com.education.ztu;

import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public class Student extends Person {
    protected String university;
    protected String speciality;
    protected int course;

    public static int counter = 0;

    public Student(
            String university,
            String speciality,
            int course,
            String firstname,
            String lastname,
            int age,
            Gender gender,
            Location location
    ) {
        super(firstname, lastname, age, gender, location);
        this.university = university;
        this.speciality = speciality;
        this.course = course;
        counter++;
    }

    public Student(
            String university,
            String speciality,
            int course
    ) {
        super();
        this.university = university;
        this.speciality = speciality;
        this.course = course;
        counter++;
    }

    public static void showCounter() {
        System.out.println("Number of students created: " + counter);
    }

    public void Study() {
        System.out.println(firstname + " " + lastname + " is studying...");
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public String getSpeciality() {
        return speciality;
    }

    public void setSpeciality(String speciality) {
        this.speciality = speciality;
    }

    public int getCourse() { return course; }

    public void setCourse(int course) { this.course = course; }

    @Override
    public String getOccupation() {
        return "~ Student ~";
    }

    @Override
    public String getFullInfo() {
        String humanInfo = super.getFullInfo();
        return getOccupation() + " University: " + university
                + ", Speciality: " + speciality + ", Course: " + course + ", " + humanInfo + "\n";
    }
}