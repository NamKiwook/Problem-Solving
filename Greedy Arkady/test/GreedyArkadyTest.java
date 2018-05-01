import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class GreedyArkadyTest {
    GreedyArkady greedyArkady = new GreedyArkady();
    @Before
    public void setGreedyArkady() {
        greedyArkady = new GreedyArkady();
    }
    @Test
    public void testGreedyArkady() {
        long n = 20;
        long k = 4;
        long M = 5;
        long D = 2;
        greedyArkady.calcMaxArkadyCandy(n,k,M,D);
        assertEquals(8,greedyArkady.getMaxArkadyCandy());
    }
    @Test
    public void testGreedyArkady2() {
        long n = 30;
        long k = 9;
        long M = 4;
        long D = 1;
        greedyArkady.calcMaxArkadyCandy(n,k,M,D);
        assertEquals(4,greedyArkady.getMaxArkadyCandy());
    }
    @Test
    public void testGreedyArkady3() {
        long n = 1000000000000000000L;
        long k = 135;
        long M = 1000000000000000000L;
        long D = 1000;
        greedyArkady.calcMaxArkadyCandy(n,k,M,D);
        assertEquals(1000000000000000000L,greedyArkady.getMaxArkadyCandy());
    }
    @Test
    public void testGreedyArkady4() {
        long n = 1000000000000000000L;
        long k = 1000000000000000000L;
        long M = 1000;
        long D = 1000;
        greedyArkady.calcMaxArkadyCandy(n,k,M,D);
        assertEquals(1000,greedyArkady.getMaxArkadyCandy());
    }
}
