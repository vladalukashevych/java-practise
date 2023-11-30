package com.education.ztu.game;

/**
 * Represents a schoolar participant in the game.
 * Schoolars are a type of game participants with a name and age.
 */
public class Schoolar extends Participant {
    /**
     * Constructor to create a new schoolar participant.
     * @param name The name of the schoolar.
     * @param age The age of the schoolar.
     */
    public Schoolar(String name, int age) {
        super(name, age);
    }
}

