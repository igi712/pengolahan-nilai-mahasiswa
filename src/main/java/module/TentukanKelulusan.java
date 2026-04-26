package module;

public class TentukanKelulusan {
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
