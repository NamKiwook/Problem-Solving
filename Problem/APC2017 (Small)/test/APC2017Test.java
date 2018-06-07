import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class APC2017Test {
    APC2017 apc2017 = new APC2017();

    @Before
    public void setApc2017() {
        apc2017 = new APC2017();
    }
    @Test
    public void testApc2017() {
        apc2017.inputScore(300,5,100);
        apc2017.inputScore(620,7,179);
        apc2017.inputScore(600,9,150);
        assertEquals(2,apc2017.calcRank());
    }
    @Test
    public void testApc20172() {
        apc2017.inputScore(300,5,100);
        apc2017.inputScore(620,7,179);
        apc2017.inputScore(600,2,150);
        apc2017.inputScore(333,9,150);
        apc2017.inputScore(600,4,150);
        apc2017.inputScore(222,9,150);
        apc2017.inputScore(600,6,150);
        apc2017.inputScore(333,4,150);

        assertEquals(2,apc2017.calcRank());
    }
    @Test
    public void testApc20173() {
        apc2017.inputScore(300,5,100);
        apc2017.inputScore(620,10,179);
        apc2017.inputScore(600,9,150);
        apc2017.inputScore(600,1,150);
        apc2017.inputScore(620,2,150);
        apc2017.inputScore(620,3,150);
        apc2017.inputScore(600,4,150);
        apc2017.inputScore(620,5,150);
        apc2017.inputScore(600,6,150);
        apc2017.inputScore(620,10,150);
        apc2017.inputScore(620,7,150);
        apc2017.inputScore(600,8,150);

        assertEquals(2,apc2017.calcRank());
    }
}
