package practice;

import java.util.Scanner;

public class SimpleSieve {
    public static void simpleSieve(int limit) {

        boolean[] prime = new boolean[limit + 1];
        for (int i = 2; i <= limit; i++) {
            prime[i] = true;
        }
        for (int p = 2; p * p <= limit; p++) {
            if (prime[p]) {
                for (int i = p * p; i <= limit; i += p) {
                    prime[i] = false;
                }
            }
        }
        System.out.println("Prime nos up to" + limit + ":");
        for (int p = 2; p <= limit; p++) {
            if (prime[p]) {
                System.out.print(p + " ");
            }
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("Enter limit: ");
        int limit = scanner.nextInt();

        if (limit >= 2) {
            simpleSieve(limit);
        }
        else {
            System.err.println("Please enter number greater than 2");
        }
        scanner.close()
    }
}
