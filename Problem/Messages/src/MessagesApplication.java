import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class MessagesApplication {
    public static void main (String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);

        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int A = Integer.parseInt(st.nextToken());
        int B = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());
        int T = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] t = new int[n];
        for(int i = 0; i < n; i++) {
            t[i] = Integer.parseInt(st.nextToken());
        }

        Messages messages = new Messages();
        messages.calcMaxCost(n,A,B,C,T,t);
        System.out.print(messages.getMaxCost());
    }
}

class Messages {
    private int maxCost = 0;

    public void calcMaxCost(int numberMessages, int initialCost, int minuteDecreaseCost, int remainMessageCost, int maxMinute, int[] receiveMinute) {
        if(remainMessageCost-minuteDecreaseCost <= 0){
            maxCost = numberMessages*initialCost;
        } else {
            maxCost = numberMessages*initialCost;
            for(int i = 0; i < numberMessages; i++) {
                maxCost += (maxMinute - receiveMinute[i]) * (remainMessageCost - minuteDecreaseCost);
            }
        }
    }

    public int getMaxCost() {
        return maxCost;
    }
}
