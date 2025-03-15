package Bai3;

import java.util.Scanner;
import java.util.ArrayList;

class DsHangHoa {
    private ArrayList<HangHoa> danhSachHangHoa;

    public DsHangHoa() {
        danhSachHangHoa = new ArrayList<>();
    }

    public void themMH(HangHoa h) {
        danhSachHangHoa.add(h);
    }
    public void xuatDSTheoLoai(byte loai) {
        System.out.println("Danh sách mặt hàng theo loại " + (loai == 1 ? "Hàng điện máy" : "Hàng thực phẩm") + ":");
        for(HangHoa h : danhSachHangHoa)
        {
            if((loai == 1 && h instanceof HangDM) || (loai == 2 && h instanceof HangTP))
                h.outputHH();
        }
    }
}

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

class HangTP extends HangHoa {
    private String ngaySanXuat;
    private String hanSuDung;
    private String nhaCungCap;

    public HangTP() {
        super();
        ngaySanXuat = "";
        hanSuDung = "";
        nhaCungCap = "";
    }

    public HangTP(String maHang, long donGia, String tenHang, String ngaySanXuat, String nhaCungCap, String hanSuDung) {
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
        DsHangHoa dshh = new DsHangHoa();
        byte chon;

        do {
            System.out.println("1: Them mot mat hang vao danh sach");
            System.out.println("2: Xuat danh sach mat hang theo loai");
            System.out.println("0: Thoat");
            System.out.print("Chon chuc nang: ");
            chon = sc.nextByte();
            sc.nextLine();

            switch (chon) {
                case 1:
                    System.out.println("1: Hang dien may, 2: Hang thuc pham. Hay chon loai mat hang:");
                    byte loai = sc.nextByte();
                    sc.nextLine();
                    HangHoa h;
                    if (loai == 1) {
                        h = new HangDM();
                    } else {
                        h = new HangTP();
                    }
                    h.inputHH(sc);
                    dshh.themMH(h);
                    break;

                case 2:
                    System.out.println("Xuat danh sach mat hang nao (1: Hang dien may, 2: Hang thuc pham)?");
                    byte loaiMH = sc.nextByte();
                    sc.nextLine();
                    dshh.xuatDSTheoLoai(loaiMH);
                    break;

                default:
                    chon = 0;
                    break;
            }
        } while (chon != 0);

        sc.close();
    }
}
