package com.education.ztu.game;

import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.rules.TemporaryFolder;
import org.junit.rules.TestName;

import java.io.File;
import java.io.IOException;

import static org.testng.Assert.*;

public class TeamTest {
    private Team<Schoolar> teamA;
    private Team<Schoolar> teamB;

    @Before
    public void setUp() {
        teamA = new Team<>("TeamA");
        teamB = new Team<>("TeamB");
    }

    @Test
    public void testAddNewParticipant() {
        Schoolar schoolar = new Schoolar("John", 20);
        teamA.addNewParticipant(schoolar);
        assertEquals(1, teamA.getParticipants().size());
        assertTrue(teamA.getParticipants().contains(schoolar));
    }

    @Test
    public void testPlayWith() {
        Schoolar schoolarA = new Schoolar("John", 20);
        Schoolar schoolarB = new Schoolar("Alice", 22);

        teamA.addNewParticipant(schoolarA);
        teamB.addNewParticipant(schoolarB);

        teamA.playWith(teamB);
    }

    @Test
    public void testDeepClone() {
        Schoolar schoolarA = new Schoolar("John", 20);
        teamA.addNewParticipant(schoolarA);

        Team<Schoolar> clonedTeam = Team.deepClone(teamA);

        assertNotSame(teamA, clonedTeam);
        assertEquals(teamA.getName(), clonedTeam.getName());
        assertNotSame(teamA.getParticipants(), clonedTeam.getParticipants());
        assertEquals(teamA.getParticipants(), clonedTeam.getParticipants());
    }

    @Test
    public void testEqualsAndHashCode() {
        Team<Schoolar> teamAWithSameParticipants = new Team<>("TeamA");
        Team<Schoolar> teamAWithDifferentParticipants = new Team<>("TeamA");

        Schoolar schoolarA = new Schoolar("John", 20);
        Schoolar schoolarB = new Schoolar("Alice", 22);

        teamA.addNewParticipant(schoolarA);
        teamAWithSameParticipants.addNewParticipant(schoolarA);
        teamAWithDifferentParticipants.addNewParticipant(schoolarB);

        assertEquals(teamA, teamAWithSameParticipants);
        assertNotEquals(teamA, teamAWithDifferentParticipants);
        assertEquals(teamA.hashCode(), teamAWithSameParticipants.hashCode());
        assertNotEquals(teamA.hashCode(), teamAWithDifferentParticipants.hashCode());
    }

    @Test(expected = RuntimeException.class)
    public void testGetFirstMemberInEmptyTeam() {
        Team<Student> team = new Team<>("TeamA");
        team.getParticipants().get(0);
    }

    @Rule
    public TemporaryFolder tempFolder = new TemporaryFolder();
    @Rule
    public ExpectedException thrown = ExpectedException.none();
    @Rule
    public TestName testName = new TestName();

    @Test
    public void testRules() throws IOException {
        File tempFile = tempFolder.newFile("temp.txt");

        System.out.println("Running test: " + testName.getMethodName());

        thrown.expect(RuntimeException.class);
        Team<Student> team = new Team<>("TeamA");
        team.getParticipants().get(0);
    }
}
