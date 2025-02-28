package Bai1;

import java.awt.desktop.SystemEventListener;
import java.util.Scanner;
public class Cau19 {
    public  int[] fibo (int n)
    {
        int[] f = new int[n];
        f[0] = 1;
        f[1] = 1;
        for(int i = 2; i < n; i++)
            f[i] = f[i-1] + f[i-2];
        return f;
    }
    public static void main(String[] args) {
        Cau19 c19 = new Cau19();
        Scanner sc = new Scanner(System.in);
        System.out.println("Nhập n: ");
        int n = sc.nextInt();
        int[] fibonacci = c19.fibo(n);
        for(int x : fibonacci)
            System.out.print(x + " ");
    }
}
