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
        int n = 20;
        int k = 4;
        int M = 5;
        int D = 2;
        greedyArkady.calcMaxArkadyCandy(n,k,M,D);
        assertEquals(8,greedyArkady.getMaxArkadyCandy());
    }
}
