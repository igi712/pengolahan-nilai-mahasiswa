package src;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidasiDataTest {

    // Mendeklarasikan Software Under Test (SUT)
    private StudentGrading sut;

    // Fase Setup Umum (Implicit Setup) yang dijalankan sebelum setiap metode @Test
    @Before
    public void setUp() {
        sut = new StudentGrading();
    }

    // TC-01: Menguji input dengan nilai negatif (P1)
    @Test
    public void validateGrades_NilaiNegatif_ReturnsFalse() {
        // (1) setup (arrange, build): Menyiapkan data uji
        double tugas = -5;
        double uts = 80;
        double uas = 90;

        // (2) exercise (act, operate): Menjalankan metode yang diuji
        boolean actual = sut.validateGrades(tugas, uts, uas);

        // (3) verify (assert, check): Memastikan hasil sesuai ekspektasi
        assertFalse("Jika ada nilai < 0, harus mengembalikan false", actual);
    }

    // TC-02: Menguji input dengan nilai lebih dari 100 (P1)
    @Test
    public void validateGrades_NilaiLebihDari100_ReturnsFalse() {
        // (1) setup (arrange, build)
        double tugas = 105;
        double uts = 80;
        double uas = 90;

        // (2) exercise (act, operate)
        boolean actual = sut.validateGrades(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse("Jika ada nilai > 100, harus mengembalikan false", actual);
    }

    // TC-03: Menguji kondisi di mana semua input belum diisi / 0 (P2)
    @Test
    public void validateGrades_SemuaNilaiNol_ReturnsFalse() {
        // (1) setup (arrange, build)
        double tugas = 0;
        double uts = 0;
        double uas = 0;

        // (2) exercise (act, operate)
        boolean actual = sut.validateGrades(tugas, uts, uas);

        // (3) verify (assert, check)
        assertFalse("Jika semua nilai 0, harus mengembalikan false", actual);
    }

    // TC-04: Menguji kondisi normal / Happy Path (P3)
    @Test
    public void validateGrades_NilaiValidNormal_ReturnsTrue() {
        // (1) setup (arrange, build)
        double tugas = 80;
        double uts = 85;
        double uas = 90;

        // (2) exercise (act, operate)
        boolean actual = sut.validateGrades(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue("Jika semua nilai valid (0-100) dan tidak semuanya 0, harus mengembalikan true", actual);
    }

    // TC-05: Menguji kondisi batas normal kombinasi 0 (P3)
    @Test
    public void validateGrades_KombinasiNolDanValid_ReturnsTrue() {
        // (1) setup (arrange, build)
        double tugas = 0;
        double uts = 100;
        double uas = 50;

        // (2) exercise (act, operate)
        boolean actual = sut.validateGrades(tugas, uts, uas);

        // (3) verify (assert, check)
        assertTrue("Jika ada nilai 0 namun ada nilai lain yang valid, harus mengembalikan true", actual);
    }
}