import java.util.Scanner;

class NhanVien {
    private String maSo, hoTen;
    public static float luongCoBan;
    public static int soLuongNhanVien = 0;
    private float heSoLuong;

    public NhanVien() {
        this.maSo = null;
        this.hoTen = null;
        this.heSoLuong = 0;
        soLuongNhanVien++;
    }

    public NhanVien(String maSo, String hoTen, float heSoLuong) {
        this.maSo = maSo;
        this.hoTen = hoTen;
        this.heSoLuong = heSoLuong;
        soLuongNhanVien++;
    }

    public NhanVien(NhanVien tmp) {
        this.maSo = tmp.maSo;
        this.hoTen = tmp.hoTen;
        this.heSoLuong = tmp.heSoLuong;
        soLuongNhanVien++;
    }

    public String getMaSo() {
        return maSo;
    }

    public void setMaSo(String maSo) {
        this.maSo = maSo;
    }

    public String getHoTen() {
        return hoTen;
    }

    public void setHoTen(String hoTen) {
        this.hoTen = hoTen;
    }

    public float getHeSoLuong() {
        return heSoLuong;
    }

    public void setHeSoLuong(float heSoLuong) {
        this.heSoLuong = heSoLuong;
    }

    public float tinhLuong() {
        return luongCoBan * getHeSoLuong();
    }

    public static void inSoluongNhanVien() {
        System.out.println("So luong nhan vien: " + soLuongNhanVien);
    }

    public void input(Scanner sc) {
        System.out.print("Nhap ma so nhan vien: ");
        maSo = sc.nextLine();
        System.out.print("Nhap ho ten nhan vien: ");
        hoTen = sc.nextLine();
        System.out.print("Nhap he so luong: ");
        heSoLuong = sc.nextFloat();
        sc.nextLine();
    }

    public void output() {
        System.out
                .println(hoTen + " co ma so " + maSo + " co he so luong " + heSoLuong + " co luong la " + tinhLuong());
    }

    public String toString() {
        return hoTen + " co ma so " + maSo + " co he so luong " + heSoLuong + " co luong la " + tinhLuong();
    }

}

class DSNhanVien {
    private NhanVien[] ds;
    private int soLuong;

    public DSNhanVien(int soLuong) {
        this.soLuong = soLuong;
        ds = new NhanVien[soLuong];
    }

    public void dsInput(Scanner sc) {
        for (int i = 0; i < soLuong; i++) {
            ds[i] = new NhanVien();
            ds[i].input(sc);
        }
    }

    public void dsOutput() {
        System.out.println("Danh sach nhan vien: ");
        for (int i = 0; i < soLuong; i++) {
            ds[i].output();
        }
    }

    public int getSoLuong() {
        return soLuong;
    }

}

public class demo {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        NhanVien.luongCoBan = 1000000;
        NhanVien nv1 = new NhanVien();
        NhanVien nv2 = new NhanVien("002", "Nguyen Thanh Bao Ngan", 2.5f);
        NhanVien nv3 = new NhanVien(nv2);
        nv1.input(sc);
        nv1.output();
        nv2.output();
        nv3.setHoTen("Nguyen Hoang Huynh");
        nv3.output();
        float max = nv1.getHeSoLuong();
        NhanVien nvt = nv1;
        if (nv2.getHeSoLuong() > max) {
            max = nv2.getHeSoLuong();
            nvt = nv2;
        }
        if (nv3.getHeSoLuong() > max) {
            max = nv3.getHeSoLuong();
            nvt = nv3;
        }
        System.out.println("Nhan vien co he so luong cao nhat la: ");
        System.out.println(nvt);

        DSNhanVien ds = new DSNhanVien(3);
        ds.dsInput(sc);
        ds.dsOutput();
        NhanVien.inSoluongNhanVien();
        sc.close();
    }
}
