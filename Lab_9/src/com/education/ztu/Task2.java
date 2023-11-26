package com.education.ztu;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Task2 {
    public static void DoTask() {

        String text = "Співробітник1: Іванов Іван, 30 років, Менеджер, 5 років досвіду, адреса: вул. Прикладна, email: ivanov@gmail.com, телефон: +380987654321, дата народження: 20.05.1995\n" +
                "Співробітник2: Петров Петро, 25 років, Програміст, 3 роки досвіду, адреса: вул. Тестова, email: petrov@gmail.com, телефон: +380955555555, дата народження: 20.05.1995\n" +
                "Співробітник3: Сидорова Марія, 28 років, Адміністратор, 4 роки досвіду, адреса: вул. Прикладна, email: maria@mail.com, телефон: +380933333333, дата народження: 20.05.1995\n" +
                "Співробітник4: Коваленко Олена, 35 років, Фінансист, 7 років досвіду, адреса: вул. Фінансова, email: olena@gmail.com, телефон: +380988888888, дата народження: 20.05.1995\n" +
                "Співробітник5: Мельник Віталій, 32 роки, Інженер, 6 років досвіду, адреса: вул. Інженерна, email: vitaliy@mail.com, телефон: +380977777777, дата народження: 20.05.1995\n" +
                "Співробітник6: Григоренко Анна, 28 років, Маркетолог, 4 роки досвіду, адреса: вул. Маркетингова, email: anna@gmail.com, телефон: +380966666666, дата народження: 20.05.1995\n" +
                "Співробітник7: Кузьменко Сергій, 31 рік, Аналітик, 6 років досвіду, адреса: вул. Аналітична, email: sergiy@mail.com, телефон: +380955555555, дата народження: 20.05.1995\n" +
                "Співробітник8: Василенко Людмила, 29 років, HR-спеціаліст, 5 років досвіду, адреса: вул. Кадрова, email: lyudmyla@mail.com, телефон: +380944444444, дата народження: 20.05.1995";

        // Номери телефонів
        Pattern phonePattern = Pattern.compile("\\+\\d{12}");
        Matcher phoneMatcher = phonePattern.matcher(text);
        System.out.println("Номери телефонів:");
        while (phoneMatcher.find()) {
            System.out.println(phoneMatcher.group());
        }

        // Емейли
        Pattern emailPattern = Pattern.compile("\\b[\\w.%-]+@[\\w.-]+\\.[a-zA-Z]{2,4}\\b");
        Matcher emailMatcher = emailPattern.matcher(text);
        System.out.println("\nЕмейли:");
        while (emailMatcher.find()) {
            System.out.println(emailMatcher.group());
        }

        // Змінити формати відображення дат народження
        Pattern datePattern = Pattern.compile("(\\d{2})\\.(\\d{2})\\.(\\d{4})");
        Matcher dateMatcher = datePattern.matcher(text);
        StringBuffer updatedText = new StringBuffer();
        while (dateMatcher.find()) {
            String updatedDate = dateMatcher.group(3) + "-" + dateMatcher.group(2) + "-" + dateMatcher.group(1);
            dateMatcher.appendReplacement(updatedText, updatedDate);
        }
        dateMatcher.appendTail(updatedText);
        System.out.println("\nТекст з оновленими датами народження:");
        System.out.println(updatedText.toString());

        // Змінити посади кільком співробітникам
        String updatedPositions = text.replaceAll("Менеджер", "Тимчасово Менеджер").replaceAll("Програміст", "Розробник");
        System.out.println("\nТекст з оновленими посадами:");
        System.out.println(updatedPositions);
    }
}
