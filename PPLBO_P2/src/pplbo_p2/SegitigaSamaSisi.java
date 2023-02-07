package pplbo_p2;

public class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(double alas, double tinggi) {
        super(alas, tinggi);
    }

    @Override
    public double getKeliling() {
        return 3 * alas;
    }
}
