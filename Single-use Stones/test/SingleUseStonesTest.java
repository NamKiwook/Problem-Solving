import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class SingleUseStonesTest {
    SingleUseStones singleUseStones = new SingleUseStones();
    @Before
    public void setSingleUseStones() {
        singleUseStones = new SingleUseStones();
    }
    @Test
    public void testSingleUseStones() {
        int w = 10;
        int n = 5;
        int[] a =  {0,0,1,0,2,0,0,1,0};
        singleUseStones.calcSingleUseStones(w,n,a);
        assertEquals(3,singleUseStones.getMaxFlog());
    }
}
