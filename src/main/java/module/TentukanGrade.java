package module;

public class TentukanGrade {
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
    public String determineGrade(double finalGrade) {
        if (finalGrade < 0 || finalGrade > 100) {
            return "Invalid";
        } else if (finalGrade >= 85) {
            return "A";
        } else if (finalGrade >= 70) {
            return "B";
        } else if (finalGrade >= 60) {
            return "C";
        } else if (finalGrade >= 50) {
            return "D";
        } else {
            return "E";
        }
    }
}
