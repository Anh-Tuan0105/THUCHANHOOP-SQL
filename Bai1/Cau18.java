package Bai1;

import java.util.Scanner;

public class Cau18 {
    public static boolean isLeapYear(int year) {
        return (year % 400 == 0) || (year % 4 == 0 && year % 100 != 0);
    }

    public static boolean isValidDate(int day, int month, int year) {
        if (month < 1 || month > 12) return false;

        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysInMonth[1] = 29;  // Tháng 2 trong năm nhuận

        return day >= 1 && day <= daysInMonth[month - 1];
    }

    public static void nextDay(int day, int month, int year) {
        // Mảng số ngày trong tháng, xét năm nhuận cho tháng 2
        int[] daysInMonth = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
        if (isLeapYear(year)) daysInMonth[1] = 29;  // Tháng 2 trong năm nhuận

        day++;  // Tăng ngày lên 1
        if (day > daysInMonth[month - 1]) {  // Nếu ngày vượt quá số ngày trong tháng
            day = 1;  // Quay lại ngày đầu tiên của tháng mới
            month++;  // Tăng tháng lên 1
            if (month > 12) {  // Nếu tháng vượt quá 12, chuyển sang năm mới
                month = 1;
                year++;  // Tăng năm lên 1
            }
        }

        System.out.println("Ngày kế tiếp là: " + day + "/" + month + "/" + year);
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập ngày: ");
        int day = scanner.nextInt();
        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();
        System.out.print("Nhập năm: ");
        int year = scanner.nextInt();

        if (isValidDate(day, month, year)) {
            nextDay(day, month, year);  // In ra ngày kế tiếp
        } else {
            System.out.println("Ngày tháng năm không hợp lệ.");
        }
    }
}
