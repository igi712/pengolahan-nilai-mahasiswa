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
    public boolean validateGrades(double tugas, double uts, double uas) {
        if (tugas < 0 || tugas > 100 || uts < 0 || uts > 100 || uas < 0 || uas > 100) {
            return false;
        }
        if (tugas == 0 && uts == 0 && uas == 0) {
            return false;
        }
        return true;
    }
}
