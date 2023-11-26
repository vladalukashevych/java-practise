package com.education.ztu;

public class Task2 {
    public static void DoTask() {
        MyThread myThread = new MyThread();

        System.out.println("Ім'я потоку: " + myThread.getName());
        System.out.println("Пріорітет потоку: " + myThread.getPriority());
        System.out.println("Чи потік є демоном: " + myThread.isDaemon());
        System.out.println("Чи потік є живим: " + myThread.isAlive());

        myThread.start();

        try {
            myThread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        myThread.setName("Оновлене ім'я потоку");
        myThread.setPriority(Thread.MAX_PRIORITY);

        System.out.println("Оновлене ім'я потоку: " + myThread.getName());
        System.out.println("Оновлений пріорітет потоку: " + myThread.getPriority());

        System.out.println("Ім'я головного потоку: " + Thread.currentThread().getName());
        System.out.println("Пріорітет головного потоку: " + Thread.currentThread().getPriority());

        System.out.println("Стан потоку: " + myThread.getState());
    }
}
