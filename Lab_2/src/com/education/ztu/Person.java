package com.education.ztu;

import com.education.ztu.enums.Gender;
import com.education.ztu.enums.Location;

public abstract class Person implements Human {
    protected String firstname;
    protected String lastname;
    protected int age;
    protected Gender gender;
    protected Location location;

    public Person() {
        this("Unknown", "Unknown", 0, Gender.MALE, Location.ZHYTOMYR);
    }

    public Person(
            String firstname,
            String lastname,
            int age,
            Gender gender,
            Location location
    ) {
        this.firstname = firstname;
        this.lastname = lastname;
        this.age = age;
        this.gender = gender;
        this.location = location;
    }

    {
        if (firstname == null || firstname.isEmpty()) {
            firstname = "Unknown";
        }
        if (age < 0) {
            age = 0;
        }
    }

    public void sayFullName() {
        System.out.println("Fullname: " + firstname + " " + lastname);
    }

    public void sayAge() {
        System.out.println("Age: " + age);
    }

    public void sayGender() {
        System.out.println("Gender: " + gender);
    }

    public void sayLocation() {
        System.out.println("Location: " + location);
    }

    public String getFirstname() {
        return firstname;
    }

    public void setFirstname(String firstname) {
        this.firstname = firstname;
    }

    public String getLastname() {
        return firstname;
    }

    public void setLastname(String lastname) {
        this.lastname = lastname;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public Gender getGender() {
        return gender;
    }

    public void setGender(Gender gender) {
        this.gender = gender;
    }

    public Location getLocation() {
        return location;
    }

    public void setLocation(Location location) {
        this.location = location;
    }

    @Override
    public String getFullInfo() {
        return "Firstname: " + firstname + ", Lastname: " + lastname + ", Age: " + age + ", Gender: " + gender + ", Location: " + location;
    }

    public abstract String getOccupation();
}