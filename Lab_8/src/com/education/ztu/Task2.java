package com.education.ztu;

public class Task2 {
    public static void DoTask(){
        Printable printable = () -> System.out.println("Printable print!");

        printable.print();
    }
}
