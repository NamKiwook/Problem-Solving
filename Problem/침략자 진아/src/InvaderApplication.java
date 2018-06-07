import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class InvaderApplication {
    public static void main(String[] arg) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        Invader invader = new Invader(N,M);
        int[][] map = new int[N][M];
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            char[] input = st.nextToken().toCharArray();
            for(int j = 0 ; j < M; j++) {
                map[i][j] = input[j]-'0';
            }
        }
        invader.createMap(map);
        System.out.print(invader.calcMinimum());
    }
}
class Invader {
    int[][] map;
    public Invader(int N,int M) {
        map = new int[N][M];
    }
    public void createMap(int[][] map) {
        this.map = map;
    }
    public int calcMinimum() {
        int minimumSecond = map[0].length + map.length - 2;
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == 0) {
                    for(int k = i; k < map.length; k++) {
                        for(int l = j+1; l <map[k].length; l++) {
                            if(map[k][l] == 0) {
                                int maxSecond = 0;
                                for(int m = 0; m < map.length; m++) {
                                    for (int n = 0; n < map[0].length; n++) {
                                        if (map[m][n] == 1) {
                                            if (Math.abs(m - i) + Math.abs(j - n) >= Math.abs(m - k) + Math.abs(l - n) && Math.abs(m - k) + Math.abs(l - n) > maxSecond) {
                                                maxSecond = Math.abs(m - k) + Math.abs(l - n);
                                            } else if (Math.abs(m - i) + Math.abs(j - n) <Math.abs(m - k) + Math.abs(l - n) && Math.abs(m - i) + Math.abs(j - n) > maxSecond) {
                                                maxSecond = Math.abs(m - i) + Math.abs(j - n);
                                            }
                                        }
                                    }
                                }
                                if(minimumSecond > maxSecond) {
                                    minimumSecond = maxSecond;
                                }
                            }
                        }
                    }
                }
            }
        }
        return minimumSecond;
    }
}
