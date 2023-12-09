package com.education.ztu.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.ArgumentCaptor;
import org.mockito.Captor;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.junit.Assert.*;
import static org.mockito.Mockito.*;

@RunWith(MockitoJUnitRunner.class)
public class StudentTestMockito {
    @Mock
    Student studentMock;
    @Captor
    ArgumentCaptor<Integer> integerCaptor;

    @Test
    public void studentReturnName() {
        doReturn("Gigi").when(studentMock).getName();
        assertEquals("Gigi", studentMock.getName());
    }

    @Test
    public void studentSetNameAtMost2() {
        studentMock.setName("Bella");
        studentMock.setName("Lili");
        verify(studentMock, atMost(2)).setName(anyString());
    }

    @Test
    public void testCloneAtLeast2() {
        try {
            studentMock.clone();
            studentMock.clone();
            verify(studentMock, atLeast(2)).clone();

        } catch (CloneNotSupportedException e) {
            fail("Clone is not supported.");
        }
    }

    @Test
    public void testCompareTo() {
        try {
            Student studentClone = (Student) studentMock.clone();
            assertEquals(1, studentMock.compareTo(studentClone));
        } catch (CloneNotSupportedException e) {
            fail("Clone is not supported.");
        }
    }

    @Test
    public void testSetAgeRight() {
        studentMock.setAge(33);
        verify(studentMock).setAge(integerCaptor.capture());
        assertEquals(33, integerCaptor.getValue().intValue());
    }

    @Test
    public void testSetAgeNeverSetName() {
        studentMock.setAge(33);
        verify(studentMock, never()).setName(anyString());
    }
}
