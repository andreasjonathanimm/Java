package pplbo_p2;

public class Persegi extends BangunDatar {
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

    @Override
    public double getLuas() {
        return sisi * sisi;
    }

    @Override
    public double getKeliling() {
        return 4 * sisi;
    }

    public void print() {
        super.print();
        System.out.println("Sisi: " + sisi);
        System.out.println();
    }
}
