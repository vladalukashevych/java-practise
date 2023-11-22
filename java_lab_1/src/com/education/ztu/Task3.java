package com.education.ztu;

public class Task3 {
    public static void main(String[] args) {
        for (String arg : args) {
            System.out.print(arg + "1 ");
        }
        if (args.length > 0) {
            System.out.println("\b"); // Видаляємо останній пробіл
        }
    }
}
