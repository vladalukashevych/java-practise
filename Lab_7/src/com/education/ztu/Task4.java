package com.education.ztu;

public class Task4 {
    public static void DoTask() {
        MyRunnable4 myRunnable = new MyRunnable4();

        Thread thread1 = new Thread(myRunnable);
        Thread thread2 = new Thread(myRunnable);
        Thread thread3 = new Thread(myRunnable);

        thread1.start();
        thread2.start();
        thread3.start();
    }
}
