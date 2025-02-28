import java.util.Scanner;
public class Cau4 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char c = scanner.next().charAt(0);

        if (Character.isUpperCase(c)) {
            System.out.println("CHUHOA");
        } else if (Character.isLowerCase(c)) {
            System.out.println("CHUTHUONG");
        } else if (Character.isDigit(c)) {
            if (c % 2 == 0) {
                System.out.println("SOCHAN");
            } else {
                System.out.println("SOLE");
            }
        } else {
            System.out.println("Invalid character");
        }
    }
}
