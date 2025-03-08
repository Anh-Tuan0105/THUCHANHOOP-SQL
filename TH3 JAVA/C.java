import java.util.Arrays;
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
    public void outputArr(int[] array) {
        for (int num : array) {
            System.out.print(num + " ");
        }
        System.out.println();
    }

    public void sortAsc()
    {
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        outputArr(tmp);
    }

    public void sortDesc()
    {
        int[] tmp = arr.clone();
        Arrays.sort(tmp);
        int left = 0, right = n - 1;
        while(left < right)
        {
            int temp = tmp[left];
            tmp[left] = tmp[right];
            tmp[right] = temp;
            left++; right--;
        }
        outputArr(tmp);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        Main oj1 = new Main();
        oj1.inputArr(sc);
        oj1.sortAsc();
        oj1.sortDesc();
        sc.close();
    }
}
