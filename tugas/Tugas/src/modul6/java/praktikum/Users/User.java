package modul6.java.praktikum.Users;

public abstract class User {
    private String Nama;
    private String Nim;

    public User(String nama, String nim) {
        this.Nama = nama;
        this.Nim = nim;
    }

    public abstract boolean Login(String var1, String var2);

    public abstract void DisplayInfo();

    public abstract void DisplayAppMenu();

    public String getNama() {
        return this.Nama;
    }
    public String getNim() {
        return this.Nim;
    }
}
