package pplbo_p2;

public class SegitigaSamaSisi extends Segitiga {
    public SegitigaSamaSisi(double alas, double tinggi) {
        super(alas, tinggi);
    }

    public SegitigaSamaSisi() {
        super();
    }

    @Override
    public double getKeliling() {
        return 3 * alas;
    }
}
