package Bai1;

import java.util.Scanner;

public class Cau20 {

    //tính giai thừa
    public long giaiThua(int n)
    {
        int gt = 1;
        for(int i = 1; i <= n; i++)
            gt *= i;
        return gt;
    }

    public long tohop(int n, int k)
    {
        return giaiThua(n) / (giaiThua(n-k)*giaiThua(k));
    }
    public static void main (String[] args)
    {
        Cau20 c20 = new Cau20();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập h: ");
        int h = sc.nextInt();
        for(int i = 0;i < h; i++) {
            {
                for (int j = 0; j < h - i; j++)
                    System.out.print(" ");
                for (int j = 0; j <= i; j++) {
                    System.out.print(c20.tohop(i, j) + " ");
                }
            }
            System.out.println();
        }
    }
}
