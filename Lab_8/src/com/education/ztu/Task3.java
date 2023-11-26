package com.education.ztu;

import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Task3 {
    public static void DoTask() {
        MTask1();
        MTask2();
        MTask3();
        MTask4();
    }

    private static void MTask1() {
        // Лямбда-вираз для Predicate, який повертає true, якщо рядок можна привести до числа

        Predicate<String> isConvertibleToNumber = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        System.out.println(isConvertibleToNumber.test("123.45"));
        System.out.println(isConvertibleToNumber.test("abc"));
    }

    private static void MTask2() {
        // Написати програму, яка перевіряє, що рядок можна привести до числа, використовуючи метод and() функціонального інтерфейсу Predicate.

        Predicate<String> isNotEmpty = s -> !s.isEmpty();
        Predicate<String> isConvertibleToNumber = str -> {
            try {
                Double.parseDouble(str);
                return true;
            } catch (NumberFormatException e) {
                return false;
            }
        };

        Predicate<String> isValidInput = isNotEmpty.and(isConvertibleToNumber);

        System.out.println(isValidInput.test("123.45"));
        System.out.println(isValidInput.test(""));
        System.out.println(isValidInput.test("abc"));
    }

    private static void MTask3() {
        // Написати лямбда вираз, який приймає на вхід рядок і виводить на консоль повідомлення "Пара почалася о 8:30", "Пара закінчилася о 9:50". Використовуємо функціональний інтерфейс Consumer і метод за замовчуванням andThen.


        Consumer<String> printClassSchedule = message -> System.out.println("Пара почалася о 8:30. " + message);
        Consumer<String> printClassEnd = message -> System.out.println("Пара закінчилася о 9:50. " + message);

        Consumer<String> classSchedule = printClassSchedule.andThen(printClassEnd);

        classSchedule.accept("Заняття з математики");
    }

    private static void MTask4() {
        // Написати лямбда вираз, який виводить в консоль речення в з літерами у верхньому регістрі. Використовуємо функціональний інтерфейс Supplier.

        Supplier<String> uppercaseSentenceSupplier = () -> "Це речення з великими літерами.".toUpperCase();

        System.out.println(uppercaseSentenceSupplier.get());
    }

    private static void MTask5() {
        // Написати лямбда вираз, який приймає на вхід рядок з набором чисел через пробіл та повертає добуток цих чисел. Використовуємо функціональний інтерфейс Function<String, Integer>.

        Function<String, Integer> productOfNumbers = input -> {
            String[] numbers = input.split(" ");
            return Arrays.stream(numbers)
                    .mapToInt(Integer::parseInt)
                    .reduce(1, (a, b) -> a * b);
        };

        System.out.println(productOfNumbers.apply("2 3 4"));
    }
}
