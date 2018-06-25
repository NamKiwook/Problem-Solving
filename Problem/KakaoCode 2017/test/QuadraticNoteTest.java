import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuadraticNoteTest {
    QuadraticNote qn = new QuadraticNote();
    @Test
    public void testCase() {
/*        assertEquals(1,qn.solution(15));
        assertEquals(0,qn.solution(24));
        assertEquals(2,qn.solution(41));*/
        assertEquals(1735,qn.solution(2147483647));
    }
}
