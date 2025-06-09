package Users;

import java.util.*;
import Action.*;
import Data.*;
import Main.*;

public class Admin extends User implements AdminAction {
    private final String Username;
    private final String Password;

    public Admin(String nama, String nim, String username, String password) {
        super(nama,nim);
        this.Username = username;
        this.Password = password;
    }

    Mahasiswa mahasiswa;
    LoginSystem loginSystem;

    @Override
    public boolean Login(String InputUsername, String InputPassword) {
        return (InputUsername.equalsIgnoreCase(Username) && InputPassword.equalsIgnoreCase(Password));
    }

    @Override
    public void DisplayInfo(){
        System.out.println("\nLogin Admin berhasil");
        System.out.println("\nNama user: " + Username);
    }

    @Override
    public void DisplayAppMenu() {
        Scanner scanner = new Scanner(System.in);

        DisplayInfo();
        int PilihanAdmin = 0;
        while (true) {

            try {
                System.out.println("\n===Menu Admin===");
                System.out.println("1. Manage item");
                System.out.println("2. Manage users");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                PilihanAdmin = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error){
                System.out.println("\nError!, Input harus berupa angka!");
            }

            if (PilihanAdmin == 1) {
                ManageItem();
            } else if (PilihanAdmin == 2) {
                ManageUser();
            } else if (PilihanAdmin == 3) {
                System.out.println("\nTerima kasih!\n");
                break;
            } else {
                System.out.println("\nPilihan tidak valid!");
            }
        }
    }

    @Override
    public void ManageItem() {
        Scanner scanner = new Scanner(System.in);

        int Pilihan;

        while (true) {
            try {
                System.out.println("\n===Menu Manage Item===");
                System.out.println("1. Lihat semua laporan");
                System.out.println("2. Tandai barang telah diambil");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                Pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error) {
                System.out.println("\nError!, Input harus berupa angka!\n");
                continue;
            }

            if (Pilihan == 1) {
                if (loginSystem.ReportedItems.isEmpty()) {
                    System.out.println("\nBelum ada laporan barang!");
                    continue;
                }

                System.out.println("\nDaftar barang yang dilaporkan:");
                for (Item item : loginSystem.ReportedItems) {
                    System.out.println("\nNama barang: " + item.getNamaItem());
                    System.out.println("Deskripsi barang: " + item.getDeskripsiItem());
                    System.out.println("Lokasi terakhir: " + item.getLokasi());
                    System.out.println("Status: " + item.getStatus());
                }

            } else if (Pilihan == 2) {
                if (loginSystem.ReportedItems.isEmpty()) {
                    System.out.println("\nBelum ada laporan barang!");
                    continue;
                }

                System.out.println("\nDaftar barang yang dilaporkan:");
                for (int i = 0; i < loginSystem.ReportedItems.size(); i++) {
                    Item item = loginSystem.ReportedItems.get(i);
                    System.out.println("\nNomor indeks: " + i);
                    System.out.println("Nama barang: " + item.getNamaItem());
                    System.out.println("Deskripsi barang: " + item.getDeskripsiItem());
                    System.out.println("Lokasi terakhir: " + item.getLokasi());
                    System.out.println("Status: " + item.getStatus());
                }

                try {
                    System.out.print("\nMasukkan indeks barang yang ingin ditandai sebagai 'Claimed': ");
                    int Indeks = Integer.parseInt(scanner.nextLine());

                    Item SelectedItem = loginSystem.ReportedItems.get(Indeks);

                    if ("Reported".equalsIgnoreCase(SelectedItem.getStatus())) {
                        loginSystem.ReportedItems.set(Indeks, new Item
                                (SelectedItem.getNamaItem(),
                                SelectedItem.getDeskripsiItem(),
                                SelectedItem.getLokasi(),
                                "Claimed"));

                        System.out.println("\nStatus barang menjadi 'Claimed'!");
                    } else {
                        System.out.println("\nBarang telah berstatus 'claimed'!");
                    }

                } catch (IndexOutOfBoundsException Error) {
                    System.out.println("\nError, Indeks tidak valid!\n");
                } catch (NumberFormatException Error) {
                    System.out.println("\nError!, Input harus berupa angka!\n");
                }
            } else if(Pilihan == 3){
                System.out.println("\nTerima kasih!");
                break;
            }
        }

    }

    @Override
    public void ManageUser() {
        Scanner scanner = new Scanner(System.in);

        int Pilihan;

        while(true) {
            try {
                System.out.println("\n===Menu Manage User===");
                System.out.println("1. Tambah Mahasiswa");
                System.out.println("2. Hapus Mahasiswa");
                System.out.println("3. Keluar");
                System.out.print("Masukkan pilihan: ");
                Pilihan = Integer.parseInt(scanner.nextLine());
            } catch (NumberFormatException Error) {
                System.out.println("\nError!, Input harus berupa angka!\n");
                continue;
            }

            if (Pilihan == 1) {
                System.out.print("\nMasukkan nama Mahasiswa: ");
                String nama = scanner.nextLine();
                System.out.print("Masukkan NIM Mahasiswa: ");
                String NIM = scanner.nextLine();

                loginSystem.UserList.add(new Mahasiswa(nama, NIM));

                System.out.println("\nMahasiswa berhasil ditambahkan!");

            } else if (Pilihan == 2) {

                boolean MHS = false;
                for(User user : loginSystem.UserList){
                    if(user instanceof Mahasiswa) {
                        MHS = true;
                    }
                }

                if(!MHS){
                    System.out.println("\nMahasiswa tidak ada!");
                    continue;
                }

                  Iterator<User> iterator = loginSystem.UserList.iterator();

                for (User user : loginSystem.UserList) {
                    if (user instanceof Mahasiswa) {
                        System.out.println("\nNama: " + user.getNama() + "\nNIM: " + user.getNIM());
                    }
                }

                System.out.print("\nMasukkan NIM Mahasiswa yang akan dihapus: ");
                String InputNIM = scanner.nextLine();

                boolean Ditemukan = false;

                while (iterator.hasNext()) {
                    User user = iterator.next();
                    if (user instanceof Mahasiswa) {
                        mahasiswa = (Mahasiswa) user;
                        if (InputNIM.equalsIgnoreCase(mahasiswa.getNIM())) {
                            Ditemukan = true;
                            System.out.println("\nMahasiswa dengan nim '" + mahasiswa.getNIM() + "' Berhasil dihapus!");
                            iterator.remove();
                            break;
                        }
                    }
                }

                if (!Ditemukan) {
                    System.out.println("\nMahasiswa dengan NIM tersebut tidak ditemukan");
                }

            } else if (Pilihan == 3) {
                System.out.println("\nTerima kasih!");
                break;
            }
        }
    }
}