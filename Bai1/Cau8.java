import java.util.Scanner;

public class Cau8 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập tháng: ");
        int month = scanner.nextInt();

        if (month < 1 || month > 12) {
            System.out.println("This month is invalid.");
        } else {
            int days = 0;
            if (month == 2) {
                System.out.print("Nhập năm: ");
                int year = scanner.nextInt();
                if (year % 400 == 0 || (year % 4 == 0 && year % 100 != 0)) {
                    days = 29;
                } else {
                    days = 28;
                }
            } else if (month == 1 || month == 3 || month == 5 || month == 7 || month == 8 || month == 10 || month == 12) {
                days = 31;
            } else {
                days = 30;
            }
            System.out.println("Số ngày của tháng " + month + " là: " + days);
        }
    }
}
