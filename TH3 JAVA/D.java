package Bai3;

import java.util.Scanner;

public class Main {
    private int d,c;
    private int[][] matrix;

    public int getRows() {
        return d;
    }

    public int getCols() {
        return c;
    }

    public int[][] getMatrix() {
        return matrix;
    }

    public void inputMatrix(Scanner sc) {
        int dong, cot;
        do {
            dong = sc.nextInt();
            cot = sc.nextInt();
        } while (dong <= 0 || dong > 100 || cot <= 0 || cot > 100);
        this.d = dong;
        this.c = cot;
        this.matrix = new int[d][c];
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < c; j++) {
                matrix[i][j] = sc.nextInt();
            }
        }
    }
    public int sumMatrix() {
        int sum = 0;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < c; j++) {
                sum += matrix[i][j];
            }
        }
        return sum;
    }
    public double averageMatrix() {
        return (sumMatrix() / (double) (d * c));
    }
    public double averagePositive() {
        int sum = 0, count = 0;
        for (int i = 0; i < d; i++) {
            for (int j = 0; j < c; j++) {
                if (matrix[i][j] > 0) {
                    sum += matrix[i][j];
                    count++;
                }
            }
        }
        return (count == 0) ? 0.0 : (sum / (double) count);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main oj1 = new Main();
        oj1.inputMatrix(sc);
        System.out.println(oj1.sumMatrix());
        System.out.printf("%.2f\n", oj1.averageMatrix());
        System.out.printf("%.2f\n", oj1.averagePositive());
        sc.close();
    }
}
