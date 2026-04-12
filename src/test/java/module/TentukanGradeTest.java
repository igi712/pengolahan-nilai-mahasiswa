package module;

import org.junit.Test;
import static org.junit.Assert.*;

public class TentukanGradeTest {

    private TentukanGrade tentukanGrade = new TentukanGrade();

    @Test
    public void testDetermineGrade_A() {
        assertEquals("A", tentukanGrade.determineGrade(90));
    }

    @Test
    public void testDetermineGrade_B() {
        assertEquals("B", tentukanGrade.determineGrade(80));
    }

    @Test
    public void testDetermineGrade_C() {
        assertEquals("C", tentukanGrade.determineGrade(65));
    }

    @Test
    public void testDetermineGrade_D() {
        assertEquals("D", tentukanGrade.determineGrade(55));
    }

    @Test
    public void testDetermineGrade_E() {
        assertEquals("E", tentukanGrade.determineGrade(40));
    }

    @Test
    public void testDetermineGrade_Invalid() {
        assertEquals("Invalid", tentukanGrade.determineGrade(-10));
    }
}
