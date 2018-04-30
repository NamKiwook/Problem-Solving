import org.junit.Before;
import org.junit.Test;
import static org.junit.Assert.assertEquals;

public class SplitsTest {
    Splits splits = new Splits();
    @Before
    public void splitsSetup() {
        splits = new Splits();
    }
    @Test
    public void splitsTest() {
        splits.makeSplits(7);
        assertEquals(4, splits.numberSplits());
    }
    @Test
    public void splitsTest2() {
        splits.makeSplits(8);
        assertEquals(5, splits.numberSplits());
    }
    @Test
    public void splitsTest3() {
        splits.makeSplits(9);
        assertEquals(5, splits.numberSplits());
    }
}
