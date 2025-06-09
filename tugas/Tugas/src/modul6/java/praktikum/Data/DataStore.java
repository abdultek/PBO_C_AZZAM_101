package modul6.java.praktikum.Data;

import modul6.java.praktikum.Users.Admin;
import modul6.java.praktikum.Users.Mahasiswa;
import modul6.java.praktikum.Users.User;
import modul6.java.praktikum.Users.User;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<modul6.java.praktikum.Users.User> UserList = new ArrayList();
    public static ArrayList<Item> ReportedItems = new ArrayList();

    public DataStore() {
    }

    public static ArrayList<modul6.java.praktikum.Users.User> getItemList() {
        return UserList;
    }
    public static ArrayList<Item> getReportedItems() {
        return ReportedItems;
    }

    static {
        UserList.add(new Admin());
        UserList.add(new Mahasiswa());
    }
}
