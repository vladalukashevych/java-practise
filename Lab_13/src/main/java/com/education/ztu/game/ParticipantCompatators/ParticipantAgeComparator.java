package com.education.ztu.game.ParticipantCompatators;

import com.education.ztu.game.Participant;

import java.util.Comparator;

public class ParticipantAgeComparator implements Comparator<Participant> {

    public int compare(Participant p1, Participant p2) {

        return Integer.compare(p1.getAge(), p2.getAge());
    }
}
