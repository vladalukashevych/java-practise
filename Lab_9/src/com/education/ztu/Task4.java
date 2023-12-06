package com.education.ztu;

import java.lang.reflect.Method;
import java.util.Arrays;

public class Task4 {
    public static void DoTask() {
        try {
            Method method = Task4.class.getDeclaredMethod("printCompliment");
            if (method.isAnnotationPresent(MyAnnotation.class)) {

                for (int i = 0; i < method.getAnnotation(MyAnnotation.class).times(); i++) {
                    printCompliment();
                }

                System.out.println(Arrays.stream(method.getDeclaredAnnotations()).toList());
            }

        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }

    }

    @MyAnnotation(times = 3)
    private static void printCompliment() {
        System.out.println("You're beautiful!");
    }
}
