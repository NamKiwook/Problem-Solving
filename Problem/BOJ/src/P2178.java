import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P2178 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n = Integer.parseInt(st.nextToken());
        int m = Integer.parseInt(st.nextToken());

        int[][] miro = new int[n][m];
        int[][] miroCount = new int[n][m];
        for(int i = 0; i < n; i++) {
            String line = br.readLine();
            for(int j = 0; j < m; j++) {
                miro[i][j] = line.charAt(j) - '0';
                if(miro[i][j] == 0) miroCount[i][j] = -1;
                else miroCount[i][j] = n * m + 1;
            }
        }

        Queue<Point> q = new LinkedList<>();
        q.add(new Point(0,0));
        miroCount[0][0] =  1;
        while(!q.isEmpty()) {
            Point current = q.poll();
            if(current.x > 0) {
                if(miro[current.x - 1][current.y] == 1 && miroCount[current.x - 1][current.y] > miroCount[current.x][current.y] + 1) {
                    miroCount[current.x - 1][current.y] = miroCount[current.x][current.y] + 1;
                    q.add(new Point(current.x - 1, current.y));
                }
            }
            if(current.y > 0) {
                if(miro[current.x][current.y - 1] == 1 && miroCount[current.x][current.y - 1] > miroCount[current.x][current.y] + 1) {
                    miroCount[current.x][current.y - 1] = miroCount[current.x][current.y] + 1;
                    q.add(new Point(current.x, current.y - 1));
                }
            }
            if(current.x < n - 1) {
                if(miro[current.x + 1][current.y] == 1 && miroCount[current.x + 1][current.y] > miroCount[current.x][current.y] + 1) {
                    miroCount[current.x + 1][current.y] = miroCount[current.x][current.y] + 1;
                    q.add(new Point(current.x + 1, current.y));
                }
            }
            if(current.y < m - 1) {
                if(miro[current.x][current.y + 1] == 1 && miroCount[current.x][current.y + 1] > miroCount[current.x][current.y] + 1) {
                    miroCount[current.x][current.y + 1] = miroCount[current.x][current.y] + 1;
                    q.add(new Point(current.x, current.y + 1));
                }
            }
        }
        System.out.print(miroCount[n-1][m-1]);
    }
}
