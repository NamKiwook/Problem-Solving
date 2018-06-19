import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class CacheTest {
    Cache c = new Cache();
    @Test
    public void cacheTest() {
        String[] input = {"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertEquals(50, c.calc(3, input));

        input = new String[]{"Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul", "Jeju", "Pangyo", "Seoul"};
        assertEquals(21, c.calc(3, input));

        input = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assertEquals(60, c.calc(2, input));

        input = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA", "SanFrancisco", "Seoul", "Rome", "Paris", "Jeju", "NewYork", "Rome"};
        assertEquals(52, c.calc(5, input));

        input = new String[]{"Jeju", "Pangyo", "NewYork", "newyork"};
        assertEquals(16, c.calc(2, input));

        input = new String[]{"Jeju", "Pangyo", "Seoul", "NewYork", "LA"};
        assertEquals(25, c.calc(0, input));
    }
}
