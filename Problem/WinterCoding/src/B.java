import java.awt.*;

public class B {
    static public void main(String[] args) {
        System.out.print(solution("LULLLLLLU"));
    }
    public static int solution(String dirs) {
        int answer = 0;
        Point curPoint = new Point(5,5);
        boolean[][][] move = new boolean[11][11][4];
        for(int i = 0; i < dirs.length(); i++) {
            char curDir = dirs.charAt(i);
            if(curDir == 'U') {
                if(curPoint.y < 10) {
                    move[curPoint.x][curPoint.y][0] = true;
                    move[curPoint.x][curPoint.y + 1][2] = true;
                    curPoint.y++;
                }
            }
            if(curDir == 'R') {
                if(curPoint.x < 10) {
                    move[curPoint.x][curPoint.y][1] = true;
                    move[curPoint.x + 1][curPoint.y][3] = true;
                    curPoint.x++;
                }
            }
            if(curDir == 'D') {
                if(curPoint.y > 0) {
                    move[curPoint.x][curPoint.y][2] = true;
                    move[curPoint.x][curPoint.y - 1][0] = true;
                    curPoint.y--;
                }
            }
            if(curDir == 'L') {
                if(curPoint.x > 0) {
                    move[curPoint.x][curPoint.y][3] = true;
                    move[curPoint.x - 1][curPoint.y][1] = true;
                    curPoint.x--;
                }
            }
        }

        for(int i = 0; i < 11; i++) {
            for(int j = 0; j < 11; j++) {
                for(int k = 0; k < 4; k++) {
                    if(move[i][j][k]) answer++;
                }
            }
        }
        answer /= 2;
        return answer;
    }
}
