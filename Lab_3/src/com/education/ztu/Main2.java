package com.education.ztu;

import com.education.ztu.game.*;
import com.education.ztu.game.ParticipantCompatators.*;

import java.util.Collections;
import java.util.Comparator;

public class Main2 {
    public static void main(String[] args) {
        Team<Schoolar> schoolarTeam = new Team<>("Dragons");
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Anna", 15);
        schoolarTeam.addNewParticipant(schoolar1);
        schoolarTeam.addNewParticipant(schoolar2);

        Team<Employee> employeeTeam = new Team<>("Faeries");
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);
        Employee employee3 = new Employee("Andriy", 21);
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);
        employeeTeam.addNewParticipant(employee3);

        Comparator<Participant> comparator = new ParticipantNameComparator().thenComparing(new ParticipantAgeComparator());

        Collections.sort(schoolarTeam.getParticipants());
        employeeTeam.getParticipants().sort(comparator);

        System.out.println(schoolarTeam);
        System.out.println(employeeTeam);
    }
}
