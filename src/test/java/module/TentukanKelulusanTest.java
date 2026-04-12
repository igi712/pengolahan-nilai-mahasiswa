package module;

import org.junit.Test;
import static org.junit.Assert.*;

public class TentukanKelulusanTest {

    private TentukanKelulusan tentukanKelulusan = new TentukanKelulusan();

    @Test
    public void testDeterminePassStatus_Lulus() {
        assertEquals("Lulus", tentukanKelulusan.determinePassStatus(75));
    }

    @Test
    public void testDeterminePassStatus_TidakLulus() {
        assertEquals("Tidak Lulus", tentukanKelulusan.determinePassStatus(50));
    }

    @Test
    public void testDeterminePassStatus_Invalid() {
        assertEquals("Invalid", tentukanKelulusan.determinePassStatus(110));
    }
}
