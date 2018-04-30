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
}
