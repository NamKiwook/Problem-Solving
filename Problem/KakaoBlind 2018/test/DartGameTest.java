import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DartGameTest {
    DartGame dg;
    @Before
    public void setDg () {
        dg = new DartGame();
    }
    @Test
    public void testCase() {
        assertEquals(37,dg.calc("1S2D*3T"));
        assertEquals(9,dg.calc("1D2S#10S"));
        assertEquals(3,dg.calc("1D2S0T"));
        assertEquals(23,dg.calc("1S*2T*3S"));
        assertEquals(5,dg.calc("1D#2S*3S"));
        assertEquals(-4,dg.calc("1T2D3D#"));
        assertEquals(59,dg.calc("1D2S3T*"));
    }
}
