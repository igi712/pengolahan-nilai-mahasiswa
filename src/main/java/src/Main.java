package src;

import java.util.Scanner;

/**
 * Kelas Main menaungi antarmuka pengguna (CLI) untuk program pengolahan nilai mahasiswa.
 */
public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        StudentGrading grading = new StudentGrading();
        boolean continueInput = true;

        System.out.println("=========================================");
        System.out.println("   Program Pengolahan Nilai Mahasiswa    ");
        System.out.println("=========================================");

        while (continueInput) {
            double tugas = 0, uts = 0, uas = 0;
            boolean validInput = false;

            // Loop untuk meminta input yang valid
            while (!validInput) {
                System.out.print("\nMasukkan Nilai Tugas (0-100): ");
                tugas = scanner.nextDouble();
                
                System.out.print("Masukkan Nilai UTS (0-100): ");
                uts = scanner.nextDouble();
                
                System.out.print("Masukkan Nilai UAS (0-100): ");
                uas = scanner.nextDouble();

                if (grading.validateGrades(tugas, uts, uas)) {
                    validInput = true;
                } else {
                    System.out.println("-----------------------------------------");
                    System.out.println("Error: Input tidak valid.");
                    System.out.println("- Pastikan nilai berada dalam rentang 0-100.");
                    System.out.println("- Semua nilai tidak boleh 0 secara bersamaan.");
                    System.out.println("Silakan masukkan ulang data.");
                    System.out.println("-----------------------------------------");
                }
            }

            // Menjalankan perhitungan jika input valid
            double finalGrade = grading.calculateFinalGrade(tugas, uts, uas);

            if (finalGrade != -1.0) {
                String grade = grading.determineGrade(finalGrade);
                String passStatus = grading.determinePassStatus(finalGrade);

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
