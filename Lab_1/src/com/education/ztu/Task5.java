package com.education.ztu;

import java.util.Scanner;

public class Task5 {
    public static void SumOfDigits() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть позитивне ціле число: ");
        int number = scanner.nextInt();

        if (number <= 0) {
            System.out.println("Введене число не є позитивним");
            return;
        }

        int digitSum = calculateDigitSum(number);
        System.out.println("Сума цифр числа " + number + ": " + digitSum);

        scanner.close();
    }

    private static int calculateDigitSum(int num) {
        int sum = 0;
        while (num > 0) {
            sum += num % 10;
            num /= 10;
        }
        return sum;
    }
}
