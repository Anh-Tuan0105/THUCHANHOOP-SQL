import java.util.Scanner;

class PhuongTrinhBacNhat{
    private int a,b;
    public PhuongTrinhBacNhat(){
        this.a = 0;
        this.b = 0;
    }
    public PhuongTrinhBacNhat(int a, int b){
        this.a = a;
        this.b = b;
    }
    public void giaiPhuongTrinh(){
        if(a==0){
            if(b==0){
                System.out.println("Phuong trinh vo so nghiem");
            }
            else{
                System.out.println("Phuong trinh vo nghiem");
            }
        }
        else{
            System.out.println("Phuong trinh co nghiem x = " + (float)-b/a);
        }
    }
}


public class demo2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap a va b: ");
        int a = sc.nextInt();
        int b = sc.nextInt();
        PhuongTrinhBacNhat pt = new PhuongTrinhBacNhat(a, b);
        pt.giaiPhuongTrinh();
        sc.close();
    }
}
