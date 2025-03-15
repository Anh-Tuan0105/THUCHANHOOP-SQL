package Bai3;

import java.util.Scanner;

class HangHoa {
    protected String maHang;
    protected String tenHang;
    protected long donGia;

    public HangHoa() {
        maHang = "";
        tenHang = "";
        donGia = 0;
    }

    public HangHoa(String maHang, long donGia, String tenHang) {
        this.maHang = maHang;
        this.donGia = donGia;
        this.tenHang = tenHang;
    }

    public void inputHH(Scanner sc) {
        System.out.print("Nhap ma hang: ");
        maHang = sc.nextLine();
        System.out.print("Nhap ten hang: ");
        tenHang = sc.nextLine();
        System.out.print("Nhap đon gia: ");
        donGia = sc.nextLong();
        sc.nextLine();  // Đọc ký tự dòng mới sau khi nhập long
    }

    public void outputHH() {
        System.out.println("Ma hang: " + maHang);
        System.out.println("Ten hang: " + tenHang);
        System.out.println("Đon gia: " + donGia);
    }
}

class HangDM extends HangHoa {
    private int thoigianbh;
    private int dienap;
    private int congsuat;

    public HangDM() {
        super();
        thoigianbh = 0;
        dienap = 0;
        congsuat = 0;
    }

    public HangDM(String maHang, long donGia, String tenHang, int congsuat, int dienap, int thoigianbh) {
        super(maHang, donGia, tenHang);
        this.congsuat = congsuat;
        this.dienap = dienap;
        this.thoigianbh = thoigianbh;
    }

    @Override
    public void inputHH(Scanner sc) {
        super.inputHH(sc);
        System.out.print("Nhap thoi gian bao hanh (thang): ");
        thoigianbh = sc.nextInt();
        System.out.print("Nhap dien ap (V): ");
        dienap = sc.nextInt();
        System.out.print("Nhap cong suat (W): ");
        congsuat = sc.nextInt();
        sc.nextLine();  // Đọc ký tự dòng mới sau khi nhập int
    }

    public void outputHH() {
        super.outputHH();
        System.out.println("Thoi gian bao hanh: " + thoigianbh + " thang");
        System.out.println("Dien ap: " + dienap + "V");
        System.out.println("Cong suat: " + congsuat + "W");
    }
}

class HANGTP extends HangHoa {
    private String ngaySanXuat;
    private String hanSuDung;
    private String nhaCungCap;

    public HANGTP() {
        super();
        ngaySanXuat = "";
        hanSuDung = "";
        nhaCungCap = "";
    }

    public HANGTP(String maHang, long donGia, String tenHang, String ngaySanXuat, String nhaCungCap, String hanSuDung) {
        super(maHang, donGia, tenHang);
        this.ngaySanXuat = ngaySanXuat;
        this.nhaCungCap = nhaCungCap;
        this.hanSuDung = hanSuDung;
    }

    @Override
    public void inputHH(Scanner sc) {
        super.inputHH(sc);
        System.out.print("Nhap ngay san xuat (dd/MM/yyyy): ");
        ngaySanXuat = sc.nextLine();
        System.out.print("Nhap han su dung (dd/MM/yyyy): ");
        hanSuDung = sc.nextLine();
        System.out.print("Nhap nha cung cap: ");
        nhaCungCap = sc.nextLine();
    }

    public void outputHH() {
        super.outputHH();
        System.out.println("Ngay san xuat: " + ngaySanXuat);
        System.out.println("Han su dung: " + hanSuDung);
        System.out.println("Nha cung cap: " + nhaCungCap);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        HangHoa h1 = new HangDM();
        System.out.println("Nhap thong tin hang dien may:");
        h1.inputHH(sc);
        System.out.println("\nThong tin hang dien may:");
        h1.outputHH();

        HangHoa h2 = new HANGTP();
        System.out.println("\nNhap thong tin hang thuc pham:");
        h2.inputHH(sc);
        System.out.println("\nThong tin hang thuc pham:");
        h2.outputHH();

        sc.close();
    }
}
