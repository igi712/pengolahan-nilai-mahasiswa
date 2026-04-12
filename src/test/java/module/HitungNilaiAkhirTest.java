package module;

import org.junit.Test;
import static org.junit.Assert.*;

public class HitungNilaiAkhirTest {

    private HitungNilaiAkhir hitungNilaiAkhir = new HitungNilaiAkhir();

    @Test
    public void testCalculateFinalGrade_Valid() {
        assertEquals(85.5, hitungNilaiAkhir.calculateFinalGrade(80, 85, 90), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_Invalid() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(-10, 85, 90), 0.01);
    }

    @Test
    public void testCalculateFinalGrade_Exceeds100() {
        assertEquals(-1.0, hitungNilaiAkhir.calculateFinalGrade(100, 100, 101), 0.01);
    }
}
