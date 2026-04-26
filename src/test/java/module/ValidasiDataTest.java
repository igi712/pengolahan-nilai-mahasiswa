package module;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidasiDataTest {

    private ValidasiData validasiData;

    @Before
    public void setUp() {
        validasiData = new ValidasiData();
    }

    @Test
    public void testValidateGrades_NilaiNegatif() {
        assertFalse("Jika ada nilai < 0, harus mengembalikan false", validasiData.validateGrades(-5, 80, 90));
    }

    @Test
    public void testValidateGrades_NilaiLebihDari100() {
        assertFalse("Jika ada nilai > 100, harus mengembalikan false", validasiData.validateGrades(105, 80, 90));
    }

    @Test
    public void testValidateGrades_SemuaNilaiNol() {
        assertFalse("Jika semua nilai 0, harus mengembalikan false", validasiData.validateGrades(0, 0, 0));
    }

    @Test
    public void testValidateGrades_NilaiValidNormal() {
        assertTrue("Jika semua nilai valid (0-100) dan tidak semuanya 0, harus mengembalikan true", validasiData.validateGrades(80, 85, 90));
    }

    @Test
    public void testValidateGrades_KombinasiNolDanValid() {
        assertTrue("Jika ada nilai 0 namun ada nilai lain yang valid, harus mengembalikan true", validasiData.validateGrades(0, 100, 50));
    }

    @Test
    public void testValidateGrades_InputKosong() {
        assertFalse("Jika argumen kosong, harus mengembalikan false", validasiData.validateGrades());
    }

    @Test
    public void testValidateGrades_InputNull() {
        assertFalse("Jika array argumen null, harus mengembalikan false", validasiData.validateGrades((double[]) null));
    }

    @Test
    public void testValidateGrades_NilaiNaN() {
        assertFalse("Jika ada nilai NaN, harus mengembalikan false", validasiData.validateGrades(Double.NaN, 80, 90));
    }
}
