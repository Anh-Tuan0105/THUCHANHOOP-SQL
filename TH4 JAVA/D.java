package Bai3;

import java.util.ArrayList;
import java.util.Scanner;
class ConNguoi {
    protected String hoten;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập họ tên: ");
        hoten = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Họ tên: " + hoten);
    }
}

class HocVien extends ConNguoi {
    private double diem1;
    private double diem2;
    private double diem3;

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập điểm 1: ");
        diem1 = sc.nextDouble();
        System.out.print("Nhập điểm 2: ");
        diem2 = sc.nextDouble();
        System.out.print("Nhập điểm 3: ");
        diem3 = sc.nextDouble();
    }

    public void xuat() {
        super.xuat();
        System.out.println("Điểm 1: " + diem1);
        System.out.println("Điểm 2: " + diem2);
        System.out.println("Điểm 3: " + diem3);
    }
}

class PhongBanKhoa {
    private String maPbk;
    private String tenPbk;

    public void nhap() {
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập mã phòng ban: ");
        maPbk = sc.nextLine();
        System.out.print("Nhập tên phòng ban: ");
        tenPbk = sc.nextLine();
    }

    public void xuat() {
        System.out.println("Mã phòng ban: " + maPbk);
        System.out.println("Tên phòng ban: " + tenPbk);
    }
}

class NhanVien extends ConNguoi {
    private double luong;
    private String ngayNhanViec;
    private PhongBanKhoa pbk;

    public NhanVien() {
        pbk = new PhongBanKhoa();
    }

    public void nhap() {
        super.nhap();
        Scanner sc = new Scanner(System.in);
        System.out.print("Nhập lương: ");
        luong = sc.nextDouble();
        System.out.print("Nhập ngày nhận việc: ");
        ngayNhanViec = sc.next();
        pbk.nhap();  // Nhập thông tin phòng ban
    }

    public void xuat() {
        super.xuat();
        System.out.println("Lương: " + luong);
        System.out.println("Ngày nhận việc: " + ngayNhanViec);
        pbk.xuat();
    }
}
public class Main {
    public static void main(String[] args) {
        Scanner doc = new Scanner(System.in);
        ArrayList<HocVien> danhSachHocVien = new ArrayList<>();
        ArrayList<NhanVien> danhSachNhanVien = new ArrayList<>();
        int chon;

        do {
            System.out.println("1: Nhập/Xuất 1 học viên");
            System.out.println("2: Nhập/Xuất 1 nhân viên");
            System.out.println("3: Nhập/Xuất danh sách học viên");
            System.out.println("4: Nhập/Xuất danh sách nhân viên");
            System.out.println("5: Thoát");
            System.out.print("Chọn chức năng: ");
            chon = doc.nextInt();

            switch (chon) {
                case 1:
                    HocVien hv = new HocVien();
                    hv.nhap();
                    hv.xuat();
                    danhSachHocVien.add(hv);
                    break;

                case 2:
                    NhanVien nv = new NhanVien();
                    nv.nhap();
                    nv.xuat();
                    danhSachNhanVien.add(nv);
                    break;

                case 3:
                    System.out.println("Danh sách học viên:");
                    if (danhSachHocVien.isEmpty()) {
                        System.out.println("Danh sách học viên trống!");
                    } else {
                        for (HocVien h : danhSachHocVien) {
                            h.xuat();
                        }
                    }
                    break;

                case 4:
                    System.out.println("Danh sách nhân viên:");
                    if (danhSachNhanVien.isEmpty()) {
                        System.out.println("Danh sách nhân viên trống!");
                    } else {
                        for (NhanVien n : danhSachNhanVien) {
                            n.xuat();
                        }
                    }
                    break;

                case 5:
                    System.out.println("Thoát chương trình.");
                    break;

                default:
                    System.out.println("Chọn chức năng không hợp lệ!");
                    break;
            }
        } while (chon != 5);
    }
}