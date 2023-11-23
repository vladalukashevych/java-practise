package com.education.ztu;

import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public class Employee extends Person {
    protected String company;
    protected String position;
    protected Car car;

    public static int counter = 0;

    public Employee(
            String company,
            String position,
            Car car,
            String firstname,
            String lastname,
            int age,
            Gender gender,
            Location location
    ) {
        super(firstname, lastname, age, gender, location);
        this.company = company;
        this.position = position;
        this.car = car;
        counter++;
    }

    public Employee(
            String company,
            String position,
            Car car
    ) {
        super();
        this.company = company;
        this.position = position;
        this.car = car;
        counter++;
    }

    public static void showCounter() {
        System.out.println("Number of employees created: " + counter);
    }

    public void Work() {
        System.out.println(firstname + " " + lastname + " is working...");
    }

    public String getCompany() {
        return company;
    }

    public void setCompany(String company) {
        this.company = company;
    }

    public String getPosition() {
        return position;
    }

    public void setPosition(String position) {
        this.position = position;
    }

    public Car getCar() {
        return car;
    }

    public void setCary(Car car) {
        this.car = car;
    }

    @Override
    public String getOccupation() {
        return "~ Employee ~";
    }

    @Override
    public String getFullInfo() {
        String humanInfo = super.getFullInfo();
        return getOccupation() + " Company: " + company
                + ", Position: " + position + ", Car: " + car.GetInfo() + ", " + humanInfo + "\n";
    }
}
