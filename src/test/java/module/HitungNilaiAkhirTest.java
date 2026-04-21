package module;

import org.junit.Test;
import static org.junit.Assert.*;

public class HitungNilaiAkhirTest {

    private HitungNilaiAkhir hitungNilaiAkhir = new HitungNilaiAkhir();

    // =========================================================================
    // PATH 1 (1→2) — validateGrades() gagal → return -1.0
    // =========================================================================

    // K1: Negatif
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
    public void testCalculateFinalGrade_SemuaNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-10, -20, -30), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasDanUtsNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-5, -5, 80), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasDanUasNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-5, 80, -5), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsDanUasNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(80, -5, -5), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryBawah() {
        // boundary: tepat di bawah 0 (-0.01)
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-0.01, 80, 85), 0.01);
    }

    // K2: Semua nol (belum input)
    @Test
    public void testCalculateFinalGrade_SemuaNol() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(0, 0, 0), 0.01);
    }

    // K4: Melebihi 100
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
    public void testCalculateFinalGrade_SemuaMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(110, 120, 130), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasDanUtsMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(101, 101, 80), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasDanUasMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(101, 80, 101), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsDanUasMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(80, 101, 101), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryAtas() {
        // boundary: tepat di atas 100 (100.01)
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(100.01, 80, 85), 0.01);
    }

    // Kombinasi K1 + K4
    @Test
    public void testCalculateFinalGrade_TugasNegatifUtsMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-5, 110, 80), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasMelebihi100UtsNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(110, -5, 80), 0.01);
    }

    // Kombinasi K1 + K2
    @Test
    public void testCalculateFinalGrade_DuaNolUasNegatif() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(0, 0, -1), 0.01);
    }

    // Kombinasi K2 + K4
    @Test
    public void testCalculateFinalGrade_DuaNolUasMelebihi100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(0, 0, 101), 0.01);
    }

    // =========================================================================
    // PATH 2 (1→3→4→5) — Dead code: finalGrade > 100 tidak dapat dicapai
    // karena bobot 0.3+0.3+0.4=1.0, input max valid = 100 → finalGrade max = 100.0
    // =========================================================================

    @Test
    public void testCalculateFinalGrade_DeadCode_InputMaxValid() {
        // tugas=100, uts=100, uas=100 → finalGrade = 100.0, bukan > 100
        // sehingga Path 2 tidak pernah tercapai, hasil masuk ke Path 3
        assertEquals(100.0, hitungNilaiAkhir.calculateFinalGrade(100, 100, 100), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_DeadCode_FinalGradeSelalu100AtauKurang() {
        // membuktikan if (finalGrade > 100) adalah dead code
        double result = hitungNilaiAkhir.calculateFinalGrade(99, 99, 99);
        assertTrue(result <= 100.0);
        assertNotEquals(-1.0, result, 0.01);
    }

    // =========================================================================
    // PATH 3 (1→3→4→6) — Kalkulasi sukses → return finalGrade
    // =========================================================================

    // K3: Nilai valid (0 < x <= 100)
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
    public void testCalculateFinalGrade_TugasNolLainnyaValid() {
        // 0.3(0) + 0.3(80) + 0.4(85) = 58.0
        assertEquals(58.0, hitungNilaiAkhir.calculateFinalGrade(0, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UtsNolLainnyaValid() {
        // 0.3(80) + 0.3(0) + 0.4(85) = 58.0
        assertEquals(58.0, hitungNilaiAkhir.calculateFinalGrade(80, 0, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_UasNolLainnyaValid() {
        // 0.3(80) + 0.3(75) + 0.4(0) = 46.5
        assertEquals(46.5, hitungNilaiAkhir.calculateFinalGrade(80, 75, 0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_DuaNolSatuValid() {
        // 0.3(90) + 0.3(0) + 0.4(0) = 27.0
        assertEquals(27.0, hitungNilaiAkhir.calculateFinalGrade(90, 0, 0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryAtas100() {
        // 0.3(100) + 0.3(50) + 0.4(50) = 65.0
        assertEquals(65.0, hitungNilaiAkhir.calculateFinalGrade(100, 50, 50), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_TugasBoundaryBawah0() {
        // 0.3(0) + 0.3(1) + 0.4(1) = 0.7
        assertEquals(0.7, hitungNilaiAkhir.calculateFinalGrade(0, 1, 1), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiDesimal() {
        // 0.3(77.5) + 0.3(82.5) + 0.4(90.0) = 84.0
        assertEquals(84.0, hitungNilaiAkhir.calculateFinalGrade(77.5, 82.5, 90.0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiRendah() {
        // 0.3(10) + 0.3(10) + 0.4(10) = 10.0
        assertEquals(10.0, hitungNilaiAkhir.calculateFinalGrade(10, 10, 10), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiMerata() {
        // 0.3(50) + 0.3(50) + 0.4(50) = 50.0
        assertEquals(50.0, hitungNilaiAkhir.calculateFinalGrade(50, 50, 50), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiBervariasi() {
        // 0.3(60) + 0.3(70) + 0.4(80) = 71.0
        assertEquals(71.0, hitungNilaiAkhir.calculateFinalGrade(60, 70, 80), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiTinggi() {
        // 0.3(90) + 0.3(85) + 0.4(95) = 90.5
        assertEquals(90.5, hitungNilaiAkhir.calculateFinalGrade(90, 85, 95), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_HanyaTugasDiisi() {
        // 0.3(100) + 0.3(0) + 0.4(0) = 30.0
        assertEquals(30.0, hitungNilaiAkhir.calculateFinalGrade(100, 0, 0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_HanyaUtsDiisi() {
        // 0.3(0) + 0.3(100) + 0.4(0) = 30.0
        assertEquals(30.0, hitungNilaiAkhir.calculateFinalGrade(0, 100, 0), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_HanyaUasDiisi() {
        // 0.3(0) + 0.3(0) + 0.4(100) = 40.0
        assertEquals(40.0, hitungNilaiAkhir.calculateFinalGrade(0, 0, 100), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiDesimalCampuran() {
        // 0.3(55.5) + 0.3(66.5) + 0.4(77.5) = 67.6
        assertEquals(67.6, hitungNilaiAkhir.calculateFinalGrade(55.5, 66.5, 77.5), 0.01);
    }

    // =========================================================================
    // K5 — Input bukan numerik (diuji di layer parsing)
    // Karena parameter bertipe double, String/char ditolak saat compile.
    // Pengujian dilakukan pada Double.parseDouble() sebagai simulasi input user.
    // =========================================================================

    @Test(expected = NumberFormatException.class)
    public void testCalculateFinalGrade_ParseStringHuruf() {
        double tugas = Double.parseDouble("abc");
        hitungNilaiAkhir.calculateFinalGrade(tugas, 80, 85);
    }

    @Test(expected = NumberFormatException.class)
    public void testCalculateFinalGrade_ParseSimbol() {
        double uts = Double.parseDouble("@#!");
        hitungNilaiAkhir.calculateFinalGrade(75, uts, 85);
    }

    @Test(expected = NumberFormatException.class)
    public void testCalculateFinalGrade_ParseStringKosong() {
        double uas = Double.parseDouble("");
        hitungNilaiAkhir.calculateFinalGrade(75, 80, uas);
    }

    @Test(expected = NumberFormatException.class)
    public void testCalculateFinalGrade_ParseSpasi() {
        double tugas = Double.parseDouble("   ");
        hitungNilaiAkhir.calculateFinalGrade(tugas, 80, 85);
    }

    @Test
    public void testCalculateFinalGrade_NilaiNaN() {
        // Double.NaN lolos type check Java tapi tidak valid secara logika
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(Double.NaN, 80, 85), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_NilaiInfinity() {
        // Double.POSITIVE_INFINITY lolos type check Java tapi tidak valid secara logika
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(Double.POSITIVE_INFINITY, 80, 85), 0.01);
    }
}