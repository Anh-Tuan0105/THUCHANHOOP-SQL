import java.util.Scanner;

public class Cau11 {
    public static void main(String[] args) {
    Scanner scanner = new Scanner(System.in);
    System.out.print("Nhập số a: ");
    double a = scanner.nextDouble();
    System.out.print("Nhập số b: ");
    double b = scanner.nextDouble();
    System.out.print("Nhập phép toán (+, -, *, /): ");
    char operator = scanner.next().charAt(0);

    double result = 0;
    switch (operator) {
        case '+':
            result = a + b;
            break;
        case '-':
            result = a - b;
            break;
        case '*':
            result = a * b;
            break;
        case '/':
            if (b != 0) {
                result = a / b;
            } else {
                System.out.println("Không thể chia cho 0.");
                return;
            }
            break;
        default:
            System.out.println("Phép toán không hợp lệ.");
            return;
    }
    System.out.println("Kết quả: " + result);
}
}
