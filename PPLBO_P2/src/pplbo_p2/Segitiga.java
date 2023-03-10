package pplbo_p2;

public class Segitiga extends BangunDatar {
    protected double alas;
    protected double tinggi;

    public Segitiga() {
        alas = ((int) (Math.random() * 11)) + 1;
        tinggi = (int) (Math.random() * 11) + 1;
    }

    public Segitiga(double alas, double tinggi) {
        this.alas = alas;
        this.tinggi = tinggi;
    }

    public double getAlas() {
        return alas;
    }

    public void setAlas(double alas) {
        this.alas = alas;
    }

    public double getTinggi() {
        return tinggi;
    }

    public void setTinggi(double tinggi) {
        this.tinggi = tinggi;
    }

    @Override
    public double getLuas() {
        return Math.round((alas * tinggi) / 2);
    }

    @Override
    public double getKeliling() {
        return Math.round(alas + tinggi + Math.sqrt(Math.pow(alas, 2) + Math.pow(tinggi, 2)));
    }

    @Override
    public void print() {
        super.print();
        System.out.println("Alas: " + alas);
        System.out.println("Tinggi: " + tinggi);
        System.out.println();
    }
}
