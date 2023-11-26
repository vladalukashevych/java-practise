package com.education.ztu;

class MyRunnable3 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i <= 10000; i += 10) {
            if (Thread.interrupted()) {
                System.out.println("Розрахунок завершено!!!");
                return;
            }
            System.out.println(i);
        }
    }
}
