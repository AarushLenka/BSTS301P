/**
 * Number Theory Algorithms
 * Euler's Totient Function, Strobogrammatic Numbers, Remainder Theorem
 */
public class NumberTheoryAlgorithms {
    
    // Euler's Totient Function (Phi function)
    public static int eulerTotient(int n) {
        int result = n;
        
        // Check for factor 2
        if (n % 2 == 0) {
            while (n % 2 == 0) {
                n /= 2;
            }
            result -= result / 2;
        }
        
        // Check for odd factors
        for (int i = 3; i * i <= n; i += 2) {
            if (n % i == 0) {
                while (n % i == 0) {
                    n /= i;
                }
                result -= result / i;
            }
        }
        
        // If n is still greater than 1, it's a prime
        if (n > 1) {
            result -= result / n;
        }
        
        return result;
    }
    
    // Check if a number is strobogrammatic
    public static boolean isStrobogrammatic(String num) {
        String validDigits = "01689";
        String rotated = "01896";
        
        int left = 0, right = num.length() - 1;
        
        while (left <= right) {
            char leftChar = num.charAt(left);
            char rightChar = num.charAt(right);
            
            // Check if digits are valid
            if (validDigits.indexOf(leftChar) == -1 || validDigits.indexOf(rightChar) == -1) {
                return false;
            }
            
            // Check if they form valid pairs when rotated
            int leftIndex = validDigits.indexOf(leftChar);
            int rightIndex = validDigits.indexOf(rightChar);
            
            if (rotated.charAt(leftIndex) != rightChar || rotated.charAt(rightIndex) != leftChar) {
                return false;
            }
            
            left++;
            right--;
        }
        
        return true;
    }
    
    // Generate all strobogrammatic numbers of length n
    public static void generateStrobogrammatic(int n) {
        System.out.println("Strobogrammatic numbers of length " + n + ":");
        generateStrobogrammaticHelper(n, n, new StringBuilder());
    }
    
    private static void generateStrobogrammaticHelper(int n, int m, StringBuilder current) {
        if (n == 0) {
            if (current.length() == m && (m == 1 || current.charAt(0) != '0')) {
                System.out.println(current.toString());
            }
            return;
        }
        
        if (n == 1) {
            current.append('0');
            generateStrobogrammaticHelper(n - 1, m, current);
            current.deleteCharAt(current.length() - 1);
            
            current.append('1');
            generateStrobogrammaticHelper(n - 1, m, current);
            current.deleteCharAt(current.length() - 1);
            
            current.append('8');
            generateStrobogrammaticHelper(n - 1, m, current);
            current.deleteCharAt(current.length() - 1);
        } else {
            // Add pairs
            String[][] pairs = {{"0", "0"}, {"1", "1"}, {"6", "9"}, {"8", "8"}, {"9", "6"}};
            
            for (String[] pair : pairs) {
                current.append(pair[0]);
                current.insert(0, pair[1]);
                generateStrobogrammaticHelper(n - 2, m, current);
                current.deleteCharAt(0);
                current.deleteCharAt(current.length() - 1);
            }
        }
    }
    
    // Chinese Remainder Theorem
    public static int chineseRemainderTheorem(int[] remainders, int[] moduli) {
        int n = remainders.length;
        int product = 1;
        
        // Calculate product of all moduli
        for (int mod : moduli) {
            product *= mod;
        }
        
        int result = 0;
        
        for (int i = 0; i < n; i++) {
            int partialProduct = product / moduli[i];
            int inverse = modularInverse(partialProduct, moduli[i]);
            result += remainders[i] * partialProduct * inverse;
        }
        
        return result % product;
    }
    
    // Extended Euclidean Algorithm for modular inverse
    private static int modularInverse(int a, int m) {
        int[] result = extendedGCD(a, m);
        if (result[0] != 1) {
            return -1; // Inverse doesn't exist
        }
        return (result[1] % m + m) % m;
    }
    
    private static int[] extendedGCD(int a, int b) {
        if (b == 0) {
            return new int[]{a, 1, 0};
        }
        
        int[] result = extendedGCD(b, a % b);
        int gcd = result[0];
        int x1 = result[1];
        int y1 = result[2];
        
        int x = y1;
        int y = x1 - (a / b) * y1;
        
        return new int[]{gcd, x, y};
    }
    
    public static void main(String[] args) {
        System.out.println("=== Euler's Totient Function ===");
        for (int i = 1; i <= 12; i++) {
            System.out.println("φ(" + i + ") = " + eulerTotient(i));
        }
        System.out.println();
        
        System.out.println("=== Strobogrammatic Numbers ===");
        String[] testNumbers = {"69", "88", "818", "1001", "96"};
        for (String num : testNumbers) {
            System.out.println(num + " is strobogrammatic: " + isStrobogrammatic(num));
        }
        System.out.println();
        
        generateStrobogrammatic(3);
        System.out.println();
        
        System.out.println("=== Chinese Remainder Theorem ===");
        int[] remainders = {2, 3, 2};
        int[] moduli = {3, 5, 7};
        int result = chineseRemainderTheorem(remainders, moduli);
        System.out.println("System of congruences:");
        for (int i = 0; i < remainders.length; i++) {
            System.out.println("x ≡ " + remainders[i] + " (mod " + moduli[i] + ")");
        }
        System.out.println("Solution: x = " + result);
    }
}