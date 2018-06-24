import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class WalkerHeavenTest {
    WalkerHeaven wh = new WalkerHeaven();
    @Test
    public void testCase() {
        int m = 3;
        int n = 3;
        int[][] input = new int[][]{{0, 0, 0}, {0, 0, 0}, {0, 0, 0}};
        assertEquals(6,wh.solution(m,n,input));
    }
    @Test
    public void testCase2() {
        int m = 3;
        int n = 6;
        int[][] input = new int[][]{{0, 2, 0, 0, 0, 2}, {0, 0, 2, 0, 1, 0}, {1, 0, 0, 2, 2, 0}}	;
        assertEquals(2,wh.solution(m,n,input));
    }
}
