package com.education.ztu;

import java.util.Arrays;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.TimeUnit;

public class Task7 {
    private static final int thread_size = 5;

    public static void DoTask() {
        int[] array = new Random().ints(1000000, 0, 10).toArray();

        measureAndPrintTime(() -> {
            getSumSingleThread(array);
        });

        measureAndPrintTime(() -> {
            getSumMultiThread(array);
        });
    }

    private static void measureAndPrintTime(Runnable task) {
        long startTime = System.currentTimeMillis();
        task.run();
        long endTime = System.currentTimeMillis();
        System.out.println("Execution time: " + (endTime - startTime) + " milliseconds");
    }

    private static void getSumSingleThread(int[] array) {
        int res = Arrays.stream(array).map(Task7::getDigitSum).sum();
        System.out.println("Single-threaded sum: " + res);
    }

    private static void getSumMultiThread(int[] array) {
        ExecutorService executorService = Executors.newFixedThreadPool(thread_size);
        executorService.execute(() -> {
            int res = Arrays.stream(array).map(Task7::getDigitSum).sum();
            System.out.println("Multi-threaded sum: " + res);
        });

        executorService.shutdown();

        try {
            executorService.awaitTermination(Long.MAX_VALUE, TimeUnit.NANOSECONDS);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    private static int getDigitSum(int number) {
        int sum = 0;
        while (number != 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }
}
