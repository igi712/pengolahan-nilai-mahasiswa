package src;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class ValidasiDataTest {

    private StudentGrading sut;

    @Before
    public void setUp() {
        sut = new StudentGrading(); // Setup (arrange) SUT
    }

    // PATH 1: Terdapat nilai di luar batas ( < 0 atau > 100 )
    @Test
    public void testP1_NilaiDiluarBatas() {
        // (1) Setup: berikan nilai invalid (misal -5)
        // (2) Exercise: panggil sut.validateGrades(...)
        // (3) Verify: gunakan assertFalse() untuk memastikan return value false
    }

    // PATH 2: Semua nilai diinputkan dengan angka 0
    @Test
    public void testP2_SemuaNilaiNol() {
        // (1) Setup: berikan nilai 0 untuk tugas, uts, dan uas
        // (2) Exercise: panggil sut.validateGrades(...)
        // (3) Verify: gunakan assertFalse()
    }

    // PATH 3: Skenario Normal (Happy Path)
    @Test
    public void testP3_NilaiValid() {
        // (1) Setup: berikan nilai valid (misal 80, 80, 80)
        // (2) Exercise: panggil sut.validateGrades(...)
        // (3) Verify: gunakan assertTrue()
    }
}