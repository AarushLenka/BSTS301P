/**
 * Decision Making and Control Structures
 * Demonstrates if-else, switch, loops, and control flow
 */
public class ControlStructures {
    public static void main(String[] args) {
        // If-else statements
        int score = 85;
        System.out.println("If-Else Example:");
        if (score >= 90) {
            System.out.println("Grade: A");
        } else if (score >= 80) {
            System.out.println("Grade: B");
        } else if (score >= 70) {
            System.out.println("Grade: C");
        } else {
            System.out.println("Grade: F");
        }
        
        // Switch statement
        int day = 3;
        String dayName;
        System.out.println("\nSwitch Example:");
        switch (day) {
            case 1: dayName = "Monday"; break;
            case 2: dayName = "Tuesday"; break;
            case 3: dayName = "Wednesday"; break;
            case 4: dayName = "Thursday"; break;
            case 5: dayName = "Friday"; break;
            case 6: dayName = "Saturday"; break;
            case 7: dayName = "Sunday"; break;
            default: dayName = "Invalid day";
        }
        System.out.println("Day " + day + " is " + dayName);
        
        // For loop
        System.out.println("\nFor Loop Example:");
        for (int i = 1; i <= 5; i++) {
            System.out.println("Count: " + i);
        }
        
        // While loop
        System.out.println("\nWhile Loop Example:");
        int count = 1;
        while (count <= 3) {
            System.out.println("While count: " + count);
            count++;
        }
        
        // Do-while loop
        System.out.println("\nDo-While Loop Example:");
        int num = 1;
        do {
            System.out.println("Do-while num: " + num);
            num++;
        } while (num <= 2);
        
        // Enhanced for loop (for-each)
        System.out.println("\nEnhanced For Loop Example:");
        int[] numbers = {10, 20, 30, 40, 50};
        for (int number : numbers) {
            System.out.println("Number: " + number);
        }
    }
}