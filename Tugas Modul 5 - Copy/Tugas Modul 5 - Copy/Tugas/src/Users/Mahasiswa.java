package Users;

import java.util.*;
import Data.*;
import Action.*;
import Main.LoginSystem;

public class Mahasiswa extends User implements MahasiswaAction {
    private String Nama;
    private String Nim;
    LoginSystem loginSystem;

    public Mahasiswa(String nama, String nim) {
        super(nama,nim);
        this.Nama = nama;
        this.Nim = nim;
    }


    @Override
    public boolean Login(String InputNama, String InputNim){
        return (InputNama.equalsIgnoreCase(Nama) && InputNim.equalsIgnoreCase(Nim));
    }

    @Override
    public void DisplayInfo() {
        System.out.println("\nLogin Mahasiswa berhasil!");
        System.out.println("\nNama: " + Nama);
        System.out.println("NIM: " + Nim);
    }

    @Override
    public void DisplayAppMenu() {
        Scanner scanner = new Scanner(System.in);

        DisplayInfo();

        while(true) {
            int PilihanMahasiswa = 0;
            try {
                System.out.println("\n===Menu Mahasiswa===");
                System.out.println("1. Laporan barang hilang/temuan");
                System.out.println("2. Liat laporan barang hilang");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                PilihanMahasiswa = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error) {
                System.out.println("Error!, Input harus berupa angka!");
            }

            if (PilihanMahasiswa == 1) {
                ReportItem();
            } else if (PilihanMahasiswa == 2) {
                ViewReportItem();
            } else if (PilihanMahasiswa == 3) {
                System.out.println("\nTerima kasih!\n");
                break;
            } else {
                System.out.println("\nPilihan tidak valid!");
            }
        }
    }

    @Override
    public void ReportItem() {
        Scanner scanner = new Scanner(System.in);

        System.out.print("\nNama barang: ");
        String NamaBarang = scanner.nextLine();
        System.out.print("Deskripsi barang: ");
        String DeskripsiBarang = scanner.nextLine();
        System.out.print("Lokasi terakhir: ");
        String Lokasi = scanner.nextLine();

        String Status = "Reported";

        Item item = new Item(NamaBarang, DeskripsiBarang, Lokasi, Status);

        loginSystem.ReportedItems.add(item);

        System.out.println("\nNama barang: " + NamaBarang);
        System.out.println("Deskripsi barang: " + DeskripsiBarang);
        System.out.println("Lokasi terakhir: " + Lokasi);
        System.out.println("Status: " + Status);
    }

    @Override
    public void ViewReportItem() {
        if(loginSystem.ReportedItems.isEmpty()){
            System.out.println("\nBelum ada laporan barang!\n");
            return;
        }

        System.out.println("\nDaftar barang yang dilaporkan:");
        for(Item item : loginSystem.ReportedItems) {
            if("Reported".equalsIgnoreCase(item.getStatus())){
                System.out.println("\nNama barang: " + item.getNamaItem());
                System.out.println("Deskripsi barang: " + item.getDeskripsiItem());
                System.out.println("Lokasi terakhir: " + item.getLokasi());
            }
        }
    }
}