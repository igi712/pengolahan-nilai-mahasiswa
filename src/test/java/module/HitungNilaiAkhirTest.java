package module;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class HitungNilaiAkhirTest {

    private HitungNilaiAkhir hitungNilaiAkhir;
    /**
     * Precondition: Inisialisasi objek yang dibutuhkan sebelum setiap test case dijalankan.
     * - ValidasiData diinisialisasi karena HitungNilaiAkhir bergantung padanya
     *   untuk memvalidasi input sebelum kalkulasi dilakukan.
     * - HitungNilaiAkhir diinisialisasi sebagai SUT (System Under Test).
     */
    @Before
    public void setUp() {
        hitungNilaiAkhir = new HitungNilaiAkhir();
    }

    // =========================================================================
    // PATH 1: 1 -> 2
    // Input tidak valid → validateGrades() = false → return -1.0
    // =========================================================================

    @Test
    public void testCalculateFinalGrade_TugasNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-1, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(75, -10, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UasNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(75, 80, -5), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(101, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(75, 101, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UasMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(75, 80, 101), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryBawah() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-0.01, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryAtas() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(100.01, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_SemuaNol() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(0, 0, 0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiNaN() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(Double.NaN, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiInfinity() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(Double.POSITIVE_INFINITY, 80, 85), 0.01);
    }

    // =========================================================================
    // PATH 2: 1 -> 3 -> 4 -> 5  [DEAD CODE - UNREACHABLE PATH]
    // Input valid → kalkulasi dilakukan → finalGrade > 100 → return -1.0
    // =========================================================================

    @Test
    public void testCalculateFinalGrade_HasilMelebihi100() {
        // 0.3(100) + 0.3(100) + 0.4(101) = 100.4 → return -1.0
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(101, 101, 101), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiTipikal() {
        // 0.3(80) + 0.3(75) + 0.4(85) = 80.5
        assertEquals(80.5, hitungNilaiAkhir.calculateFinalGrade(80, 75, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiSempurna() {
        // 0.3(100) + 0.3(100) + 0.4(100) = 100.0
        assertEquals(100.0, hitungNilaiAkhir.calculateFinalGrade(100, 100, 100), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiDesimal() {
        // 0.3(77.5) + 0.3(82.5) + 0.4(90.0) = 84.0
        assertEquals(84.0, hitungNilaiAkhir.calculateFinalGrade(77.5, 82.5, 90.0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasNolLainnyaValid() {
        // 0.3(0) + 0.3(80) + 0.4(85) = 58.0
        assertEquals(58.0, hitungNilaiAkhir.calculateFinalGrade(0, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsNolLainnyaValid() {
        // 0.3(80) + 0.3(0) + 0.4(85) = 58.0
        assertEquals(58.0, hitungNilaiAkhir.calculateFinalGrade(80, 0, 85), 0.01);
    }
}