import org.junit.Before;
import org.junit.Test;

import static org.junit.Assert.assertEquals;

public class QuiltingTest {
    Quilting quilting = new Quilting();
    @Before
    public void setQuilting() {
        quilting = new Quilting();
    }
    @Test
    public void testQuilting() {
        quilting.setQuiltingSize(4,3);
        quilting.inputBitmap(1,new int[][]{{0, 79, 240}, {10, 110, 230}, {9, 130, 213}, {30, 70, 235}});
        quilting.inputBitmap(2,new int[][]{{50, 62, 237}, {16, 58, 99}, {25, 120, 170}, {90, 120, 240}});
        assertEquals(450,quilting.getMinArtificiality());
    }
    @Test
    public void testQuilting2() {
        quilting.setQuiltingSize(1,3);
        quilting.inputBitmap(1,new int[][]{{0, 79, 240}});
        quilting.inputBitmap(2,new int[][]{{50, 62, 237}});
        assertEquals(9,quilting.getMinArtificiality());
    }
    @Test
    public void testQuilting3() {
        quilting.setQuiltingSize(2,3);
        quilting.inputBitmap(1,new int[][]{{0, 79, 240}, {10, 110, 230}});
        quilting.inputBitmap(2,new int[][]{{50, 62, 237}, {16, 58, 99}});
        assertEquals(325,quilting.getMinArtificiality());
    }
    @Test
    public void testQuilting4() {
        quilting.setQuiltingSize(10,10);
        quilting.inputBitmap(1,new int[][]{{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255},{255, 255, 255, 255, 255, 255, 255, 255, 255, 255}});
        quilting.inputBitmap(2,new int[][]{{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0},{0,0,0,0,0,0,0,0,0,0}});
        assertEquals(650250,quilting.getMinArtificiality());
    }
}
