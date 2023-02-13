package pplbo_p2;

public class Segitiga {
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

    public double getLuas() {
        return Math.round((alas * tinggi) / 2);
    }

    public double getKeliling() {
        return Math.round(alas + tinggi + Math.sqrt(Math.pow(alas, 2) + Math.pow(tinggi, 2)));
    }

    public void print() {
        System.out.println(getClass().getSimpleName());
        System.out.println("Alas: " + alas);
        System.out.println("Tinggi: " + tinggi);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
        System.out.println();
    }
}
