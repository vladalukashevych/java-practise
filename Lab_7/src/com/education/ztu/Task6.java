package com.education.ztu;

import java.util.Scanner;

public class Task6 {
    private static final Object lock = new Object();
    private static String sharedData;
    private static boolean exit = false;

    public static void DoTask() {
        Thread readerThread = new Thread(() -> {
            while(true) {
                try {
                    readConsole();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        Thread printerThread = new Thread(() -> {
            while(true) {
                try {
                    Thread.sleep(1000);
                    printData();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        });

        readerThread.start();
        printerThread.start();
    }

    private static void readConsole() throws InterruptedException {
        synchronized (lock) {
            System.out.print("Enter data (type 'exit' to quit): ");
            Scanner scanner = new Scanner(System.in);
            sharedData = scanner.nextLine();

            if (sharedData.equalsIgnoreCase("exit")) {
                exit = true;
                lock.wait();
                return;
            }

            lock.wait();
        }
    }

    private static void printData() throws InterruptedException {
        synchronized (lock) {
            if (exit) {
                System.out.println("Exiting the program.");
                System.exit(0);
            }

            System.out.println("Received: " + sharedData);
            lock.notify();
        }
    }
}