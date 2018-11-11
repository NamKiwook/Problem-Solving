import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1463{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[] count = new int[N + 1];
        Queue<Integer> q = new LinkedList<>();
        for(int i = 0; i < N; i++) {
            count[i] = 10000000;
        }
        count[N] = 0;
        q.add(N);
        while(!q.isEmpty()) {
            int current = q.poll();
            if(current % 3 == 0 && count[current / 3] > count[current] + 1) {
                count[current / 3] = count[current] + 1;
                q.add(current / 3);
            }
            if(current % 2 == 0 && count[current / 2] > count[current] + 1) {
                count[current / 2] = count[current] + 1;
                q.add(current / 2);
            }
            if(current > 1 && count[current - 1] > count[current] + 1) {
                count[current - 1] = count[current] + 1;
                q.add(current - 1);
            }
        }
        System.out.print(count[1]);
    }
}
