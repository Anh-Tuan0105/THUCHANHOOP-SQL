import java.util.Scanner;

class Fraction {
    private int ts = 0;
    private int ms = 1;

    // constructors
    public Fraction() {
        ts = 0;
        ms = 1;
    }

    public Fraction(int ts, int ms) {
        this.ts = ts;
        this.ms = ms;
    }

    // copy constructor
    public Fraction(Fraction f) {
        this.ts = f.ts;
        this.ms = f.ms;
    }

    // getter/setter cho Tu So
    public int getTuSo() {
        return this.ts;
    }

    public void setTuSo(int t) {
        this.ts = t;
    }

    // getter/setter cho Mau So
    public int getMauSo() {
        return this.ms;
    }

    public void setMauSo(int m) {
        if (m == 0) return;
        this.ms = m;
    }

    public void input(Scanner sc) {
        this.ts = sc.nextInt();
        this.ms = sc.nextInt();
        reduce();
    }

    public String toString() {
        // TODO: sua lai truong hop xuat phan so < 0
        if (this.ms == 1)
            return String.format("%d", this.ts);
        return this.ts + "/" + this.ms;
    }

    // tim USCLN
    public static int gcd(int a, int b) {
        if (b == 0) return a;
        return gcd(b, a % b);
    }

    // rut gon phan so
    public void reduce() {
        int g = gcd(ts, ms);
        ts /= g;
        ms /= g;
    }

    // cong hai phan so a, b
    public static Fraction add(Fraction a, Fraction b) {
        Fraction c = new Fraction(
            // tu so 
            a.getTuSo() * b.getMauSo() + 
            b.getTuSo() * a.getMauSo(),
            // mau so
            a.getMauSo() * b.getMauSo()
        );
        c.reduce();
        return c;
    }

    // true hai phan so a, b
    public static Fraction sub(Fraction a, Fraction b) {
        Fraction c = new Fraction(
            // tu so 
            a.getTuSo() * b.getMauSo() - 
            b.getTuSo() * a.getMauSo(),
            // mau so
            a.getMauSo() * b.getMauSo()
        );
        c.reduce();
        return c;
    }

    // nhan hai phan so a, b
    public static Fraction mul(Fraction a, Fraction b) {
        Fraction c = new Fraction(
            // tu so 
            a.getTuSo() * b.getTuSo(),
            // mau so
            a.getMauSo() * b.getMauSo()
        );
        c.reduce();
        return c;
    }

    // chia hai phan so a, b
    public static Fraction div(Fraction a, Fraction b) {
        Fraction c = new Fraction(
            // tu so 
            a.getTuSo() * b.getMauSo(),
            // mau so
            a.getMauSo() * b.getTuSo()
        );
        c.reduce();
        return c;
    }

}

public class TestFraction {
    public static void main(String[] args) {
        Fraction a = new Fraction();
        Fraction b = new Fraction();
        Scanner sc = new Scanner(System.in);

        System.out.print("Nhap phan so A: ");
        a.input(sc);
        System.out.print("Nhap phan so B: ");
        b.input(sc);


        System.out.println("Cong: " + Fraction.add(a, b));
        System.out.println("Tru : " + Fraction.sub(a, b));
        System.out.println("Nhan: " + Fraction.mul(a, b));
        System.out.println("Chia: " + Fraction.div(a, b));

        sc.close();
    }
}
