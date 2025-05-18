import java.util.Scanner;

class Karakter {
    private String nama;
    private int kesehatan;

    public Karakter(String nama, int kesehatan) {
        this.nama = nama;
        this.kesehatan = kesehatan;
    }

    public String getNama() {
        return nama;
    }

    public int getKesehatan() {
        return kesehatan;
    }

    public void setKesehatan(int kesehatan) {
        this.kesehatan = kesehatan;
    }

    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(nama + " menyerang " + target.getNama() + " dengan " + jenisSerangan + "!");
        target.setKesehatan(target.getKesehatan() - damage);
        System.out.println("Kesehatan " + target.getNama() + " sekarang: " + target.getKesehatan() + "\n");
    }
}

class Hero extends Karakter {
    public Hero(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(getNama() + " melakukan serangan heroik " + jenisSerangan + "!");
        super.serang(target, damage, jenisSerangan);
    }
}

class Monster extends Karakter {
    public Monster(String nama, int kesehatan) {
        super(nama, kesehatan);
    }

    @Override
    public void serang(Karakter target, int damage, String jenisSerangan) {
        System.out.println(getNama() + " mengamuk dengan serangan: " + jenisSerangan + "!");
        super.serang(target, damage, jenisSerangan);
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        Hero Agus = new Hero("Agus Gurita", 1000);
        Monster Klota = new Monster("Klota Pan", 1500);

        System.out.println("Pertarungan dimulai!\n");
        System.out.println(Agus.getNama() + " vs " + Klota.getNama());

        int ronde = 1;

        while (Agus.getKesehatan() > 0 && Klota.getKesehatan() > 0) {
            System.out.println("Ronde " + ronde);
            System.out.println("Pilihan serangan " + Agus.getNama() + ":");
            System.out.println("1. Galr Kencang (250 damage)");
            System.out.println("2. Kidal Kadal (500 damage)");
            System.out.println("3. Gempa Bucuk (750 damage)");
            System.out.println("4. Cek Kesehatan");
            System.out.print("Pilih serangan: ");
            int pilihan = scanner.nextInt();

            if (pilihan == 1) {
                Agus.serang(Klota, 250, "Galr Kencang");
            } else if (pilihan == 2) {
                Agus.serang(Klota, 500, "Kidal Kadal");
            } else if (pilihan == 3) {
                Agus.serang(Klota, 750, "Gempa Bucuk");
            } else if (pilihan == 4) {
                System.out.println(Agus.getNama() + " memiliki kesehatan: " + Agus.getKesehatan());
                System.out.println(Klota.getNama() + " memiliki kesehatan: " + Klota.getKesehatan());
                continue;
            } else {
                System.out.println("Pilihan tidak valid!");
                continue;
            }

            if (Klota.getKesehatan() > 0) {
                System.out.println(Klota.getNama() + " menyerang balik!");
                Klota.serang(Agus, 200, "Slam, Slam");
            }

            ronde++;
        }

        if (Klota.getKesehatan() == 0 || Klota.getKesehatan() < 0) {
            System.out.println(Agus.getNama() + " memenangkan pertarungan!");
        } else {
            System.out.println(Klota.getNama() + " memenangkan pertarungan!");
        }

        scanner.close();
    }
}