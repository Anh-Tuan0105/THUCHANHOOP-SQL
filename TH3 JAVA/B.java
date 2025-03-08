import java.util.Scanner;

public class Main {
    private int n;
    private int[] arr;

    public int getN() {
        return n;
    }

    public int[] getArr() {
        return arr;
    }

    public void inputArr(Scanner sc) {
        int tmp;
        do {
            tmp = sc.nextInt();
        } while (tmp <= 0 || tmp > 100);
        this.n = tmp;
        this.arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
    }

    // Hàm kiểm tra số chính phương
    public boolean isPerfectSquare(int num) {
        if (num < 0) return false;
        int sqrt = (int) Math.sqrt(num);
        return sqrt * sqrt == num;
    }

    public void outPut() {
        boolean check = false;
        for (int i = 1; i < n; i += 2) {
            if (isPerfectSquare(arr[i])) {
                System.out.print(arr[i] + " ");
                check = true;
            }
        }
        if(!check)
            System.out.println("None");
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main oj1 = new Main();
        oj1.inputArr(sc);
        oj1.outPut();
        sc.close();
    }
}
