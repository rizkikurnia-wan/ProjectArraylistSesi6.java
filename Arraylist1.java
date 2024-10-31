import java.util.Scanner;
import java.util.ArrayList;

class ArrayListNilai {
    String nama;
    double nilai;

    ArrayListNilai(String nama, double nilai) {
        this.nama = nama;
        this.nilai = nilai;
    }

    String getStatus(){
        if( nilai >= 55 ){
            return "Selamat Anda Lulus";
        } else {
            return "Maaf Anda Tidak Lulus";
        }
    }
    String getGrade(){
        if (nilai >= 85) {
            return "A";
        }else if (nilai >= 73) {
            return "B";
        }else if (nilai >= 55) {
            return "C";
        } else {
            return "D";
        }
    }
}

public class Arraylist1 {

    public static void main(String[] args) {

        Scanner scanner = new Scanner(System.in);
        System.err.print("Masukan jumlah data : ");
        int jumlahData = scanner.nextInt();
        scanner.nextLine();

        ArrayList<ArrayListNilai> nilaiMahasiswa = new ArrayList<>();
        for(int i = 0; i < jumlahData; i++) {
            System.out.println("Mahasiswa ke : " + (i + 1));
            System.out.print("Masukan nama mahasiswa : ");
            String nama  = scanner.nextLine();
            System.out.println("Masukan nilai : ");
            double nilai = scanner.nextDouble();
            scanner.nextLine();

            nilaiMahasiswa.add(new ArrayListNilai(nama, nilai));
            System.out.println("---------------------------");
        }

        System.out.println(" Data nilai mahasiswa : ");
        System.out.println("==========================================");
        System.out.printf("%-3s %-10s %-5s %-3s %-10s\n",
                        "No", "Nama", "Nilai", "Grade", "Status");
       double totalNilai = 0;
        for (int i = 0; i <nilaiMahasiswa.size(); i++){
            ArrayListNilai mhs = nilaiMahasiswa.get(i);
            System.out.printf("%-3d %-10s %-6.1f %-3s %-10s\n", (i + 1), mhs.nama, mhs.nilai, mhs.getGrade(), mhs.getStatus());
            totalNilai += mhs.nilai;
        }
        System.out.println("===========================================");
        System.out.println("Jumlah : " + totalNilai);
        double rataRata = totalNilai / jumlahData;
        System.out.println("Nilai rata-rata : " + rataRata);
        System.out.println("--------------------");
        scanner.close();
    }
}
