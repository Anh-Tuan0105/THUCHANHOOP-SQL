package Bai1;

import java.util.Scanner;

public class Cau16 {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i <= Math.sqrt(n); i++) {
            if (n % i == 0) return false;
        }
        return true;
    }
    public static boolean isPerfectSquare(int n) {
        int sqrt = (int) Math.sqrt(n);
        return sqrt * sqrt == n;
    }
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số n: ");
        int n;
        do {
            System.out.print("Nhập số n (0 < n < 100): ");
            n = scanner.nextInt();
            if (n <= 0 || n >= 100) {
                System.out.println("Số nhập vào không hợp lệ. Vui lòng nhập lại.");
            }
        } while (n <= 0 || n >= 100);
        if (isPrime(n)) {
            System.out.println(n + " là số nguyên tố.");
        } else {
            System.out.println(n + " không phải là số nguyên tố.");
        }
        if (isPerfectSquare(n)) {
            System.out.println(n + " là số chính phương.");
        } else {
            System.out.println(n + " không phải là số chính phương.");
        }
    }
}
