package com.education.ztu;
import java.util.Scanner;

public class Task6 {
    public static void FibonacciArray() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Введіть кількість елементів масиву: ");
        int n = scanner.nextInt();

        int[] fibArray = generateFibonacciArray(n);

        System.out.println("Масив зростаючою послідовністю Фібоначчі:");
        printArray(fibArray);

        int[] reverseFibArray = generateReverseFibonacciArray(n);

        System.out.println("Масив зворотною послідовністю Фібоначчі:");
        printArray(reverseFibArray);

        scanner.close();
    }

    private static int[] generateFibonacciArray(int n) {
        int[] fibArray = new int[n];
        fibArray[0] = 1;
        fibArray[1] = 1;
        for (int i = 2; i < n; i++) {
            fibArray[i] = fibArray[i - 1] + fibArray[i - 2];
        }
        return fibArray;
    }

    private static int[] generateReverseFibonacciArray(int n) {
        int[] reverseFibArray = new int[n];
        int[] fibArray = generateFibonacciArray(n);
        for (int i = 0; i < n; i++) {
            reverseFibArray[i] = fibArray[n - i - 1];
        }
        return reverseFibArray;
    }

    private static void printArray(int[] array) {
        for (int element : array) {
            System.out.print(element + " ");
        }
        System.out.println();
    }
}
