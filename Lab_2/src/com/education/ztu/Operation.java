package com.education.ztu;

public class Operation {
    public static double addition(double... numbers) {
        if (numbers.length <= 1) {
            throw new IllegalArgumentException("To add you need at least 2 numbers");
        }
        double res = 0;
        for (double num : numbers) {
            res += num;
        }
        return res;
    }

    public static double subtraction(double... numbers) {
        if (numbers.length <= 1) {
            throw new IllegalArgumentException("To subtract you need at least 2 numbers");
        }
        double res = 0;
        for (double num : numbers) {
            res -= num;
        }
        return res;
    }

    public static double multiplication(double... numbers) {
        if (numbers.length <= 1) {
            throw new IllegalArgumentException("To multiply you need at least 2 numbers");
        }
        double res = 1;
        for (double num : numbers) {
            res *= num;
        }
        return res;
    }

    public static double division(double... numbers) {
        if (numbers.length <= 1) {
            throw new IllegalArgumentException("To divide you need at least 2 numbers");
        }
        double res = numbers[0];
        for (int i = 1; i < numbers.length; i++) {
            if (numbers[i] == 0) {
                throw new ArithmeticException("Division by 0 is impossible");
            }
            res /= numbers[i];
        }
        return res;
    }

    public static double average(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("To get an average you need at least 1 number");
        }
        double sum = addition(numbers);
        return division(sum, numbers.length);
    }

    public static double maximum(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("To get a maximum you need at least 1 number");
        }
        double max = numbers[0];
        for (double num : numbers) {
            if (num > max) {
                max = num;
            }
        }
        return max;
    }

    public static double minimum(double... numbers) {
        if (numbers.length == 0) {
            throw new IllegalArgumentException("To get a minimum you need at least 1 number");
        }
        double max = numbers[0];
        for (double num : numbers) {
            if (num < max) {
                max = num;
            }
        }
        return max;
    }
}
