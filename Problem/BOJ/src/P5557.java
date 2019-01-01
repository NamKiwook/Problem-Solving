import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.math.BigInteger;

public class P5557 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int n = Integer.parseInt(br.readLine());
        String[] inputNums = br.readLine().split(" ");
        int[] nums = new int[n];
        BigInteger[][] DP = new BigInteger[n][21];

        for(int i = 0; i < n; i++) {
            nums[i] = Integer.parseInt(inputNums[i]);
        }
        DP[0][nums[0]].add(BigInteger.valueOf(1));

        for(int i = 1; i < n - 1; i++) {
            for(int j = 0; j <= 20; j++) {
                if(DP[i-1][j].compareTo(BigInteger.valueOf(0)) == 0) continue;
                if(j - nums[i] >= 0) {
                    DP[i][j - nums[i]].add(DP[i-1][j]);
                }
                if(j + nums[i] <= 20) {
                    DP[i][j + nums[i]].add(DP[i-1][j]);
                }
            }
        }

        System.out.println(DP[n-2][nums[n-1]]);
    }
}
