package module;

import java.util.Scanner;

public class InputData {
    private ValidasiData validator = new ValidasiData();
    private Scanner scanner = new Scanner(System.in);

    public double[] inputGrades() {
        double tugas, uts, uas;
        while (true) {
            try {
                System.out.print("Masukkan nilai tugas: ");
                tugas = scanner.nextDouble();
                System.out.print("Masukkan nilai UTS: ");
                uts = scanner.nextDouble();
                System.out.print("Masukkan nilai UAS: ");
                uas = scanner.nextDouble();

                if (validator.validateGrades(tugas, uts, uas)) {
                    return new double[]{tugas, uts, uas};
                } else {
                    System.out.println("Nilai tidak valid. Silakan coba lagi.");
                }
            } catch (Exception e) {
                System.out.println("Input tidak valid. Harap masukkan angka.");
                scanner.next(); // clear buffer
            }
        }
    }
}
