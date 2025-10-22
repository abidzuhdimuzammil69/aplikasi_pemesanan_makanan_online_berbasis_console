import java.util.ArrayList;
import java.util.List;

public class Pesanan {
    private Pelanggan pelanggan;
    private List<Menu> daftarPesanan;

    public Pesanan(Pelanggan pelanggan) {
        this.pelanggan = pelanggan;
        this.daftarPesanan = new ArrayList<>();
    }

    public void tambahMenu(Menu menu) {
        daftarPesanan.add(menu);
    }

    public void cetakStruk() {
        System.out.println("\n=== Struk Pesanan ===");
        System.out.println("Pelanggan: " + pelanggan.getNama());
        System.out.println("\n=== Daftar Pesanan ===");

        double total = 0;
        for (Menu m : daftarPesanan) {
            System.out.println("- " + m.getNama() + " : Rp " + m.getHarga());
            total += m.getHarga();
        }

        System.out.println("Total Harga: Rp " + total);
        System.out.println("\nTerima kasih telah memesan!");
    }
}
