package com.education.ztu.game;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.Arrays;
import java.util.Collection;

import static org.testng.Assert.*;

@RunWith(Parameterized.class)
public class EmployeeTest {

    private String name;
    private int age;

    public EmployeeTest(String name, int age) {
        this.name = name;
        this.age = age;
    }

    @Parameterized.Parameters
    public static Collection<Object[]> data() {
        return Arrays.asList(new Object[][]{{"John", 25}, {"Alice", 30}, {"Bob", 22}});
    }

    @Test
    public void testEmployeeCreation() {
        Employee employee = new Employee(name, age);
        assertEquals(name, employee.getName());
        assertEquals(age, employee.getAge());
    }
}
