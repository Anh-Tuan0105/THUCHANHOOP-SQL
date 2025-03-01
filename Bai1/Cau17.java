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
    /*public static String toBinary(int n) {
        if (n == 0) return "0";

        int[] binary = new int[32];
        int index = 0;
        while (n > 0) {
            binary[index] = n % 2;
            n = n / 2;
            index++;
        }
        String result = "";
        for (int i = index - 1; i >= 0; i--) {
            result += binary[i];
        }
        return result;
    }
    */
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số thập phân: ");
        int n = scanner.nextInt();

        System.out.println("Số nhị phân: " + toBinary(n));
    }
}
