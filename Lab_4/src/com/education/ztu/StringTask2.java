package com.education.ztu;

public class StringTask2 {
    public static void DoTask(int num1, int num2) {
        StringBuilder additionString = new StringBuilder();
        additionString.append(num1).append(" + ").append(num2).append(" = ").append(num1 + num2);
        System.out.println(additionString);

        StringBuilder subtractionString = new StringBuilder();
        subtractionString.append(num1).append(" - ").append(num2).append(" = ").append(num1 - num2);
        System.out.println(subtractionString);

        StringBuilder multiplicationString = new StringBuilder();
        multiplicationString.append(num1).append(" * ").append(num2).append(" = ").append(num1 * num2);
        System.out.println(multiplicationString);

        // Замінити символ "=" на слово "рівно" за допомогою insert() та deleteCharAt()
        additionString.insert(additionString.indexOf("="), "рівно");
        additionString.deleteCharAt(additionString.indexOf("="));
        System.out.println(additionString);

        // Замінити символ "=" на слово "рівно" за допомогою replace()
        subtractionString.replace(subtractionString.indexOf("="), subtractionString.indexOf("=") + 1, "рівно");
        System.out.println(subtractionString);

        // Змінити послідовність розташування символів в рядку на протилежну
        multiplicationString.reverse();
        System.out.println(multiplicationString);

        // Визначити довжину та capacity
        System.out.println("Довжина рядка: " + multiplicationString.length());
        System.out.println("Capacity рядка: " + multiplicationString.capacity());
    }
}
