package com.education.ztu.game;

public class Game {
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

        scholarTeam.playWith(anotherScholarTeam);
        // scholarTeam.playWith(employeeTeam);  // This should print an error message
    }
}
