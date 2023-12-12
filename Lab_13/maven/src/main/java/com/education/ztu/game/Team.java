package com.education.ztu.game;

import java.util.ArrayList;
import java.util.List;
import java.util.Objects;
import java.util.Random;

public class Team<T extends Participant> implements Cloneable {
    private String name;
    private List<T> participants = new ArrayList<>();

    public Team(String name) {
        this.name = name;
    }
    public void addNewParticipant(T participant) {
        participants.add(participant);
        System.out.println("To the team " + name + " was added participant " + ((Participant) participant).getName());
    }
    public void playWith(Team<T> team) {
        if (this.participants.isEmpty() || team.participants.isEmpty()) {
            System.out.println("Cannot play with an empty team.");
            return;
        }

        if (!this.participants.get(0).getClass().equals(team.participants.get(0).getClass())) {
            System.out.println("Cannot play with a team from a different league.");
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
        System.out.println("The team " + winnerName + " is the winner!");
    }

    public String getName() {
        return name;
    }

    public List<T> getParticipants() {
        return participants;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setParticipants(List<T> participants) {
        this.participants = participants;
    }

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

    @Override
    public Object clone() throws CloneNotSupportedException {
        return super.clone();
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, participants);
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) return true;
        if (obj == null || getClass() != obj.getClass()) return false;
        Team<?> team = (Team<?>) obj;
        return Objects.equals(name, team.name) && Objects.equals(participants, team.participants);
    }

    @Override
    public String toString() {
        return "Team{" +
                "name='" + name + '\'' +
                ", participants=" + participants +
                '}';
    }
}
