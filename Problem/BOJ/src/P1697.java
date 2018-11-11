import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P1697 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        int[] map = new int[100001];
        for(int i = 0; i < map.length; i++) {
            map[i] = 100000000;
        }

        Queue<Integer> position = new LinkedList<>();

        position.add(N);
        map[N] = 0;
        while(!position.isEmpty()) {
            int current = position.poll();
            if(current > 0) {
                if(map[current - 1] > map[current] + 1){
                    map[current - 1] = map[current] + 1;
                    position.add(current - 1);
                }
            }
            if(current < 100000) {
                if(map[current + 1] > map[current] + 1){
                    map[current + 1] = map[current] + 1;
                    position.add(current + 1);
                }
            }
            if(current * 2 <= 100000) {
                if(map[current * 2] > map[current] + 1){
                    map[current * 2] = map[current] + 1;
                    position.add(current * 2);
                }
            }
        }

        System.out.print(map[K]);
    }
}
