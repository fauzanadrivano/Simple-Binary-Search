import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);

        String[][] nama = {
                {"Alex", "Aqin", "Aril", "Bella"},
                {"Caca", "Dinda", "Dwi", "Egi"},
                {"Farkhan", "Farli", "Gilly", "Ichsan"},
                {"Lidya", "Syahfei", "Syifa", "Wahyu"}};

        for (int i = 0; i < nama.length; i++) {
            for (int j = 0; j < nama[i].length; j++) {
                System.out.print(nama[i][j] + "\t");
            }
            System.out.print("\n");
        }

        System.out.print("Nama yang dicari : ");
        String cari = scan.nextLine();

        binarySearchRow(nama, nama.length, nama[0].length, cari.toLowerCase());
    }

    static void binarySearchRow(String[][] nama, int jumlahBaris, int jumlahKolom, String cari) {
        int indexTerkecil = 0;
        int indexTerbesar = jumlahBaris - 1;
        int indexTengah;

        while (indexTerkecil <= indexTerbesar) {
            indexTengah = (indexTerkecil + indexTerbesar) / 2;

            if (cari.equals(nama[indexTengah][0].toLowerCase())) {
                System.out.println("Nama ditemukan di (" + indexTengah + ", 0)");
                return;
            }

            if (cari.equals(nama[indexTengah][jumlahKolom - 1].toLowerCase())) {
                System.out.println("Nama ditemukan di (" + indexTengah + ", " + (jumlahKolom - 1) + ")");
                return;
            }

            if (cari.compareTo(nama[indexTengah][0].toLowerCase()) > 0 && cari.compareTo(nama[indexTengah][jumlahKolom - 1].toLowerCase()) < 0) {
                binarySearchColumn(nama, jumlahBaris, jumlahKolom, cari, indexTengah);
                return;
            }

            if (cari.compareTo(nama[indexTengah][0].toLowerCase()) < 0) {
                indexTerbesar = indexTengah - 1;
            }

            if (cari.compareTo(nama[indexTengah][jumlahKolom - 1].toLowerCase()) > 0) {
                indexTerkecil = indexTengah + 1;
            }
        }
    }

    static void binarySearchColumn(String[][] nama, int jumlahBaris, int jumlahKolom, String cari, int indexTengahBaris) {
        int indexTerkecil = 0;
        int indexTerbesar = jumlahBaris - 1;
        int indexTengahKolom;

        while (indexTerkecil <= indexTerbesar) {
            indexTengahKolom = (indexTerkecil + indexTerbesar) / 2;

            if (nama[indexTengahBaris][indexTengahKolom].toLowerCase().equals(cari)) {
                System.out.println("Nama ditemukan di (" + indexTengahBaris + ", " + indexTengahKolom + ")");
                return;
            }

            if (nama[indexTengahBaris][indexTengahKolom].toLowerCase().compareTo(cari) > 0) {
                indexTerbesar = indexTengahKolom - 1;
            }

            if (nama[indexTengahBaris][indexTengahKolom].toLowerCase().compareTo(cari) < 0) {
                indexTerkecil = indexTengahKolom + 1;
            }
        }

        System.out.println("Nama tidak ditemukan");
    }
}