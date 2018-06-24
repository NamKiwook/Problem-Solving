import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShuttleBusTest {
    ShuttleBus sb = new ShuttleBus();
    @Test
    public void testCase() {
        String[] input = new String[]{"08:00", "08:01", "08:02", "08:03"};
        assertEquals("09:00",sb.calc(1,1,5,input));

        input = new String[]{"09:10", "09:09", "08:00"};
        assertEquals("09:09",sb.calc(2,10,2,input));

        input = new String[]{"09:00", "09:00", "09:00", "09:00"};
        assertEquals("08:59",sb.calc(2,1,2,input));

        input = new String[]{"00:01", "00:01", "00:01", "00:01", "00:01"};
        assertEquals("00:00",sb.calc(1,1,5,input));

        input = new String[]{"23:59"};
        assertEquals("09:00",sb.calc(1,1,1,input));

        input = new String[]{"23:59","23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59", "23:59"};
        assertEquals("18:00",sb.calc(10,60,45,input));
    }

}
