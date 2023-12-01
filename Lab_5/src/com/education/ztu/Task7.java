package com.education.ztu;

import java.util.Arrays;
import java.util.Collections;
import java.util.List;

public class Task7 {
    public static void DoTask() {
        List<String> colorsList = Arrays.asList("Red", "Black", "White", "Blue", "Green");

        System.out.println("Initial list: \n\t" + colorsList);

        Collections.sort(colorsList);
        System.out.println("Sorted: \n\t" + colorsList);

        //to do a binary search we need the list sorted, which was previous step
        int index = Collections.binarySearch(colorsList, "Red");
        System.out.println("Binary search index of \"Red\": \n\t" + index);

        Collections.reverse(colorsList);
        System.out.println("Reversed: \n\t" + colorsList);

        Collections.shuffle(colorsList);
        System.out.println("Shuffled: \n\t" + colorsList);

        Collections.rotate(colorsList, 2);
        System.out.println("Rotate by 2: \n\t" + colorsList);

        //is based on alphabetic order in String array
        String min = Collections.min(colorsList);
        String max = Collections.max(colorsList);
        System.out.println("Minimum: \n\t" + min);
        System.out.println("Maximum: \n\t" + max);

        List<String> copiedList = Arrays.asList("1", "2", "3", "4", "5");
        System.out.println("Second list with initial values: \n\t" + copiedList);
        Collections.copy(copiedList, colorsList);
        System.out.println("Second list with copied values from initial list: \n\t" + copiedList);

        Collections.fill(colorsList, "Pink");
        System.out.println("Fill with \"Pink\": \n\t" + colorsList);

        List<String> checkedList = Collections.checkedList(colorsList, String.class);
        System.out.println("Typesafe view of list: \n\t" + checkedList);

        int frequency = Collections.frequency(colorsList, 6);
        System.out.println("Frequency of \"Pink\": \n\t" + frequency);
    }
}
