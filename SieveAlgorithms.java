/**
 * Sieve Algorithms
 * Simple Sieve, Segmented Sieve, and Incremental Sieve implementations
 */
public class SieveAlgorithms {
    
    // Simple Sieve of Eratosthenes
    public static boolean[] simpleSieve(int n) {
        boolean[] isPrime = new boolean[n + 1];
        
        // Initialize all numbers as prime
        for (int i = 2; i <= n; i++) {
            isPrime[i] = true;
        }
        
        // Sieve process
        for (int p = 2; p * p <= n; p++) {
            if (isPrime[p]) {
                // Mark all multiples of p as not prime
                for (int i = p * p; i <= n; i += p) {
                    isPrime[i] = false;
                }
            }
        }
        
        return isPrime;
    }
    
    // Segmented Sieve - finds primes in range [low, high]
    public static void segmentedSieve(int low, int high) {
        // Find all primes up to sqrt(high)
        int limit = (int) Math.sqrt(high) + 1;
        boolean[] simplePrimes = simpleSieve(limit);
        
        // Create array for segment
        boolean[] isPrime = new boolean[high - low + 1];
        for (int i = 0; i < isPrime.length; i++) {
            isPrime[i] = true;
        }
        
        // Use simple primes to mark composites in segment
        for (int p = 2; p <= limit; p++) {
            if (simplePrimes[p]) {
                // Find minimum number in [low, high] that is multiple of p
                int start = Math.max(p * p, (low + p - 1) / p * p);
                
                // Mark multiples of p in segment
                for (int j = start; j <= high; j += p) {
                    isPrime[j - low] = false;
                }
            }
        }
        
        // Print primes in segment
        System.out.println("Primes in range [" + low + ", " + high + "]:");
        for (int i = low; i <= high; i++) {
            if (i >= 2 && isPrime[i - low]) {
                System.out.print(i + " ");
            }
        }
        System.out.println();
    }
    
    // Incremental Sieve - generates primes one by one
    public static class IncrementalSieve {
        private int current;
        private boolean[] sieve;
        private int limit;
        
        public IncrementalSieve(int maxLimit) {
            this.limit = maxLimit;
            this.sieve = new boolean[limit + 1];
            this.current = 2;
            
            // Initialize sieve
            for (int i = 2; i <= limit; i++) {
                sieve[i] = true;
            }
        }
        
        public int nextPrime() {
            while (current <= limit) {
                if (sieve[current]) {
                    int prime = current;
                    
                    // Mark multiples as composite
                    for (int i = prime * prime; i <= limit; i += prime) {
                        sieve[i] = false;
                    }
                    
                    current++;
                    return prime;
                }
                current++;
            }
            return -1; // No more primes
        }
        
        public boolean hasNext() {
            while (current <= limit && !sieve[current]) {
                current++;
            }
            return current <= limit;
        }
    }
    
    public static void main(String[] args) {
        System.out.println("=== Simple Sieve of Eratosthenes ===");
        int n = 30;
        boolean[] primes = simpleSieve(n);
        System.out.println("Primes up to " + n + ":");
        for (int i = 2; i <= n; i++) {
            if (primes[i]) {
                System.out.print(i + " ");
            }
        }
        System.out.println("\n");
        
        System.out.println("=== Segmented Sieve ===");
        segmentedSieve(50, 100);
        System.out.println();
        
        System.out.println("=== Incremental Sieve ===");
        IncrementalSieve incSieve = new IncrementalSieve(50);
        System.out.println("First 10 primes using incremental sieve:");
        int count = 0;
        while (incSieve.hasNext() && count < 10) {
            System.out.print(incSieve.nextPrime() + " ");
            count++;
        }
        System.out.println();
    }
}