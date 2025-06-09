package com.praktikum.data;

import com.praktikum.data.Item;
import com.praktikum.users.Mahasiswa;
import com.praktikum.users.Admin;

import java.util.ArrayList;
import java.util.List;

public class DataStore {
    public static List<Item> itemList = new ArrayList<>();
    public static List<Mahasiswa> mahasiswaList = new ArrayList<>();
    public static List<Admin> adminList = new ArrayList<>();

    static {
        // Data dummy
        mahasiswaList.add(new Mahasiswa("Fauzan", "058"));
        mahasiswaList.add(new Mahasiswa("Abi", "047"));
        adminList.add(new Admin("admin", "admin058"));
    }
}
