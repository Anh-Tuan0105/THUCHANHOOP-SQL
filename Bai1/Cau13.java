import java.util.Scanner;

public class Cau13 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.print("Nhập số nguyên có hai chữ số: ");
        int num = scanner.nextInt();

        String[] ones = {"", "một", "hai", "ba", "bốn", "năm", "sáu", "bảy", "tám", "chín"};
        String[] tens = {"", "mười", "hai mươi", "ba mươi", "bốn mươi", "năm mươi", "sáu mươi", "bảy mươi", "tám mươi", "chín mươi"};

        int tensDigit = num / 10;
        int onesDigit = num % 10;

        String result = tens[tensDigit];
        if (tensDigit != 0 && onesDigit == 1)
            result += " mốt";
        else if(tensDigit != 0 && onesDigit == 5)
            result += " lăm";
        else if (onesDigit != 0)
            result += ones[onesDigit];

        System.out.println("Cách đọc: " + result);
    }
}
