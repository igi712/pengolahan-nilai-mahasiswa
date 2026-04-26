package module;

import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.*;

public class TentukanGradeTest {

    private TentukanGrade tentukanGrade;

    @Before
    public void setUp() {
        tentukanGrade = new TentukanGrade();
    }

    // ======================
    // P1 - INVALID
    // ======================
    @Test
    public void testInvalidNegative() {
        assertEquals("Invalid", tentukanGrade.determineGrade(-1));
    }

    @Test
    public void testInvalidOver100() {
        assertEquals("Invalid", tentukanGrade.determineGrade(101));
    }

    // ======================
    // P2 - GRADE A
    // ======================
    @Test
    public void testGradeA_Normal() {
        assertEquals("A", tentukanGrade.determineGrade(90));
    }

    @Test
    public void testGradeA_Boundary() {
        assertEquals("A", tentukanGrade.determineGrade(85));
    }

    // ======================
    // P3 - GRADE B
    // ======================
    @Test
    public void testGradeB_Normal() {
        assertEquals("B", tentukanGrade.determineGrade(75));
    }

    @Test
    public void testGradeB_Boundary() {
        assertEquals("B", tentukanGrade.determineGrade(70));
    }

    // ======================
    // P4 - GRADE C
    // ======================
    @Test
    public void testGradeC_Normal() {
        assertEquals("C", tentukanGrade.determineGrade(65));
    }

    @Test
    public void testGradeC_Boundary() {
        assertEquals("C", tentukanGrade.determineGrade(60));
    }

    // ======================
    // P5 - GRADE D
    // ======================
    @Test
    public void testGradeD_Normal() {
        assertEquals("D", tentukanGrade.determineGrade(55));
    }

    @Test
    public void testGradeD_Boundary() {
        assertEquals("D", tentukanGrade.determineGrade(50));
    }

    // ======================
    // P6 - GRADE E
    // ======================
    @Test
    public void testGradeE_Normal() {
        assertEquals("E", tentukanGrade.determineGrade(40));
    }

    @Test
    public void testGradeE_Boundary() {
        assertEquals("E", tentukanGrade.determineGrade(0));
    }
}