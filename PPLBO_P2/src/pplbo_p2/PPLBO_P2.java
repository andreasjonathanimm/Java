package pplbo_p2;

public class PPLBO_P2 {
    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga(3, 4);
        segitiga.setAlas(6);
        segitiga.setTinggi(8);
        segitiga.print();

        PersegiPanjang persegiPanjang = new PersegiPanjang(3, 4);
        persegiPanjang.setPanjang(6);
        persegiPanjang.setLebar(8);
        persegiPanjang.print();

        Persegi persegi = new Persegi(3);
        persegi.setSisi(6);
        persegi.print();

        Lingkaran lingkaran = new Lingkaran(3);
        lingkaran.setJariJari(6);
        lingkaran.print();
    }
}
