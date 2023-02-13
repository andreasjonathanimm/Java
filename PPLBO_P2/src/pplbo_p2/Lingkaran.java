package pplbo_p2;

public class Lingkaran {
    private double jariJari;

    public Lingkaran(double jariJari) {
        this.jariJari = jariJari;
    }

    public Lingkaran() {
        jariJari = ((int) (Math.random() * 11)) + 1;
    }

    public double getJariJari() {
        return jariJari;
    }

    public void setJariJari(double jariJari) {
        this.jariJari = jariJari;
    }

    public double getLuas() {
        return Math.round(Math.PI * jariJari * jariJari);
    }

    public double getKeliling() {
        return Math.round(2 * Math.PI * jariJari);
    }

    public void print() {
        System.out.println("Lingkaran");
        System.out.println("Jari-jari: " + jariJari);
        System.out.println("Luas: " + getLuas());
        System.out.println("Keliling: " + getKeliling());
        System.out.println();
    }
}
