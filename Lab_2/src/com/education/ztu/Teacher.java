package com.education.ztu;

import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public class Teacher extends Person {
    protected String subject;
    protected String university;
    protected Car car;

    public static int counter = 0;

    public Teacher(
            String subject,
            String university,
            Car car,
            String firstname,
            String lastname,
            int age,
            Gender gender,
            Location location
    ) {
        super(firstname, lastname, age, gender, location);
        this.subject = subject;
        this.university = university;
        this.car = car;
        counter++;
    }

    public Teacher(
            String subject,
            String university,
            Car car
    ) {
        super();
        this.subject = subject;
        this.university = university;
        this.car = car;
        counter++;
    }

    public static void showCounter() {
        System.out.println("Number of teachers created: " + counter);
    }

    public void TeachLesson() {
        System.out.println(firstname + " " + lastname + " is teaching " + subject + "...");
    }

    public String getSubject() {
        return subject;
    }

    public void setSubject(String subject) {
        this.subject = subject;
    }

    public String getUniversity() {
        return university;
    }

    public void setUniversity(String university) {
        this.university = university;
    }

    public Car getCar() {
        return car;
    }

    public void setCary(Car car) {
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "~ Teacher ~";
    }

    @Override
    public String getFullInfo() {
        String humanInfo = super.getFullInfo();
        return getOccupation() + " University: " + university
                + ", Subject: " + subject + ", Car: " + car.GetInfo() + ", " + humanInfo + "\n";
    }
}
