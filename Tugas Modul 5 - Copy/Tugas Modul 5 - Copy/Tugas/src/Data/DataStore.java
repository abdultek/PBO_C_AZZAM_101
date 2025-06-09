package Data;

import Users.Admin;
import Users.Mahasiswa;
import Users.User;

import java.util.ArrayList;

public class DataStore {
    public static ArrayList<User> UserList = new ArrayList<>();
    public static ArrayList<Item> ReportedItems = new ArrayList<>();

    static {
        UserList.add(new Admin("izqi", "079", "izqi15", "qi"));
        UserList.add(new Mahasiswa("izqi", "079"));

    }
    public static ArrayList<User> getItemList() {
        return UserList;
    }
    public static ArrayList<Item> getReportedItems() {
        return ReportedItems;
    }
}
