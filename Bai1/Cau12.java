import java.util.Scanner;

public class Cau12 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên dương: ");
        int n = scanner.nextInt();

        int reversed = 0;
        while (n != 0) {
            reversed = reversed * 10 + n % 10;
            n /= 10;
        }

        System.out.println("Số sau khi đảo ngược là: " + reversed);
    }
}
