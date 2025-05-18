package apps;

import perpustakaan.*;

public class Main {
    public static void main(String[] args) {
        Anggota anggota1 = new Anggota("Azzam", "C101");
        Anggota anggota2 = new Anggota("Abdul","C010");

        Fiksi bukuFiksi = new Fiksi("Suanggi Soribo", "Khaer");
        NonFiksi bukuNonFiksi = new NonFiksi("Kekayaan Tanah Adat", "Yakomina Pete Kangkung");

        bukuFiksi.DisplayInfo();
        bukuNonFiksi.DisplayInfo();
        System.out.println(" ");

        System.out.println(anggota1.getInfo());
        System.out.println(anggota2.getInfo());
        System.out.println(" ");

        anggota1.PinjamBuku(bukuFiksi.getJudul());
        anggota2.PinjamBuku(bukuNonFiksi.getJudul());
        System.out.println(" ");

        anggota1.KembalikanBuku(bukuFiksi.getJudul(), 7);
        anggota2.KembalikanBuku(bukuNonFiksi.getJudul(), 9);
    }
}