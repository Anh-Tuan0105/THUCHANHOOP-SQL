import java.util.Scanner;

public class Cau7 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương n: ");
        int n = scanner.nextInt();

        double sqrt = Math.sqrt(n);
        if (sqrt * sqrt == n) {
            System.out.println(n + " là số chính phương.");
        } else {
            System.out.println(n + " không phải là số chính phương.");
        }
    }
}
