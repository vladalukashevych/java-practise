package com.education.ztu.game;

/**
 * Represents an employee participant in the game.
 * Employees are a type of game participants with a name and age.
 */
public class Employee extends Participant {
    /**
     * Constructor to create a new employee participant.
     * @param name The name of the employee.
     * @param age The age of the employee.
     */
    public Employee(String name, int age) {
        super(name, age);
    }
}
