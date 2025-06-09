package modul6.java.praktikum.Users;

import modul6.java.praktikum.actions.AdminAction;
import modul6.java.praktikum.Data.Item;
import modul6.java.praktikum.Main.LoginSystem;
import java.io.PrintStream;
import java.util.Iterator;
import java.util.Scanner;

public class Admin extends User implements AdminAction {
    private final String Username;
    private final String Password;
    Mahasiswa mahasiswa;
    LoginSystem loginSystem;

    public Admin(String nama, String nim, String username, String password) {
        super(nama, nim);
        this.Username = username;
        this.Password = password;
    }
}
