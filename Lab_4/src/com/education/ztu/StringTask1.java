package com.education.ztu;

public class StringTask1 {
    public static void DoTask(String inputString) {
        // Вивести останній символ рядка
        char lastChar = inputString.charAt(inputString.length() - 1);
        System.out.println("Останній символ рядка: " + lastChar);

        // Перевірити, чи закінчується рядок підрядком "!!!"
        boolean endsWithExclamation = inputString.endsWith("!!!");
        System.out.println("Рядок закінчується на '!!!': " + endsWithExclamation);

        // Перевірити, чи починається рядок підрядком "I learn "
        boolean startsWithILearn = inputString.startsWith("I learn ");
        System.out.println("Рядок починається з 'I learn ': " + startsWithILearn);

        // Перевірити, чи містить рядок підрядок "Java"
        boolean containsJava = inputString.contains("Java");
        System.out.println("Рядок містить 'Java': " + containsJava);

        // Знайти позицію підрядка "Java" у рядку
        int positionOfJava = inputString.indexOf("Java");
        System.out.println("Позиція 'Java' у рядку: " + positionOfJava);

        // Замінити всі символи 'а' на 'о'
        String replacedString = inputString.replace('a', 'o');
        System.out.println("Рядок замінено 'a' на 'o': " + replacedString);

        // Перетворити рядок на верхній регістр
        String uppercaseString = inputString.toUpperCase();
        System.out.println("Рядок у верхньому регістрі: " + uppercaseString);

        // Перетворити рядок на нижній регістр
        String lowercaseString = inputString.toLowerCase();
        System.out.println("Рядок у нижньому регістрі: " + lowercaseString);

        // Вирізати рядок "Java"
        String cutSubstring = inputString.replace("Java", "");
        System.out.println("Рядок після вирізання 'Java': " + cutSubstring);
    }
}
