package com.education.ztu.game;

import org.junit.Before;
import org.junit.Test;

import java.util.Objects;

import static org.junit.Assert.*;

public class SchoolarTest {
    private Schoolar schoolar;

    @Before
    public void setUp() {
        schoolar = new Schoolar("John", 25);
    }

    @Test
    public void testGetName() {
        assertEquals("John", schoolar.getName());
    }

    @Test
    public void testSetName() {
        schoolar.setName("Bob");
        assertNotNull(schoolar.getName());
        assertFalse(Objects.equals("John", schoolar.getName()));
        assertTrue(Objects.equals("Bob", schoolar.getName()));
    }

    @Test
    public void testGetAge() {
        assertEquals(25, schoolar.getAge());
    }

    @Test
    public void testSetAge() {
        schoolar.setAge(45);
        assertTrue(Objects.equals(45, schoolar.getAge()));
    }

    @Test
    public void testClone() {
        try {
            Schoolar clonedSchoolar = (Schoolar) schoolar.clone();
            assertEquals(schoolar, clonedSchoolar);
            assertNotSame(schoolar, clonedSchoolar);
        } catch (CloneNotSupportedException e) {
            fail("Clone should be supported.");
        }
    }

    @Test
    public void testCompareTo() {
        Participant anotherParticipant = new Schoolar("Alice", 22);
        assertTrue(schoolar.compareTo(anotherParticipant) > 0);
        assertNotSame(schoolar, anotherParticipant);
    }
}




