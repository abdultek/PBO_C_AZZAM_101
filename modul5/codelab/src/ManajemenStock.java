import java.util.ArrayList;
import java.util.InputMismatchException;
import java.util.Iterator;
import java.util.Scanner;

public class ManajemenStock {
    public static void main(String[] args) {
        ArrayList<Barang> daftarBarang = new ArrayList<>(); //objek ArrayList
        Scanner scanner = new Scanner(System.in);
        Barang barang;

        while (true) {
            System.out.println("=== Menu Manajemen Stok ===");
            System.out.println("1. Tambah Barang Baru");
            System.out.println("2. Tampilkan Semua Barang");
            System.out.println("3. Kurangi Stok Barang");
            System.out.println("0. Keluar");
            System.out.print("Pilih opsi: ");

            int pilihan;
            try {
                pilihan = scanner.nextInt();
                scanner.nextLine();
            } catch (InputMismatchException e) {
                System.out.println("Input harus berupa angka!");
                scanner.nextLine();
                continue;
            }

            if (pilihan == 1) {
                System.out.print("Masukan nama barang: ");
                String nama = scanner.nextLine();

                System.out.print("Masukan stock awal: ");
                try {
                    int stok = scanner.nextInt();
                    scanner.nextLine();
                    daftarBarang.add(new Barang(nama, stok)); // pake add(index, value) : Memasukkan value tepat sebelum index yang ditentukan, menggeser nilai sebelumnya ke sebelah kanan

                    System.out.println("Barang " + nama + " berhasil ditambahkan.\n");
                } catch (InputMismatchException e) {
                    System.out.println("Input stok harus berupa angka!");
                    scanner.nextLine();
                }

            } else if (pilihan == 2) {
                if (daftarBarang.isEmpty()) {
                    System.out.println("Stok barang kosong.");
                } else {
                    Iterator<Barang> IT = daftarBarang.iterator();
                    System.out.println("\n=== Daftar Barang ===");
                    while (IT.hasNext()) {
                        barang = IT.next();
                        System.out.println(". Nama: " + barang.getNama() + ", Stok: " + barang.getStock());
                    }
                    System.out.println(" ");
                }

            } else if (pilihan == 3) {
                if (daftarBarang.isEmpty()) {
                    System.out.println("Tidak ada barang untuk dikurangi.");
                    continue;
                }

                try {
                    for (int i = 0; i < daftarBarang.size(); i++) {
                        System.out.println((i + 1) + ". Nama: " + daftarBarang.get(i).getNama() + ", Stok: " + daftarBarang.get(i).getStock());
                    }

                    System.out.print("Pilih indeks barang (isi dengan angka): ");
                    int indeksInput = scanner.nextInt();
                    int indeks = indeksInput - 1;

                    if (indeks < 0 || indeks >= daftarBarang.size()) {
                        System.out.println("Indeks tidak valid!");
                        scanner.nextLine();
                        continue;
                    }

                    System.out.print("Jumlah yang akan dikurangi: ");
                    int jumlah = scanner.nextInt();
                    scanner.nextLine();

                    barang = daftarBarang.get(indeks);

                    try {
                        barang.kurangiStok(jumlah);
                        System.out.println("Stok berhasil dikurangi.");
                    } catch (StockTidakCukupException e) {
                        System.out.println(e.getMessage());
                    }

                } catch (InputMismatchException e) {
                    System.out.println("Input harus berupa angka!");
                    scanner.nextLine();
                }

            } else if (pilihan == 0) {
                System.out.println("Terima kasih!");
                scanner.close();
                break;

            } else {
                System.out.println("Pilihan tidak tersedia.");
            }
        }
    }
}
