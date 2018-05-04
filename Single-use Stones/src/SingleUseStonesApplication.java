import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.min;

public class SingleUseStonesApplication {
    static public void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int w = Integer.parseInt(st.nextToken());
        int l = Integer.parseInt(st.nextToken());
        int[] a = new int[w-1];
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < a.length; i++)
            a[i] = Integer.parseInt(st.nextToken());

        SingleUseStones singleUseStones = new SingleUseStones();
        singleUseStones.calcSingleUseStones(w,l,a);
        System.out.print(singleUseStones.getMaxFlog());
    }
}
class SingleUseStones {
    private int maxFlog = 0;

    public void calcSingleUseStones(int riverWidth, int maxJumpLength, int[] stones) {
        int maxJumpBlock = 0;
        for(int i = 0; i < maxJumpLength; i++){
            maxJumpBlock += stones[i];
        }
        maxFlog = maxJumpBlock;
        for(int i = 1; i < riverWidth - maxJumpLength; i++){
            maxJumpBlock = maxJumpBlock - stones[i-1] + stones[i-1+maxJumpLength];
            maxFlog = min(maxJumpBlock,maxFlog);
        }
    }

    public int getMaxFlog() {
        return maxFlog;
    }
}