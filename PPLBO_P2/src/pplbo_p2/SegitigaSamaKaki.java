package pplbo_p2;

public class SegitigaSamaKaki extends Segitiga {
    public SegitigaSamaKaki(double alas, double tinggi) {
        super(alas, tinggi);
    }

    public SegitigaSamaKaki() {
        super();
    }

    @Override
    public double getKeliling() {
        return Math.round(alas + 2 * Math.sqrt(Math.pow(alas / 2, 2) + Math.pow(tinggi, 2)));
    }
}
