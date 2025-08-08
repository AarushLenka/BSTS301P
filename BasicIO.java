import java.util.Scanner;

/**
 * Basic I/O and Operators
 * Demonstrates input/output operations and various operators
 */
public class BasicIO {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        
        // Basic I/O
        System.out.print("Enter your name: ");
        String name = scanner.nextLine();
        
        System.out.print("Enter your age: ");
        int age = scanner.nextInt();
        
        System.out.print("Enter a decimal number: ");
        double number = scanner.nextDouble();
        
        // Arithmetic operators
        int a = 10, b = 3;
        System.out.println("\nArithmetic Operators:");
        System.out.println("a + b = " + (a + b));
        System.out.println("a - b = " + (a - b));
        System.out.println("a * b = " + (a * b));
        System.out.println("a / b = " + (a / b));
        System.out.println("a % b = " + (a % b));
        
        // Comparison operators
        System.out.println("\nComparison Operators:");
        System.out.println("a > b: " + (a > b));
        System.out.println("a < b: " + (a < b));
        System.out.println("a == b: " + (a == b));
        System.out.println("a != b: " + (a != b));
        
        // Logical operators
        boolean x = true, y = false;
        System.out.println("\nLogical Operators:");
        System.out.println("x && y: " + (x && y));
        System.out.println("x || y: " + (x || y));
        System.out.println("!x: " + (!x));
        
        // Output user input
        System.out.println("\nUser Input:");
        System.out.println("Hello " + name + ", you are " + age + " years old.");
        System.out.println("Your number doubled is: " + (number * 2));
        
        scanner.close();
    }
}