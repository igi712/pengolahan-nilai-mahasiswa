package module;

import org.junit.Test;
import static org.junit.Assert.*;

public class ValidasiDataTest {

    private ValidasiData validasiData = new ValidasiData();

    @Test
    public void testValidGrades() {
        assertTrue(validasiData.validateGrades(80, 85, 90));
    }

    @Test
    public void testInvalidGrades_Negative() {
        assertFalse(validasiData.validateGrades(-10, 85, 90));
    }

    @Test
    public void testInvalidGrades_Over100() {
        assertFalse(validasiData.validateGrades(80, 105, 90));
    }

    @Test
    public void testInvalidGrades_AllZeros() {
        assertFalse(validasiData.validateGrades(0, 0, 0));
    }
}

