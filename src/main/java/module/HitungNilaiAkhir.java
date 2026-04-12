package module;

public class HitungNilaiAkhir {
    private ValidasiData validator = new ValidasiData();

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
        if (!validator.validateGrades(tugas, uts, uas)) {
            return -1.0;
        }

        double finalGrade = (0.3 * tugas) + (0.3 * uts) + (0.4 * uas);

        if (finalGrade > 100.0) {
            return -1.0;
        }

        return finalGrade;
    }
}
