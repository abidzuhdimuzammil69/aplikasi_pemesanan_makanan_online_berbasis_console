import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Inisialisasi daftar menu
        List<Menu> daftarMenu = new ArrayList<>();
        daftarMenu.add(new Menu("M01", "Nasi Goreng", 15000));
        daftarMenu.add(new Menu("M02", "Mie Ayam", 12000));
        daftarMenu.add(new Menu("M03", "Sate Ayam", 18000));

        System.out.println("=== Aplikasi Pemesanan Makanan ===");

        // Input data pelanggan
        System.out.print("Masukkan ID Pelanggan: ");
        String idPelanggan = scanner.nextLine();
        System.out.print("Masukkan Nama Pelanggan: ");
        String namaPelanggan = scanner.nextLine();

        Pelanggan pelanggan = new Pelanggan(idPelanggan, namaPelanggan);
        Pesanan pesanan = new Pesanan(pelanggan);

        // Proses pemesanan menu
        boolean lanjut = true;
        while (lanjut) {
            System.out.println("\n=== Daftar Menu ===");
            for (Menu menu : daftarMenu) {
                System.out.println(menu.getId() + " - " + menu.getNama() + " - Rp " + menu.getHarga());
            }

            System.out.print("\nPilih ID Menu: ");
            String pilihId = scanner.nextLine();

            Menu menuDipilih = null;
            for (Menu m : daftarMenu) {
                if (m.getId().equalsIgnoreCase(pilihId)) {
                    menuDipilih = m;
                    break;
                }
            }

            if (menuDipilih != null) {
                pesanan.tambahMenu(menuDipilih);
                System.out.println(menuDipilih.getNama() + " berhasil ditambahkan.");
            } else {
                System.out.println("ID menu tidak ditemukan.");
            }

            System.out.print("Tambah menu lagi? (y/n): ");
            String lagi = scanner.nextLine();
            if (lagi.equalsIgnoreCase("n")) {
                lanjut = false;
            }
        }

        // Cetak struk pesanan
        pesanan.cetakStruk();

        scanner.close();
    }
}

