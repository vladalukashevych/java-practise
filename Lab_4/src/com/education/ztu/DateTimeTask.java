package com.education.ztu;

import java.time.LocalDateTime;
import java.time.Year;

public class DateTimeTask {
    public static void DoTask() {
        LocalDateTime labDateTime = LocalDateTime.of(
                2023, 11, 28, 13, 45, 36);

        System.out.println("Day of week: " + labDateTime.getDayOfWeek().toString());
        System.out.println("Day of year: " + labDateTime.getDayOfYear());
        System.out.println("Month: " + labDateTime.getMonth().toString());
        System.out.println("Year: " + labDateTime.getYear());
        System.out.println("Hour: " + labDateTime.getMinute());
        System.out.println("Minute: " + labDateTime.getSecond());

        System.out.println("Year is leap: " + Year.of(labDateTime.getYear()).isLeap());

        LocalDateTime currentDateTime = LocalDateTime.now();
        System.out.println("CurrentDateTime is after LabDateTime: " + currentDateTime.isAfter(labDateTime));
        System.out.println("CurrentDateTime is before LabDateTime: " + currentDateTime.isBefore(labDateTime));

        currentDateTime = currentDateTime.plusDays(67).minusHours(43);
        System.out.println("Changed CurrentDateTime: " + currentDateTime);
    }
}
