import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SplitsTest {
    Splits s = new Splits();
    @Before
    public void splitsSetup() {
        s = new Splits();
    }
    @Test
    public void splitsTest() {
        s.makeSplits(7);
        assertEquals(4,s.numberSplits());
    }
}
