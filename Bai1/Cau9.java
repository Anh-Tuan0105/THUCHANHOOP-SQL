import java.util.Scanner;

public class Cau9 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số km: ");
        double km = scanner.nextDouble();

        double cost = 0;
        if (km <= 1) {
            cost = 5000;
        } else if (km <= 30) {
            cost = 5000 + (km - 1) * 4000;
        } else {
            cost = 5000 + 29 * 4000 + (km - 30) * 3000;
        }

        System.out.println("Số tiền phải trả là: " + cost + "₫");
    }
}
