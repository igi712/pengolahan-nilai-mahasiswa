package app;

import module.HitungNilaiAkhir;
import module.InputData;
import module.TentukanGrade;
import module.TentukanKelulusan;

import java.util.Scanner;

/**
 * Kelas Main menaungi antarmuka pengguna (CLI) untuk program pengolahan nilai mahasiswa.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        InputData inputData = new InputData();
        HitungNilaiAkhir hitungNilaiAkhir = new HitungNilaiAkhir();
        TentukanGrade tentukanGrade = new TentukanGrade();
        TentukanKelulusan tentukanKelulusan = new TentukanKelulusan();
        boolean continueInput = true;

        System.out.println("=========================================");
        System.out.println("   Program Pengolahan Nilai Mahasiswa    ");
        System.out.println("=========================================");

        while (continueInput) {
            double[] grades = inputData.inputGrades();
            double tugas = grades[0];
            double uts = grades[1];
            double uas = grades[2];

            // Menjalankan perhitungan jika input valid
            double finalGrade = hitungNilaiAkhir.calculateFinalGrade(tugas, uts, uas);

            if (finalGrade != -1.0) {
                String grade = tentukanGrade.determineGrade(finalGrade);
                String passStatus = tentukanKelulusan.determinePassStatus(finalGrade);

                System.out.println("\n============ Hasil Kalkulasi ============");
                System.out.printf("Nilai Akhir    : %.2f\n", finalGrade);
                System.out.println("Grade          : " + grade);
                System.out.println("Status         : " + passStatus);
                System.out.println("=========================================");
            } else {
                System.out.println("Terjadi kesalahan dalam perhitungan nilai akhir (nilai diluar range).");
            }

            // Bertanya kepada pengguna apakah ingin memproses data lain
            System.out.print("\nApakah Anda ingin memproses nilai mahasiswa lain? (y/n): ");
            String answer = scanner.next();
            if (answer.equalsIgnoreCase("n")) {
                continueInput = false;
            }
        }

        System.out.println("\nTerima kasih telah menggunakan program ini.");
        scanner.close();
    }
}
