// READ COMMENT FOR BETTER UNDERSTANDING OF CODE AND PRINCIPLE
// READ Theory.txt , codeViolation.java file before this for better understanding

/*
     the calculate method takes an operation string ("add" or "subtract") along with the operands
    and performs the corresponding operation. This approach follows the DRY principle by eliminating 
    duplicate code for addition and subtraction operations and using a single method to handle both operations.
*/
public class Calculator {

    public int calculate(String operation, int a, int b) {
        if (operation.equalsIgnoreCase("add")) {
            return a + b;
        } else if (operation.equalsIgnoreCase("subtract")) {
            return a - b;
        } else {
            throw new IllegalArgumentException("Invalid operation");
        }
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Addition: " + calculator.calculate("add", 5, 3));
        System.out.println("Subtraction: " + calculator.calculate("subtract", 5, 3));
    }
}
public class DryPrinciple {
    public static void main(String[] args) {
        
    }
}
