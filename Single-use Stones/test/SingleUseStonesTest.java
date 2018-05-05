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
    @Test
    public void testSingleUseStones2() {
        int w = 10;
        int n = 3;
        int[] a =  {1,1,1,1,2,1,1,1,1};
        singleUseStones.calcSingleUseStones(w,n,a);
        assertEquals(3,singleUseStones.getMaxFlog());
    }
    @Test
    public void testSingleUseStones3() {
        int w = 100000;
        int n = 99999;
        int[] a =  new int[w-1];
        for(int i = 0 ; i < a.length; i++)
            a[i] = 10000;
        singleUseStones.calcSingleUseStones(w,n,a);
        assertEquals(999990000,singleUseStones.getMaxFlog());
    }
}
