import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P3055 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int R = Integer.parseInt(st.nextToken());
        int C = Integer.parseInt(st.nextToken());

        Map init = new Map(R,C);
        for(int i = 0; i < R; i++){
            init.map[i] = br.readLine().toCharArray();
            for(int j = 0; j < C; j++) {
                if(init.map[i][j] == 'S') {
                    init.S = new Point(i,j);
                }
            }
        }

        Queue<Map> queue = new LinkedList();
        queue.add(init);
        Map result = null;
        while(!queue.isEmpty() && result == null) {
            Map current = queue.poll();
            current.overflow();

            if(current.S.x > 0) {
                if(current.map[current.S.x - 1][current.S.y] == '.') {
                    Map nextMap = current.deepCopy();
                    nextMap.move(new Point(nextMap.S.x - 1, nextMap.S.y));
                    queue.add(nextMap);
                }
                if(current.map[current.S.x - 1][current.S.y] == 'D') {
                    current.move(new Point(current.S.x - 1, current.S.y));
                    result = current;
                    continue;
                }
            }

            if(current.S.x < R - 1) {
                if(current.map[current.S.x + 1][current.S.y] == '.') {
                    Map nextMap = current.deepCopy();
                    nextMap.move(new Point(nextMap.S.x + 1, nextMap.S.y));
                    queue.add(nextMap);
                }
                if(current.map[current.S.x + 1][current.S.y] == 'D') {
                    current.move(new Point(current.S.x + 1, current.S.y));
                    result = current;
                    continue;
                }
            }

            if(current.S.y > 0) {
                if(current.map[current.S.x][current.S.y - 1] == '.') {
                    Map nextMap = current.deepCopy();
                    nextMap.move(new Point(nextMap.S.x, nextMap.S.y - 1));
                    queue.add(nextMap);
                }
                if(current.map[current.S.x][current.S.y - 1] == 'D') {
                    current.move(new Point(current.S.x, current.S.y- 1));
                    result = current;
                    continue;
                }
            }

            if(current.S.y < C - 1) {
                if(current.map[current.S.x][current.S.y + 1] == '.') {
                    Map nextMap = current.deepCopy();
                    nextMap.move(new Point(nextMap.S.x, nextMap.S.y + 1));
                    queue.add(nextMap);
                }
                if(current.map[current.S.x][current.S.y + 1] == 'D') {
                    current.move(new Point(current.S.x, current.S.y + 1));
                    result = current;
                    continue;
                }
            }
        }

        if(result == null) {
            System.out.println("KAKTUS");
        } else {
            System.out.println(result.length);
        }
    }
}
class Map {
    char[][] map;
    int length = 0;
    Point S;
    public Map(int n, int m) {
        map = new char[n][m];
    }

    public void move(Point S) {
        map[this.S.x][this.S.y] = 'V';
        map[S.x][S.y] = 'S';
        this.S = S;
        length++;
    }

    public void overflow() {
        char[][] tmp = new char[map.length][map[0].length];
        for(int i = 0; i <  map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(map[i][j] == '*') {
                    if(i > 0) {
                        if(map[i-1][j] == '.' || map[i-1][j] == 'V') {
                            tmp[i-1][j] = '*';
                        }
                    }
                    if(i <  map.length - 1) {
                        if(map[i+1][j] == '.' || map[i+1][j] == 'V') {
                            tmp[i+1][j] = '*';
                        }
                    }
                    if(j > 0) {
                        if(map[i][j - 1] == '.' || map[i][j-1] == 'V') {
                            tmp[i][j - 1] = '*';
                        }
                    }
                    if(j < map[i].length - 1) {
                        if(map[i][j+1] == '.' || map[i][j+1] == 'V') {
                            tmp[i][j+1] = '*';
                        }
                    }
                }
            }
        }
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                if(tmp[i][j] == '*') map[i][j] = '*';
            }
        }
    }
    public Map deepCopy() {
        Map tmp = new Map(map.length,map[0].length);
        for(int i = 0; i < map.length; i++) {
            for(int j = 0; j < map[i].length; j++) {
                tmp.map[i][j] = map[i][j];
            }
        }
        tmp.S = new Point(S.x,S.y);
        tmp.length = length;
        return tmp;
    }
}