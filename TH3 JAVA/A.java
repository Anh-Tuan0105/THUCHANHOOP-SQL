package Bai3;

import java.util.Scanner;

public class Main {
    private int n;
    private int[] arr;

    public int getN() {
        return n;
    }

    public void setN(int n) {
        if (n >= 1 && n <= 10)
            this.n = n;
    }

    public int[] getArr() {
        return arr;
    }

    public void setArr(int[] arr) {
        if (arr.length == this.n)
            this.arr = arr;
    }

    public void inputArray(Scanner scanner) {
        int tmp;
        do {
            tmp = scanner.nextInt();
        } while (tmp < 1 || tmp > 10);
        setN(tmp);
        arr = new int[n];

        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        setArr(arr);
    }

    public void printArray() {
        for (int i = 0; i < n; i++) {
            System.out.print(arr[i]);
            if (i < n - 1) System.out.print(" ");
        }
        System.out.println();
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        for (int i = 0; i < n; i++) {
            sb.append(arr[i]);
            if (i < n - 1) {
                sb.append(" ");
            }
        }
        return sb.toString();
    }


    public void output3() {
        boolean found = false;
        for (int num : arr) {
            if (num % 3 == 0) {
                System.out.print(num + " ");
                found = true;
            }
        }
        if (!found) {
            System.out.print("");
        }
        System.out.println();
    }

    public int countDuong() {
        int count = 0;
        for (int num : arr) {
            if (num > 0) count++;
        }
        return count;
    }

    public int sumArr() {
        int sum = 0;
        for (int num : arr) {
            sum += num;
        }
        return sum;
    }

    public double averageArray() {
        return sumArr() / (double) n;
    }

    public double avgDuong() {
        int sum = 0, count = 0;
        for (int num : arr) {
            if (num > 0) {
                sum += num;
                count++;
            }
        }
        return count == 0 ? 0.0 : sum / (double) count;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main arrObj = new Main();

        arrObj.inputArray(sc);
        arrObj.output3();
        System.out.println(arrObj.countDuong());
        System.out.println(arrObj.sumArr());
        System.out.printf("%.2f\n", arrObj.averageArray());
        System.out.printf("%.2f\n", arrObj.avgDuong());

        sc.close();
    }
}
