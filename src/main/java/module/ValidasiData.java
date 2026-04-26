package module;

public class ValidasiData {
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
    public boolean validateGrades(double... grades) {
        if (grades == null || grades.length == 0) {
            return false;
        }

        boolean allZeros = true;
        for (double grade : grades) {
            if (Double.isNaN(grade) || grade < 0 || grade > 100) {
                return false;
            }
            if (grade != 0) {
                allZeros = false;
            }
        }

        return !allZeros;
    }
}
