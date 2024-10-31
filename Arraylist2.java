import java.util.ArrayList;
import java.util.Scanner;

public class Arraylist2 {
    public static void main(String[] args) {
        // Daftar buah dengan harga menggunakan ArrayList
        ArrayList<String[]> buah = new ArrayList<>();
        buah.add(new String[]{"apel", "50000"});
        buah.add(new String[]{"jeruk", "35000"});
        buah.add(new String[]{"mangga", "35000"});
        buah.add(new String[]{"duku", "15000"});
        buah.add(new String[]{"semangka", "20000"});
        buah.add(new String[]{"lemon", "30000"});
        buah.add(new String[]{"rambutan", "15000"});
        buah.add(new String[]{"alpukat", "50000"});
        buah.add(new String[]{"kelengkeng", "20000"});
        buah.add(new String[]{"jambu jamaika", "25000"});
        buah.add(new String[]{"manggis", "27500"});

        // ArrayList untuk menyimpan belanjaan
        ArrayList<String[]> keranjang = new ArrayList<>();
        Scanner scanner = new Scanner(System.in);
        int pilihan;

        System.out.println("Menu:");
        while (true) {
            System.out.println("1. Beli Buah");
            System.out.println("2. Struk Belanja");
            System.out.println("3. Keluar");
            System.out.print("Masukkan pilihan: ");
            pilihan = scanner.nextInt();

            if (pilihan == 1) {
                System.out.println("Daftar Buah:");
                for (int i = 0; i < buah.size(); i++) {
                    System.out.printf("%d. %s - %s\n", i, buah.get(i)[0], buah.get(i)[1]);
                }

                System.out.print("Pilih Buah (0-" + (buah.size() - 1) + "): ");
                int indexBuah = scanner.nextInt();

                if (indexBuah >= 0 && indexBuah < buah.size()) {
                    System.out.print("Masukkan jumlah: ");
                    int jumlah = scanner.nextInt();
                    int harga = Integer.parseInt(buah.get(indexBuah)[1]);
                    int subtotal = harga * jumlah;

                    // Menyimpan item ke keranjang
                    keranjang.add(new String[] {
                        buah.get(indexBuah)[0], // Nama buah
                        String.valueOf(jumlah), // Jumlah
                        String.valueOf(harga), // Harga satuan
                        String.valueOf(subtotal) // Subtotal
                    });

                    System.out.print("Input lagi? (y/n): ");
                    char lanjut = scanner.next().charAt(0);
                    if (lanjut == 'n' || lanjut == 'N') {
                        // Kembali ke menu utama setelah selesai belanja
                        continue;
                    }
                } else {
                    System.out.println("Buah tidak valid!");
                }
            } else if (pilihan == 2) {
                tampilkanStruk(keranjang);
            } else if (pilihan == 3) {
                break; // Keluar dari loop
            } else {
                System.out.println("Pilihan tidak valid!");
            }
        }

        scanner.close();
        System.out.println("Terima kasih sudah berbelanja!");
    }

    private static void tampilkanStruk(ArrayList<String[]> keranjang) {
        System.out.println("Daftar Belanja:");
        System.out.println("=================================");
        System.out.printf("%-3s %-10s %-7s %-10s %-10s\n", "No.", "Nama Buah", "Jumlah", "Harga", "Subtotal");

        int total = 0;
        for (int i = 0; i < keranjang.size(); i++) {
            String[] item = keranjang.get(i);
            int subtotal = Integer.parseInt(item[3]);
            total += subtotal;

            System.out.printf("%-3d %-10s %-7s %-10s %-10s\n", (i + 1), item[0], item[1], item[2], item[3]);
        }

        int discount = (int) (total * 0.15);
        int totalBayar = total - discount;

        System.out.println("=================================");
        System.out.println("Total: " + total);
        System.out.println("Discount (15%): " + discount);
        System.out.println("Total bayar: " + totalBayar);
    }
}
