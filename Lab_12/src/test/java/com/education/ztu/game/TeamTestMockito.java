package com.education.ztu.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertThrows;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class TeamTestMockito {
    @Mock
    Team<Participant> teamMock;
    @Captor
    ArgumentCaptor<Participant> participantCaptor;

    @Test
    public void testAddParticipant() {
        teamMock.addNewParticipant(new Student("Vivien", 29));
        verify(teamMock).addNewParticipant(any(Participant.class));
    }

    @Test
    public void testAddParticipantsNameRight() {
        Student student = new Student("Vivien", 29);
        teamMock.addNewParticipant(student);
        verify(teamMock).addNewParticipant(participantCaptor.capture());
        assertEquals(student.getName(), participantCaptor.getValue().getName());
    }

    @Test
    public void testTeamGetName() {
        when(teamMock.getName()).thenReturn("TeamName");
        assertEquals("TeamName", teamMock.getName());
    }

    @Test
    public void testGetParticipantsNullPointerException() {
        when(teamMock.getParticipants()).thenThrow(NullPointerException.class);
        assertThrows(NullPointerException.class, () -> teamMock.getParticipants());
    }

    @Test
    public void testAddParticipant1Time() {
        Student student = new Student("Student1", 1);
        teamMock.addNewParticipant(student);
        verify(teamMock, times(1)).addNewParticipant(student);
    }

}
