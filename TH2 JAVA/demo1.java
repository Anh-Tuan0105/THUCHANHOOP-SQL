import java.util.Scanner;

class TamGiac{
    private int a,b,c;
    public TamGiac(int a, int b, int c){
        if(a+b>c && a+c>b && b+c>a){
            this.a = a;
            this.b = b;
            this.c = c;
        }
        else{
            return;
        }
    }

    public int tinhChuVi(){
        return a+b+c;
    }
    public double tinhDienTich(){
        double p = (a+b+c)/2;
        return Math.sqrt(p*(p-a)*(p-b)*(p-c));
    }

    public void loaiTamGiac(){
        if(a==b && b==c){
            System.out.println("Tam giac deu");
        }
        else if(a==b || b==c || a==c){
            System.out.println("Tam giac can");
        }
        else if(a*a+b*b==c*c || a*a+c*c==b*b || b*b+c*c==a*a){
            System.out.println("Tam giac vuong");
        }
        else{
            System.out.println("Tam giac thuong");
        }
    }
}


public class demo1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhap 3 canh cua tam giac: ");
        int a = sc.nextInt();
        int b = sc.nextInt();   
        int c = sc.nextInt();
        TamGiac tg = new TamGiac(a, b, c);
        System.out.println("Chu vi tam giac: " + tg.tinhChuVi());
        System.out.println("Dien tich tam giac: " + tg.tinhDienTich());
        tg.loaiTamGiac();
        sc.close();
    }    
}
