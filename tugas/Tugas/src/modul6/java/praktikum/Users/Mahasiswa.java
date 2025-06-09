package modul6.java.praktikum.Users;

import actions.MahasiswaAction;
import Data.Item;
import Main.LoginSystem;
import modul6.java.praktikum.Main.LoginSystem;
import modul6.java.praktikum.actions.MahasiswaAction;

import java.util.Scanner;

public class Mahasiswa extends User implements MahasiswaAction {
    private String Nama;
    private String Nim;
    LoginSystem loginSystem;

    public class Mahasiswa(String nama, String nim) {
        super(nama, nim);
        this.Nama = nama;
        this.Nim = nim;
    }

    public boolean Login(String InputNama, String InputNim) {
        return InputNama.equalsIgnoreCase(this,Nama) && InputNim.equalsIgnoreCase(this.Nim)
    }

    public void DisplayInfo() {
        System.out.println("\nLogin Mahasiswa berhasil!");
        System.out.println("\nNama: " + this.Nama);
        System.out.println("Nim: " + this.Nim);
    }
}
