import org.junit.Test;

public class ColoringBookTest {
    ColoringBook cb = new ColoringBook();
    @Test
    public void testCase() {
        cb.solution(6,4,new int[][]{{1, 1, 1, 0}, {1, 2, 2, 0}, {1, 0, 0, 1}, {0, 0, 0, 1}, {0, 0, 0, 3}, {0, 0, 0, 3}});
    }
    @Test
    public void testCase2() {
        int[][] input = new int[100][100];
        for(int i = 0 ; i < 100; i++){
            for(int j = 0; j < 100; j++) {
                input[i][j] = i * 101 + j + 1;
            }
        }
        cb.solution(100,100,input);
    }
    @Test
    public void testCase3() {
        int[][] input = new int[100][100];
        for(int i = 0 ; i < 100; i++){
            for(int j = 0; j < 100; j++) {
                if(i%5 != 0) {
                    input[i][j] = j;
                }
            }
        }
        cb.solution(100,100,input);
    }
    @Test
    public void testCase4() {
        int[][] input = new int[100][100];
        for(int i = 0 ; i < 100; i++){
            for(int j = 0; j < 100; j++) {
                input[i][j] = 1;
            }
        }
        cb.solution(100,100,input);
    }
}
