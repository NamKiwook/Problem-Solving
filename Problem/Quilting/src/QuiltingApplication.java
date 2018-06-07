import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Integer.parseInt;

public class QuiltingApplication {
    public static void main(String[] arg) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Quilting quilting = new Quilting();
        int height = parseInt(st.nextToken());
        int width = parseInt(st.nextToken());
        quilting.setQuiltingSize(height,width);
        for(int k = 1; k <= 2; k++) {
            int[][] bitmap = new int[height][width];
            for (int i = 0; i < height; i++) {
                st = new StringTokenizer(br.readLine());
                for (int j = 0; j < width; j++) {
                    bitmap[i][j] = parseInt(st.nextToken());
                }
            }
            quilting.inputBitmap(k,bitmap);
        }
        System.out.print(quilting.getMinArtificiality());
    }
}
class Quilting{
    private int[][][] bitmap;
    private int[][] artificialityBitmap;
    public void setQuiltingSize(int height, int width) {
        bitmap = new int[2][height][width];
        artificialityBitmap = new int[height][width];
    }
    public int getMinArtificiality() {
        setArtificialityBitmap();
        for(int i = 1 ; i< artificialityBitmap.length; i++) {
            for (int j = 0; j < artificialityBitmap[i].length; j++) {
                if (artificialityBitmap[i].length == 1) {
                    artificialityBitmap[i][j] += artificialityBitmap[i - 1][j];
                } else if (j == 0) {
                    artificialityBitmap[i][j] += Math.min(artificialityBitmap[i - 1][j], artificialityBitmap[i - 1][j + 1]);
                } else if (j == artificialityBitmap[i].length - 1) {
                    artificialityBitmap[i][j] += Math.min(artificialityBitmap[i - 1][j], artificialityBitmap[i - 1][j - 1]);
                } else {
                    artificialityBitmap[i][j] += Math.min(Math.min(artificialityBitmap[i - 1][j], artificialityBitmap[i - 1][j - 1]), artificialityBitmap[i - 1][j + 1]);
                }
            }
        }
        int minimum = artificialityBitmap[artificialityBitmap.length - 1][0];
        for(int i = 0; i < artificialityBitmap[artificialityBitmap.length - 1].length; i++) {
            if(minimum > artificialityBitmap[artificialityBitmap.length - 1][i])
                minimum = artificialityBitmap[artificialityBitmap.length - 1][i];
        }
        return minimum;
    }

    private void setArtificialityBitmap() {
        for(int i = 0; i < artificialityBitmap.length; i++) {
            for(int j = 0; j < artificialityBitmap[i].length; j++) {
                artificialityBitmap[i][j] = (int) Math.pow(bitmap[0][i][j] - bitmap[1][i][j],2);
            }
        }
    }

    public void inputBitmap(int i, int[][] inputData) {
        bitmap[i-1] = inputData;
    }


}