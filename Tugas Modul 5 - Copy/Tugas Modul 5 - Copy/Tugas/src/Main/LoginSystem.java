// File: Main/LoginSystem.java
package Main;

import Users.*;
import Data.*;
import java.util.ArrayList;

public class LoginSystem {
    public static ArrayList<User> UserList = new ArrayList<>();
    public static ArrayList<Item> ReportedItems = new ArrayList<>();

    static {
        // Tambahkan user dummy
        UserList.add(new Admin("Admin Satu", "0001", "admin", "admin123"));
        UserList.add(new Mahasiswa("Budi", "12345"));
    }

    public static User authenticate(String input1, String input2) {
        for (User user : UserList) {
            if (user.Login(input1, input2)) {
                return user;
            }
        }
        return null;
    }
}
