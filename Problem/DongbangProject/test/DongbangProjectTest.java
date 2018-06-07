import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class DongbangProjectTest {
    DongbangProject DP = new DongbangProject();
    @Before
    public void setDP () {
        DP = new DongbangProject();
    }
    @Test
    public void testDP () {
        DP.setNumberRoom(5);
        DP.actVillain(1,2);
        DP.actVillain(2,4);
        assertEquals(2,DP.getNumberRoom());
    }
    @Test
    public void testDP2 () {
        DP.setNumberRoom(100);
        assertEquals(100,DP.getNumberRoom());
    }    @Test
    public void testDP3 () {
        DP.setNumberRoom(10);
        DP.actVillain(1,3);
        DP.actVillain(2,4);
        DP.actVillain(5,8);
        assertEquals(4,DP.getNumberRoom());
    }
}
