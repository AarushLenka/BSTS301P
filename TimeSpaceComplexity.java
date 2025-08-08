/**
 * Time & Space Complexity Examples
 * Demonstrates different complexity classes with practical examples
 */
public class TimeSpaceComplexity {
    
    // O(1) - Constant Time
    public static int constantTime(int[] arr) {
        return arr[0]; // Always takes same time regardless of input size
    }
    
    // O(n) - Linear Time
    public static int linearTime(int[] arr, int target) {
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == target) {
                return i;
            }
        }
        return -1;
    }
    
    // O(n²) - Quadratic Time
    public static void quadraticTime(int[] arr) {
        int n = arr.length;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                System.out.print(arr[i] + arr[j] + " ");
            }
        }
        System.out.println();
    }
    
    // O(log n) - Logarithmic Time
    public static int logarithmicTime(int[] arr, int target) {
        int left = 0, right = arr.length - 1;
        
        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (arr[mid] == target) return mid;
            if (arr[mid] < target) left = mid + 1;
            else right = mid - 1;
        }
        return -1;
    }
    
    // O(n log n) - Linearithmic Time (Merge Sort)
    public static void mergeSort(int[] arr, int left, int right) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            mergeSort(arr, left, mid);
            mergeSort(arr, mid + 1, right);
            merge(arr, left, mid, right);
        }
    }
    
    private static void merge(int[] arr, int left, int mid, int right) {
        int n1 = mid - left + 1;
        int n2 = right - mid;
        
        int[] leftArr = new int[n1];
        int[] rightArr = new int[n2];
        
        System.arraycopy(arr, left, leftArr, 0, n1);
        System.arraycopy(arr, mid + 1, rightArr, 0, n2);
        
        int i = 0, j = 0, k = left;
        
        while (i < n1 && j < n2) {
            if (leftArr[i] <= rightArr[j]) {
                arr[k] = leftArr[i];
                i++;
            } else {
                arr[k] = rightArr[j];
                j++;
            }
            k++;
        }
        
        while (i < n1) {
            arr[k] = leftArr[i];
            i++;
            k++;
        }
        
        while (j < n2) {
            arr[k] = rightArr[j];
            j++;
            k++;
        }
    }    

    // Space Complexity Examples
    
    // O(1) Space - Constant Space
    public static int constantSpace(int[] arr) {
        int sum = 0; // Only uses one extra variable
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }
    
    // O(n) Space - Linear Space
    public static int[] linearSpace(int[] arr) {
        int[] copy = new int[arr.length]; // Creates array of same size
        System.arraycopy(arr, 0, copy, 0, arr.length);
        return copy;
    }
    
    public static void main(String[] args) {
        int[] arr = {1, 3, 5, 7, 9, 11, 13, 15};
        int[] unsorted = {64, 34, 25, 12, 22, 11, 90};
        
        System.out.println("Time Complexity Examples:");
        System.out.println("O(1) - Constant: " + constantTime(arr));
        System.out.println("O(n) - Linear search for 7: " + linearTime(arr, 7));
        System.out.println("O(log n) - Binary search for 7: " + logarithmicTime(arr, 7));
        
        System.out.println("\nO(n²) - Quadratic (first few pairs):");
        int[] small = {1, 2, 3};
        quadraticTime(small);
        
        System.out.println("\nO(n log n) - Merge Sort:");
        System.out.print("Before: ");
        printArray(unsorted);
        mergeSort(unsorted, 0, unsorted.length - 1);
        System.out.print("After: ");
        printArray(unsorted);
        
        System.out.println("\nSpace Complexity Examples:");
        System.out.println("O(1) Space - Sum: " + constantSpace(arr));
        int[] copied = linearSpace(arr);
        System.out.print("O(n) Space - Copied array: ");
        printArray(copied);
    }
    
    public static void printArray(int[] arr) {
        for (int value : arr) {
            System.out.print(value + " ");
        }
        System.out.println();
    }
}