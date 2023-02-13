package pplbo_p2;

public class PPLBO_P2 {
    public static void main(String[] args) {
        Segitiga segitiga = new Segitiga();
        segitiga.print();

        SegitigaSembarang segitigaSembarang = new SegitigaSembarang();
        segitigaSembarang.print();

        SegitigaSamaSisi segitigaSamaSisi = new SegitigaSamaSisi();
        segitigaSamaSisi.print();

        SegitigaSamaKaki segitigaSamaKaki = new SegitigaSamaKaki();
        segitigaSamaKaki.print();

        PersegiPanjang persegiPanjang = new PersegiPanjang();
        persegiPanjang.print();

        Persegi persegi = new Persegi();
        persegi.print();

        Lingkaran lingkaran = new Lingkaran();
        lingkaran.print();
    }
}
