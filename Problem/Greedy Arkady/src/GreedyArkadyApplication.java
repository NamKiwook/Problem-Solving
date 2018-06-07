import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

import static java.lang.Math.max;

public class GreedyArkadyApplication {
    public static void main(String[] args) throws IOException {
        GreedyArkady greedyArkady = new GreedyArkady();
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        StringTokenizer st = new StringTokenizer(br.readLine());
        long n = Long.parseLong(st.nextToken());
        long k = Long.parseLong(st.nextToken());
        long M = Long.parseLong(st.nextToken());
        long D = Long.parseLong(st.nextToken());

        greedyArkady.calcMaxArkadyCandy(n,k,M,D);
        System.out.print(greedyArkady.getMaxArkadyCandy());
    }
}
class GreedyArkady {
    private long maxArkadyCandy = 0;

    public long getMaxArkadyCandy() {
        return maxArkadyCandy;
    }

    public void calcMaxArkadyCandy(long numberCandy, long numberPeople, long maxNumberOnce, long maxNumberReceive) {
        long currentOnce;
        for(long currentReceive = 1; currentReceive <= maxNumberReceive; currentReceive++) {
            currentOnce = numberCandy / (numberPeople*(currentReceive-1) + 1);
            if(currentOnce > maxNumberOnce)
                currentOnce = maxNumberOnce;
            else if(currentOnce == 0)
                break;
            maxArkadyCandy = max(currentOnce*currentReceive,maxArkadyCandy);
        }
    }
}