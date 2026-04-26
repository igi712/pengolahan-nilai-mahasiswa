package module;

import org.junit.Test;
import static org.junit.Assert.*;

public class HitungNilaiAkhirTest {

    private HitungNilaiAkhir hitungNilaiAkhir = new HitungNilaiAkhir();

    // =========================================================================
    // INVALID INPUTS: Negatives
    // Menguji setiap parameter secara independen untuk memastikan filter < 0 bekerja
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

    // =========================================================================
    // INVALID INPUTS: Exceeding 100
    // Menguji setiap parameter untuk memastikan filter > 100 bekerja
    // =========================================================================

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

    // =========================================================================
    // INVALID INPUTS: Exact Boundaries & All Zeros
    // Menguji batas presisi desimal terdekat dengan nilai valid
    // =========================================================================

    @Test
    public void testCalculateFinalGrade_TugasBoundaryBawah() {
        // Tepat di bawah 0
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-0.01, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryAtas() {
        // Tepat di atas 100
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(100.01, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_SemuaNol() {
        // Aturan spesifik K2: Semua belum input
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(0, 0, 0), 0.01);
    }

    // =========================================================================
    // VALID INPUTS: Successful Calculations
    // Menguji kalkulasi normal, batas valid, dan kombinasi nol yang diizinkan
    // =========================================================================

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
        // Salah satu nol masih valid selama yang lain ada
        // 0.3(0) + 0.3(80) + 0.4(85) = 58.0
        assertEquals(58.0, hitungNilaiAkhir.calculateFinalGrade(0, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsNolLainnyaValid() {
        // 0.3(80) + 0.3(0) + 0.4(85) = 58.0
        assertEquals(58.0, hitungNilaiAkhir.calculateFinalGrade(80, 0, 85), 0.01);
    }

    // =========================================================================
    // EDGE CASES: Java Double Behaviors
    // Menguji kelemahan tipe data primitive Java
    // =========================================================================

    @Test
    public void testCalculateFinalGrade_NilaiNaN() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(Double.NaN, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiInfinity() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(Double.POSITIVE_INFINITY, 80, 85), 0.01);
    }
}