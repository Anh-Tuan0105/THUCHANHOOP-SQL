package Bai1;

import java.util.Scanner;

public class Cau17 {
    public static String toBinary(int n) {
        StringBuilder binary = new StringBuilder();
        while (n > 0) {
            binary.insert(0, n % 2);
            n = n / 2;
        }
        return binary.toString();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thập phân: ");
        int n = scanner.nextInt();

        System.out.println("Số nhị phân: " + toBinary(n));
    }
}
