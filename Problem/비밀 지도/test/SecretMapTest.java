import org.junit.Before;
import org.testng.annotations.Test;

import static org.junit.Assert.assertEquals;

public class SecretMapTest {
    SecretMap sm;
    @Before
    public void setSm() {
        sm = new SecretMap();
    }
    @Test
    public void input1() {
        sm.arr1 = new int[]{9, 20, 28, 18, 11};
        sm.arr2 = new int[]{30,1,21,17,28};
        assertEquals(new String[]{"#####","# # #","### #","#  ##","#####"},sm.solution());
    }
    @Test
    public void input2() {
        sm.arr1 = new int[]{46, 33, 33, 22, 31, 50};
        sm.arr2 = new int[]{27,56,19,14,14,10};
        assertEquals(new String[]{"######","###  #","##  ##"," #### "," #####","### # "},sm.solution());
    }
}
