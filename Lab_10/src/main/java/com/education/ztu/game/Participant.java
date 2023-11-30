package com.education.ztu.game;

import java.io.Serializable;
import java.util.Objects;

/**
 * Represents a participant in the game.
 * This is an abstract class that provides common properties and methods for all participants.
 */
public abstract class Participant implements Cloneable, Comparable<Participant>, Serializable {
    /**
     * The name of the participant.
     */
    private String name;

    /**
     * The age of the participant.
     */
    private int age;

    /**
     * Constructs a participant with the specified name and age.
     *
     * @param name The name of the participant.
     * @param age  The age of the participant.
     */
    public Participant(String name, int age) {
        this.name = name;
        this.age = age;
    }

    /**
     * Constructs a participant with an empty name and age 0.
     */
    public Participant() {
        this.name = "";
        this.age = 0;
    }

    /**
     * Gets the name of the participant.
     *
     * @return The name of the participant.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the age of the participant.
     *
     * @return The age of the participant.
     */
    public int getAge() {
        return age;
    }

    /**
     * Sets the name of the participant.
     *
     * @param name The new name of the participant.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the age of the participant.
     *
     * @param age The new age of the participant.
     */
    public void setAge(int age) {
        this.age = age;
    }

    /**
     * Creates and returns a copy of this participant.
     *
     * @return A clone of this participant.
     * @throws CloneNotSupportedException If cloning is not supported for this object.
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * Compares this participant with another participant based on their names.
     *
     * @param p The participant to compare with.
     * @return A negative integer, zero, or a positive integer as this participant is less than, equal to, or greater than the specified participant.
     */
    @Override
    public int compareTo(Participant p) {
        return name.compareTo(p.getName());
    }

    /**
     * Indicates whether some other object is equal to this participant.
     *
     * @param obj The reference object with which to compare.
     * @return true if this participant is the same as the obj argument; false otherwise.
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Participant that = (Participant) obj;
        return age == that.age && Objects.equals(name, that.name);
    }

    /**
     * Returns a string representation of the participant.
     *
     * @return A string representation of the participant.
     */
    @Override
    public String toString() {
        return getClass().getSimpleName() + "{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
