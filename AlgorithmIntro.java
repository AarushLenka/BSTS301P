/**
 * Introduction to Algorithms
 * Basic algorithm examples: searching, sorting, recursion
 */
public class AlgorithmIntro {
    
    // Linear Search Algorithm
    public static int linearSearch(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // Binary Search Algorithm (requires sorted array)
    public static int binarySearch(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            
            if (arr[mid] == target) {
                return mid;
            }
            if (arr[mid] < target) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return -1;
    }
    
    // Bubble Sort Algorithm
    public static void bubbleSort(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (arr[j] > arr[j + 1]) {
                    // Swap elements
                    int temp = arr[j];
                    arr[j] = arr[j + 1];
                    arr[j + 1] = temp;
                }
            }
        }
    }
    
    // Factorial using recursion
    public static long factorial(int n) {
        if (n <= 1) {
            return 1;
        }
        return n * factorial(n - 1);
    }
    
    // Fibonacci using recursion
    public static int fibonacci(int n) {
        if (n <= 1) {
            return n;
        }
        return fibonacci(n - 1) + fibonacci(n - 2);
    }
    
    public static void main(String[] args) {
        // Linear Search Example
        int[] numbers = {64, 34, 25, 12, 22, 11, 90};
        int target = 22;
        int result = linearSearch(numbers, target);
        System.out.println("Linear Search:");
        System.out.println("Target " + target + " found at index: " + result);
        
        // Bubble Sort Example
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        System.out.println("\nBubble Sort:");
        System.out.print("Before sorting: ");
        printArray(unsorted);
        bubbleSort(unsorted);
        System.out.print("After sorting: ");
        printArray(unsorted);
        
        // Binary Search Example (on sorted array)
        int binaryResult = binarySearch(unsorted, target);
        System.out.println("Binary Search on sorted array:");
        System.out.println("Target " + target + " found at index: " + binaryResult);
        
        // Recursion Examples
        System.out.println("\nRecursion Examples:");
        System.out.println("Factorial of 5: " + factorial(5));
        System.out.println("Fibonacci sequence (first 10 numbers):");
        for (int i = 0; i < 10; i++) {
            System.out.print(fibonacci(i) + " ");
        }
        System.out.println();
    }
    
    // Helper method to print array
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}