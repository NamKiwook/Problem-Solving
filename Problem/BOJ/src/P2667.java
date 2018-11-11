import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class P2667 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int[][] board = new int[N][N];
        boolean[][] isVisit = new boolean[N][N];
        for(int i = 0; i < N; i++) {
            String line = br.readLine();
            for(int j = 0; j < N; j++) {
                board[i][j] = line.charAt(j) - '0';
                isVisit[i][j] = false;
            }
        }

        Queue<Point> complex = new LinkedList<>();
        PriorityQueue<Integer> complexSize = new PriorityQueue<>();
        for(int i = 0; i < N; i++) {
            for(int j = 0; j < N; j++) {
                if(!isVisit[i][j] && board[i][j] == 1) {
                    complex.add(new Point(i,j));
                    int size = 1;
                    isVisit[i][j] = true;
                    while(!complex.isEmpty()) {
                        Point current = complex.poll();
                        if(current.x > 0){
                            if(!isVisit[current.x - 1][current.y] && board[current.x - 1][current.y] == 1) {
                                size++;
                                isVisit[current.x - 1][current.y] = true;
                                complex.add(new Point(current.x - 1, current.y));
                            }
                        }
                        if(current.y > 0){
                            if(!isVisit[current.x][current.y - 1] && board[current.x][current.y - 1] == 1) {
                                size++;
                                isVisit[current.x][current.y - 1] = true;
                                complex.add(new Point(current.x, current.y - 1));
                            }
                        }
                        if(current.x < N - 1){
                            if(!isVisit[current.x + 1][current.y] && board[current.x + 1][current.y] == 1) {
                                size++;
                                isVisit[current.x + 1][current.y] = true;
                                complex.add(new Point(current.x + 1, current.y));
                            }
                        }
                        if(current.y < N - 1){
                            if(!isVisit[current.x][current.y + 1] && board[current.x][current.y + 1] == 1) {
                                size++;
                                isVisit[current.x][current.y + 1] = true;
                                complex.add(new Point(current.x, current.y + 1));
                            }
                        }
                    }
                    complexSize.add(size);
                }
            }
        }
        System.out.println(complexSize.size());
        while(!complexSize.isEmpty()){
            System.out.println(complexSize.poll());
        }
    }
}
