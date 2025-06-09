package Praktikum.Data;

import Praktikum.Users.*;

import java.util.ArrayList;

public class DataStore {

    public static ArrayList<User> UserList = new ArrayList<>();
    public static ArrayList<Item> ReportedItems = new ArrayList<>();

    static {
        UserList.add(new Admin("CAKRABUANA", "BRIJAYAADIKARA"));
        UserList.add(new Mahasiswa("azzam", "101"));

        ReportedItems.add(new Item("Laptop", "Infinix Merah", "Lab C/D", "Reported"));
    }
}
