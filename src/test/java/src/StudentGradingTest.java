package src;

import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

public class StudentGradingTest {

    StudentGrading sg = new StudentGrading();

    // ======================
    // P1 - INVALID
    // ======================
    @Test
    void testInvalidNegative() {
        assertEquals("Invalid", sg.determineGrade(-1));
    }

    @Test
    void testInvalidOver100() {
        assertEquals("Invalid", sg.determineGrade(101));
    }

    // ======================
    // P2 - GRADE A
    // ======================
    @Test
    void testGradeA_Normal() {
        assertEquals("A", sg.determineGrade(90));
    }

    @Test
    void testGradeA_Boundary() {
        assertEquals("A", sg.determineGrade(85));
    }

    // ======================
    // P3 - GRADE B
    // ======================
    @Test
    void testGradeB_Normal() {
        assertEquals("B", sg.determineGrade(75));
    }

    @Test
    void testGradeB_Boundary() {
        assertEquals("B", sg.determineGrade(70));
    }

    // ======================
    // P4 - GRADE C
    // ======================
    @Test
    void testGradeC_Normal() {
        assertEquals("C", sg.determineGrade(65));
    }

    @Test
    void testGradeC_Boundary() {
        assertEquals("C", sg.determineGrade(60));
    }

    // ======================
    // P5 - GRADE D
    // ======================
    @Test
    void testGradeD_Normal() {
        assertEquals("D", sg.determineGrade(55));
    }

    @Test
    void testGradeD_Boundary() {
        assertEquals("D", sg.determineGrade(50));
    }

    // ======================
    // P6 - GRADE E
    // ======================
    @Test
    void testGradeE_Normal() {
        assertEquals("E", sg.determineGrade(40));
    }

    @Test
    void testGradeE_Boundary() {
        assertEquals("E", sg.determineGrade(0));
    }
}
