import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class ShortCodeTest {
    ShortCode shortCode = new ShortCode();
    @Before
    public void setShortCode () {
        shortCode = new ShortCode();
    }
    @Test
    public  void testShortCode () {
        shortCode.inputCode("codeforces");
        shortCode.inputCode("codehorces");
        shortCode.inputCode("code");
        Node root = shortCode.getShortCodeTree();
        for(int i = 0; i < root.numberChild(); i++) {
            ShortCode.decreaseNotConflict(root.getChild(root.getChildrenPosition()[i]));
            ShortCode.decreaseConflict(root.getChild(root.getChildrenPosition()[i]));
        }
        assertEquals(6,ShortCode.calcShortCode(0,root));
    }
    public  void testShortCode2 () {
        shortCode.inputCode("abba");
        shortCode.inputCode("abb");
        shortCode.inputCode("ab");
        shortCode.inputCode("aa");
        shortCode.inputCode("aacada");
        Node root = shortCode.getShortCodeTree();
        for(int i = 0; i < root.numberChild(); i++) {
            ShortCode.decreaseNotConflict(root.getChild(root.getChildrenPosition()[i]));
            ShortCode.decreaseConflict(root.getChild(root.getChildrenPosition()[i]));
        }
        assertEquals(11,ShortCode.calcShortCode(0,root));
    }
    public  void testShortCode3 () {
        shortCode.inputCode("telegram");
        shortCode.inputCode("digital");
        shortCode.inputCode("resistance");

        Node root = shortCode.getShortCodeTree();
        for(int i = 0; i < root.numberChild(); i++) {
            ShortCode.decreaseNotConflict(root.getChild(root.getChildrenPosition()[i]));
            ShortCode.decreaseConflict(root.getChild(root.getChildrenPosition()[i]));
        }
        assertEquals(3,ShortCode.calcShortCode(0,root));
    }
}
