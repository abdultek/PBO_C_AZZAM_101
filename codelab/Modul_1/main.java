package Codelab.Modul_1;
import java.util.Scanner;
import java.time.LocalDate;

class Modul1 {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);


        System.out.print("Masukkan nama: ");
        String nama = scanner.nextLine().trim();


        char jenisKelamin;
        while (true) {
            System.out.print("Masukkan jenis kelamin (P/L): ");
            jenisKelamin = scanner.next().trim().toUpperCase().charAt(0);

            if (jenisKelamin == 'P' || jenisKelamin == 'L') {
                break;
            }
            System.out.println("Input tidak valid! Harap masukkan 'P' untuk Perempuan atau 'L' untuk Laki-laki.");
        }


        int tahunLahir;
        int tahunSekarang = LocalDate.now().getYear();
        while (true) {
            System.out.print("Masukkan tahun lahir: ");
            if (scanner.hasNextInt()) {
                tahunLahir = scanner.nextInt();
                if (tahunLahir > 1900 && tahunLahir <= tahunSekarang) {
                    break;
                } else {
                    System.out.println("Tahun lahir tidak valid! Harap masukkan tahun antara 1900 dan " + tahunSekarang + ".");
                }
            } else {
                System.out.println("Harap masukkan angka yang valid!");
                scanner.next(); // Membuang input yang tidak valid
            }
        }

        scanner.close();


        int umur = tahunSekarang - tahunLahir;


        String jenisKelaminStr = (jenisKelamin == 'L') ? "Laki-laki" : "Perempuan";


        System.out.println("\n=== Data Diri ===");
        System.out.printf("Nama          : %s%n", nama);
        System.out.printf("Jenis Kelamin : %s%n", jenisKelaminStr);
        System.out.printf("Umur          : %d tahun%n", umur);
    }
}
