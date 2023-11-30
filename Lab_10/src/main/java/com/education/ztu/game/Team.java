package com.education.ztu.game;

import com.education.ztu.App;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;

import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

/**
 * Represents a team in the game.
 * A team can have participants of a specific type (e.g., Schoolar, Student, Employee).
 * @param <T> The type of participants in the team.
 */
public class Team<T extends Participant> implements Cloneable, Serializable {
    private static final long serialVersionUID = 1L;
    private static final Logger logger = LogManager.getLogger(Team.class);

    /**
     * The name of the team.
     */
    private String name;

    /**
     * A transient variable that is not included in serialization.
     */
    private transient String transientVar;

    /**
     * The list of participants in the team.
     */
    private List<T> participants = new ArrayList<>();

    /**
     * Constructs a team with a given name.
     *
     * @param name The name of the team.
     */
    public Team(String name) {
        this.name = name;
    }

    /**
     * Adds a new participant to the team.
     *
     * @param participant The participant to add.
     */
    public void addNewParticipant(T participant) {
        participants.add(participant);
        logger.info("To the team " + name + " was added participant " + ((Participant) participant).getName());
    }

    /**
     * Simulates a game between two teams.
     *
     * @param team The team to play with.
     */
    public void playWith(Team<T> team) {
        if (this.participants.isEmpty() || team.participants.isEmpty()) {
            logger.warn("Cannot play with an empty team.");
            return;
        }

        if (!this.participants.get(0).getClass().equals(team.participants.get(0).getClass())) {
            logger.warn("Cannot play with a team from a different league.");
            return;
        }

        String winnerName;
        Random random = new Random();
        int i = random.nextInt(2);
        if (i == 0) {
            winnerName = this.name;
        } else {
            winnerName = team.name;
        }
        logger.info("The team " + winnerName + " is the winner!");
    }

    /**
     * Gets the name of the team.
     *
     * @return The name of the team.
     */
    public String getName() {
        return name;
    }

    /**
     * Gets the list of participants in the team.
     *
     * @return The list of participants.
     */
    public List<T> getParticipants() {
        return participants;
    }

    /**
     * Sets the name of the team.
     *
     * @param name The new name of the team.
     */
    public void setName(String name) {
        this.name = name;
    }

    /**
     * Sets the list of participants in the team.
     *
     * @param participants The new list of participants.
     */
    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }

    /**
     * Creates a deep clone of the team.
     *
     * @param original The original team to clone.
     * @param <T>      The type of participants in the team.
     * @return A deep clone of the team.
     */
    public static <T extends Participant> Team<T> deepClone(Team<T> original) {
        Team<T> clonedTeam = new Team<>(original.name);
        List<T> clonedParticipants = new ArrayList<>();
        for (T participant : original.participants) {
            try {
                T clonedParticipant = (T) participant.clone();
                clonedParticipants.add(clonedParticipant);
            } catch (CloneNotSupportedException e) {
                e.printStackTrace();
            }
        }
        clonedTeam.setParticipants(clonedParticipants);
        return clonedTeam;
    }

    /**
     * Serializes the team to a file.
     *
     * @param fileName The name of the file to serialize to.
     */
    public void serialize(String fileName) {
        try (ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(fileName))) {
            oos.writeObject(this);
            System.out.println("Serialization successful");
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    /**
     * Deserializes a team from a file.
     *
     * @param fileName The name of the file to deserialize from.
     * @return The deserialized team.
     */
    public static Team<?> deserialize(String fileName) {
        try (ObjectInputStream ois = new ObjectInputStream(new FileInputStream(fileName))) {
            return (Team<?>) ois.readObject();
        } catch (IOException | ClassNotFoundException e) {
            e.printStackTrace();
            return null;
        }
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public int hashCode() {
        return Objects.hash(name, participants);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Team<?> team = (Team<?>) obj;
        return Objects.equals(name, team.name) && Objects.equals(participants, team.participants);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }
}
