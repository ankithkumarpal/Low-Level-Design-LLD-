/* 
    Consider a calculator that performs addition and subtraction operations. 
    Without following the DRY principle, you might write separate methods for each operation:
*/

/*
    While this code works, it violates the DRY principle because the addition and subtraction 
    operations are similar in nature. 
*/

// for code which follows DRY PRINCIPLE LOOK DryPrinciple.java file 

public class Calculator {

    public int add(int a, int b) {
        return a + b;
    }

    public int subtract(int a, int b) {
        return a - b;
    }

    public static void main(String[] args) {
        Calculator calculator = new Calculator();
        System.out.println("Addition: " + calculator.add(5, 3));
        System.out.println("Subtraction: " + calculator.subtract(5, 3));
    }
}


public class codeViolation {
    public static void main(String[] args) {
        
    }
}
