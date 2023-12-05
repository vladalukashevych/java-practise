package com.education.ztu;

import java.util.Arrays;
import java.util.Optional;
import java.util.Random;

public class Task6 {
    private static int array_size = 10;
    public static void DoTask() {
        int[] array = new Random().ints(array_size, 0, 100).toArray();
        Optional<Integer> maxOptional = Arrays.stream(array).boxed().max(Integer::compare);
        String res = maxOptional.map(String::valueOf).orElse("Числа відсутні");
        System.out.println(res);
    }
}
