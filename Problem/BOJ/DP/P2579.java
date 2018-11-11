import java.io.IOException;
import java.util.*;

public class P2579 {
    public static void main(String[] args) throws IOException {
        Scanner input = new Scanner(System.in);
        int n = input.nextInt();
        int[] stairs = new int[n];
        int[][] score = new int[n][2];
        for(int i = 0; i < n; i++){
            stairs[i] = input.nextInt();
        }

        for(int i = 0; i < n; i++) {
            if(i == 0) {
                score[0][0] = stairs[0];
                score[0][1] = stairs[0];
            } else if(i == 1) {
                score[1][0] = stairs[1];
                score[1][1] = score[0][0] + stairs[1];
            } else {
                score[i][0] = (score[i - 2][0] > score[i - 2][1] ? score[i - 2][0] : score[i - 2][1]) + stairs[i];
                score[i][1] = score[i - 1][0] + stairs[i];
            }
        }
        int result = score[n-1][0] > score[n-1][1] ? score[n-1][0] : score[n-1][1];
        System.out.print(result);
    }
}