package src;

/**
 * Kelas StudentGrading menangani logika komputasi untuk pengolahan nilai mahasiswa.
 * Kelas ini dibuat terisolasi dari antarmuka pengguna agar mudah diuji secara unit (Unit Testing).
 */
public class StudentGrading {

    /**
     * Memvalidasi input nilai mahasiswa.
     * 
     * Aturan:
     * - valid jika 0 <= nilai <= 100
     * - tidak valid jika ada nilai < 0 atau > 100
     * - tidak valid jika semua nilai == 0 (dianggap belum input)
     *
     * @param tugas Nilai tugas
     * @param uts   Nilai UTS
     * @param uas   Nilai UAS
     * @return true jika valid, false jika sebaliknya.
     */
    public boolean validateGrades(double tugas, double uts, double uas) {
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            return false;
        }
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }
        return true;
    }

    /**
     * Menghitung nilai akhir mahasiswa berdasarkan proporsi:
     * Tugas (30%), UTS (30%), UAS (40%).
     * 
     * Kondisi Error:
     * - Jika input tidak valid, mengembalikan -1
     * - Jika hasil lebih dari 100, mengembalikan -1
     *
     * @param tugas Nilai tugas
     * @param uts   Nilai UTS
     * @param uas   Nilai UAS
     * @return Nilai akhir atau -1 jika terjadi error.
     */
    public double calculateFinalGrade(double tugas, double uts, double uas) {
        if (!validateGrades(tugas, uts, uas)) {
            return -1.0;
        }

        double finalGrade = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);

        if (finalGrade > 100.0) {
            return -1.0;
        }

        return finalGrade;
    }

    /**
     * Menentukan grade (A, B, C, D, E) berdasarkan nilai akhir.
     * 
     * Aturan:
     * - >= 85: A
     * - 70 - 84.9: B
     * - 60 - 69.9: C
     * - 50 - 59.9: D
     * - < 50: E
     *
     * @param finalGrade Nilai akhir mahasiswa
     * @return Karakter tipe String yang merepresentasikan grade (A-E), atau "Invalid" jika nilai error.
     */
    public String determineGrade(double finalGrade) {  // node 1
        if (finalGrade < 0 || finalGrade > 100) {      // node 2
            return "Invalid";                          // node 3
        } else if (finalGrade >= 85) {                 // node 4
            return "A";                                // node 5
        } else if (finalGrade >= 70) {                 // node 6
            return "B";                                // node 7
        } else if (finalGrade >= 60) {                 // node 8
            return "C";                                // node 9
        } else if (finalGrade >= 50) {                 // node 10
            return "D";                                // node 11
        } else {
            return "E";                                // node 12
        }
    }

    /**
     * Menentukan status kelulusan berdasarkan nilai akhir.
     * 
     * Aturan:
     * - >= 60: Lulus
     * - < 60: Tidak Lulus
     *
     * @param finalGrade Nilai akhir mahasiswa
     * @return String "Lulus" atau "Tidak Lulus", dan "Invalid" jika nilai error.
     */
    public String determinePassStatus(double finalGrade) {
        if (finalGrade < 0 || finalGrade > 100) {
            return "Invalid";
        } else if (finalGrade >= 60) {
            return "Lulus";
        } else {
            return "Tidak Lulus";
        }
    }
}
