/**
 * Special Algorithms
 * Toggle Switch, Alice Apple Tree, Binary Palindrome
 */
public class SpecialAlgorithms {
    
    // Toggle Switch Problem
    public static class ToggleSwitch {
        private boolean[] switches;
        
        public ToggleSwitch(int n) {
            switches = new boolean[n];
        }
        
        public void toggleRange(int start, int end) {
            for (int i = start; i <= end && i < switches.length; i++) {
                switches[i] = !switches[i];
            }
        }
        
        public void toggle(int index) {
            if (index >= 0 && index < switches.length) {
                switches[index] = !switches[index];
            }
        }
        
        public boolean getState(int index) {
            return index >= 0 && index < switches.length && switches[index];
        }
        
        public void printStates() {
            System.out.print("Switch states: ");
            for (boolean state : switches) {
                System.out.print((state ? "1" : "0") + " ");
            }
            System.out.println();
        }
        
        public int countOn() {
            int count = 0;
            for (boolean state : switches) {
                if (state) count++;
            }
            return count;
        }
    }
    
    // Alice Apple Tree Problem
    public static class AliceAppleTree {
        private int[] apples;
        private int alicePosition;
        
        public AliceAppleTree(int[] apples, int startPosition) {
            this.apples = apples.clone();
            this.alicePosition = startPosition;
        }
        
        // Alice can move left or right and collect apples
        public int maxApples(int moves) {
            int n = apples.length;
            int maxCollected = 0;
            
            // Try all possible combinations of left and right moves
            for (int leftMoves = 0; leftMoves <= moves; leftMoves++) {
                int rightMoves = moves - leftMoves;
                int collected = collectApples(leftMoves, rightMoves);
                maxCollected = Math.max(maxCollected, collected);
            }
            
            return maxCollected;
        }
        
        private int collectApples(int leftMoves, int rightMoves) {
            int collected = apples[alicePosition]; // Collect from starting position
            
            // Collect from left
            for (int i = 1; i <= leftMoves && alicePosition - i >= 0; i++) {
                collected += apples[alicePosition - i];
            }
            
            // Collect from right
            for (int i = 1; i <= rightMoves && alicePosition + i < apples.length; i++) {
                collected += apples[alicePosition + i];
            }
            
            return collected;
        }
        
        public void printTree() {
            System.out.print("Tree: ");
            for (int i = 0; i < apples.length; i++) {
                if (i == alicePosition) {
                    System.out.print("[" + apples[i] + "] ");
                } else {
                    System.out.print(apples[i] + " ");
                }
            }
            System.out.println();
        }
    }
    
    // Binary Palindrome Checker
    public static boolean isBinaryPalindrome(int n) {
        String binary = Integer.toBinaryString(n);
        return isPalindrome(binary);
    }
    
    private static boolean isPalindrome(String s) {
        int left = 0, right = s.length() - 1;
        while (left < right) {
            if (s.charAt(left) != s.charAt(right)) {
                return false;
            }
            left++;
            right--;
        }
        return true;
    }
    
    // Find all binary palindromes in a range
    public static void findBinaryPalindromes(int start, int end) {
        System.out.println("Binary palindromes from " + start + " to " + end + ":");
        for (int i = start; i <= end; i++) {
            if (isBinaryPalindrome(i)) {
                System.out.println(i + " -> " + Integer.toBinaryString(i));
            }
        }
    }
    
    // Count binary palindromes up to n
    public static int countBinaryPalindromes(int n) {
        int count = 0;
        for (int i = 1; i <= n; i++) {
            if (isBinaryPalindrome(i)) {
                count++;
            }
        }
        return count;
    }
    
    // Generate binary palindromes of specific bit length
    public static void generateBinaryPalindromes(int bitLength) {
        System.out.println("Binary palindromes with " + bitLength + " bits:");
        
        if (bitLength == 1) {
            System.out.println("1 -> 1");
            return;
        }
        
        int start = 1 << (bitLength - 1); // 2^(bitLength-1)
        int end = (1 << bitLength) - 1;   // 2^bitLength - 1
        
        for (int i = start; i <= end; i++) {
            if (isBinaryPalindrome(i)) {
                System.out.println(i + " -> " + Integer.toBinaryString(i));
            }
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Toggle Switch Problem ===");
        ToggleSwitch switches = new ToggleSwitch(8);
        switches.printStates();
        
        switches.toggle(2);
        switches.toggle(5);
        switches.toggleRange(1, 4);
        switches.printStates();
        System.out.println("Switches ON: " + switches.countOn());
        System.out.println();
        
        System.out.println("=== Alice Apple Tree Problem ===");
        int[] apples = {2, 3, 1, 4, 2, 5, 1};
        AliceAppleTree tree = new AliceAppleTree(apples, 3);
        tree.printTree();
        
        int moves = 3;
        int maxApples = tree.maxApples(moves);
        System.out.println("Max apples Alice can collect with " + moves + " moves: " + maxApples);
        System.out.println();
        
        System.out.println("=== Binary Palindrome ===");
        int[] testNumbers = {1, 3, 5, 7, 9, 15, 17, 21};
        for (int num : testNumbers) {
            System.out.println(num + " (" + Integer.toBinaryString(num) + ") is binary palindrome: " + 
                             isBinaryPalindrome(num));
        }
        System.out.println();
        
        findBinaryPalindromes(1, 20);
        System.out.println();
        
        System.out.println("Count of binary palindromes up to 100: " + countBinaryPalindromes(100));
        System.out.println();
        
        generateBinaryPalindromes(4);
    }
}