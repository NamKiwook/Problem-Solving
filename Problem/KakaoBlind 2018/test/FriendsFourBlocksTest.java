import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class FriendsFourBlocksTest {
    FriendsFourBlocks ffb = new FriendsFourBlocks();
    @Test
    public void testCase() {
        assertEquals(14,ffb.solution(4,5,new String[]{"CCBDE","AAADE","AAABF","CCBBF"}));
        assertEquals(15,ffb.solution(6,6,new String[]{"TTTANT","RRFACC","RRRFCC","TRRRAA","TTMMMF","TMMTTJ"}));
    }
}
