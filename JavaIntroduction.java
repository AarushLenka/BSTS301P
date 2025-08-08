/**
 * Java Introduction - Features, Structure, Data Types
 * Demonstrates basic Java syntax, data types, and structure
 */
public class JavaIntroduction {
    public static void main(String[] args) {
        // Basic data types
        int integer = 42;
        double decimal = 3.14159;
        char character = 'A';
        boolean flag = true;
        String text = "Hello, Java!";
        
        // Arrays
        int[] numbers = {1, 2, 3, 4, 5};
        String[] words = {"Java", "is", "awesome"};
        
        // Output
        System.out.println("Integer: " + integer);
        System.out.println("Double: " + decimal);
        System.out.println("Character: " + character);
        System.out.println("Boolean: " + flag);
        System.out.println("String: " + text);
        
        // Array demonstration
        System.out.print("Numbers: ");
        for (int num : numbers) {
            System.out.print(num + " ");
        }
        System.out.println();
        
        System.out.print("Words: ");
        for (String word : words) {
            System.out.print(word + " ");
        }
        System.out.println();
    }
}