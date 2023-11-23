package com.education.ztu;

import com.education.ztu.game.Employee;
import com.education.ztu.game.Schoolar;
import com.education.ztu.game.Student;
import com.education.ztu.game.Team;

public class Main {

    public static void main(String[] args) {
        Team<Schoolar> scholarTeam = new Team<>("Dragon");
        Schoolar schoolar1 = new Schoolar("Ivan", 13);
        Schoolar schoolar2 = new Schoolar("Mariya", 15);
        scholarTeam.addNewParticipant(schoolar1);
        scholarTeam.addNewParticipant(schoolar2);

        Team<Student> studentTeam = new Team<>("Vpered");
        Student student1 = new Student("Mykola", 20);
        Student student2 = new Student("Viktoria", 21);
        studentTeam.addNewParticipant(student1);
        studentTeam.addNewParticipant(student2);

        Team<Employee> employeeTeam = new Team<>("Robotyagi");
        Employee employee1 = new Employee("Andriy", 28);
        Employee employee2 = new Employee("Oksana", 25);
        employeeTeam.addNewParticipant(employee1);
        employeeTeam.addNewParticipant(employee2);

        Team<Schoolar> anotherScholarTeam = new Team<>("Fantaziya");
        Schoolar schoolar3 = new Schoolar("Sergey", 12);
        Schoolar schoolar4 = new Schoolar("Olga", 14);
        anotherScholarTeam.addNewParticipant(schoolar3);
        anotherScholarTeam.addNewParticipant(schoolar4);

        try {
            Team<Schoolar> clonedScholarTeam = Team.deepClone(scholarTeam);
            scholarTeam.setName("Original team now");
            System.out.println("Original Team: " + scholarTeam);
            System.out.println("Cloned Team: " + clonedScholarTeam);
        } catch (Exception e) {
            e.printStackTrace();
        }

        System.out.println("scholarTeam.hashCode(): " + scholarTeam.hashCode());
        System.out.println("anotherScholarTeam.hashCode(): " + anotherScholarTeam.hashCode());
        System.out.println("scholarTeam.equals(anotherScholarTeam): " + scholarTeam.equals(anotherScholarTeam));
    }
}
