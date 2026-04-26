package module;

import java.util.Scanner;

public class PengolahanNilai {
    private InputData inputData;
    private HitungNilaiAkhir hitungNilaiAkhir;
    private TentukanGrade tentukanGrade;
    private TentukanKelulusan tentukanKelulusan;
    private Scanner scanner;

    public PengolahanNilai() {
        this.inputData = new InputData();
        this.hitungNilaiAkhir = new HitungNilaiAkhir();
        this.tentukanGrade = new TentukanGrade();
        this.tentukanKelulusan = new TentukanKelulusan();
        this.scanner = new Scanner(System.in);
    }

    public void jalankan() {
        boolean continueInput = true;

        System.out.println("=========================================");
        System.out.println("   Program Pengolahan Nilai Mahasiswa    ");
        System.out.println("=========================================");

        while (continueInput) {
            double[] grades = inputData.inputGrades();
            double tugas = grades[0];
            double uts = grades[1];
            double uas = grades[2];

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
