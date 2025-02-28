import java.util.Scanner;

public class Cau14 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập n: ");
        int n = scanner.nextInt();

        double sum = 0;
        double term = 1;
        for (int i = 1; i <= n; i++) {
            term *= i;  // Tính giá trị của i!
            sum += term;
        }

        System.out.println("Tổng S = " + sum);
    }
}
