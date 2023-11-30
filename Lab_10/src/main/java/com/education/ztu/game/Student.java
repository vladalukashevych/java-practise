package com.education.ztu.game;

/**
 * Represents a student participant in the game.
 * Students are a type of game participants with a name and age.
 */
public class Student  extends Participant{
    /**
     * Constructor to create a new student participant.
     * @param name The name of the student.
     * @param age The age of the student.
     */
    public Student(String name, int age) {
        super(name, age);
    }
}
