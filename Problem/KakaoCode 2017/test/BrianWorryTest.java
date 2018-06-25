import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class BrianWorryTest {
    BrianWorry br = new BrianWorry();
    @Test
    public void testCase() {
        assertEquals("HELLO WORLD",br.solution("HaEaLaLaObWORLDb"));
        assertEquals("SIGONG J O A",br.solution("SpIpGpOpNpGJqOqA"));
        assertEquals("invalid",br.solution("AxAxAxAoBoBoB"));
        assertEquals("invalid",br.solution("ASDdASDSADa"));
        assertEquals("A ABC A",br.solution("AaAbBbCaA"));
        assertEquals("SS VS VD",br.solution("AaVVVaSSVgSVDD"));

    }
}
