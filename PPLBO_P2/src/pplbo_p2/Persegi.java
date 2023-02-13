package pplbo_p2;

public class Persegi {
    private double sisi;

    public Persegi(double sisi) {
        this.sisi = sisi;
    }

    public Persegi() {
        sisi = ((int) (Math.random() * 11)) + 1;
    }

    public double getSisi() {
        return sisi;
    }

    public void setSisi(double sisi) {
        this.sisi = sisi;
    }

    public double getLuas() {
        return sisi * sisi;
    }

    public double getKeliling() {
        return 4 * sisi;
    }

    public void print() {
        System.out.println("Persegi");
        System.out.println("Sisi: " + sisi);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
        System.out.println();
    }
}
