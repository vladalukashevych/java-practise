package com.education.ztu;
import java.util.Scanner;

import java.util.Scanner;

public class Task4 {
    public static void GreatestCommonDivision() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть перше число: ");
        int num1 = Math.abs(scanner.nextInt());

        System.out.print("Введіть друге число: ");
        int num2 = Math.abs(scanner.nextInt());

        int gcd = findGCD(num1, num2);
        System.out.println("Найбільший спільний дільник чисел " + num1 + " та " + num2 + ": " + gcd);

        scanner.close();
    }

    private static int findGCD(int a, int b) {
        while (b != 0) {
            int temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }
}
