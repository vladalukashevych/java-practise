package com.education.ztu.game.ParticipantCompatators;

import com.education.ztu.game.Participant;

import java.util.Comparator;

public class ParticipantNameComparator implements Comparator<Participant> {

    public int compare(Participant p1, Participant p2){

        return p1.getName().compareTo(p2.getName());
    }
}
