import com.education.ztu.*;
import com.education.ztu.enums.Location;

import java.util.Arrays;

public class Main2 {

    public static void main(String[] args) {
        performOperation("Addition", () -> Operation.addition(-2, 5, 0));
        performOperation("Subtraction", () -> Operation.subtraction(8, 6, -2, 4.5));
        performOperation("Multiplication", () -> Operation.multiplication(4));
        performOperation("Division", () -> Operation.division(20, 2));
        performOperation("Average", () -> Operation.average());
        performOperation("Maximum", () -> Operation.maximum(-2, 5, 0, 8.5));
        performOperation("Minimum", () -> Operation.minimum(3, 6, -3 , 5.8));

        System.out.println(Arrays.stream(Location.values()).toList());
    }


    private static void performOperation(String operationName, OperationManager operationManager) {
        try {
            System.out.println(operationName + ": " + operationManager.perform());
        } catch (ArithmeticException | IllegalArgumentException e) {
            System.out.println(e.getMessage());
        }
    }

    interface OperationManager {
        double perform();
    }
}
