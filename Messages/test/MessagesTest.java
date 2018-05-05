import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class MessagesTest {
    Messages messages = new Messages();
    @Before
    public void messageSetup() {
        messages = new Messages();
    }
    @Test
    public void messagesTest1() {
        int n = 4;
        int A = 5;
        int B = 5;
        int C = 3;
        int T = 5;
        int[] t = {1,5,5,4};
        messages.calcMaxCost(n,A,B,C,T,t);
        assertEquals(20,messages.getMaxCost());
    }
    @Test
    public void messagesTest2() {
        int n = 5;
        int A = 3;
        int B = 1;
        int C = 1;
        int T = 3;
        int[] t = {2,2,2,1,1};
        messages.calcMaxCost(n,A,B,C,T,t);
        assertEquals(15,messages.getMaxCost());
    }
    @Test
    public void messagesTest3() {
        int n = 5;
        int A = 5;
        int B = 3;
        int C = 4;
        int T = 5;
        int[] t = {1,2,3,4,5};
        messages.calcMaxCost(n,A,B,C,T,t);
        assertEquals(35,messages.getMaxCost());
    }
}
