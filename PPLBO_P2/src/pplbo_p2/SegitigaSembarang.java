package pplbo_p2;

public class SegitigaSembarang extends Segitiga {
    public SegitigaSembarang(double alas, double tinggi) {
        super(alas, tinggi);
    }

    @Override
    public double getKeliling() {
        return alas + tinggi + Math.sqrt(Math.pow(alas, 2) + Math.pow(tinggi, 2));
    }
}
