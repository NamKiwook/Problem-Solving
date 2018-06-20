import java.awt.*;
import java.util.LinkedList;
import java.util.Queue;

public class ColoringBook {
    public int[] solution(int m, int n, int[][] picture) {
        int numberOfArea = 0;
        int maxSizeOfOneArea = 0;
        int[][] areaOfPicture = new int[m][n];
        int index = 0;
        Queue<Point> queue = new LinkedList<>();
        for(int i = 0; i < m; i++) {
            for(int j = 0; j < n; j++) {
                if(areaOfPicture[i][j] == 0 && picture[i][j] != 0){
                    index++;
                    queue.add(new Point(i,j));
                    int result = floodFill(queue,areaOfPicture, picture, index,m,n);
                    if(result > maxSizeOfOneArea)
                        maxSizeOfOneArea = result;
                }
            }
        }
        numberOfArea = index;

        int[] answer = new int[2];
        answer[0] = numberOfArea;
        answer[1] = maxSizeOfOneArea;
        return answer;
    }
    public int floodFill(Queue<Point> q, int[][] area, int[][] picture, int index, int m, int n){
        int target = picture[q.peek().x][q.peek().y];
        int result = 0;
        while(!q.isEmpty()) {
            Point p = q.poll();
            if( p.x < 0 || p.x >= m || p.y < 0 || p.y >= n)
                continue;
            if(picture[p.x][p.y] != target || area[p.x][p.y] > 0)
                continue;
            area[p.x][p.y] = index;
            result++;
            q.add(new Point(p.x+1,p.y));
            q.add(new Point(p.x-1,p.y));
            q.add(new Point(p.x,p.y+1));
            q.add(new Point(p.x,p.y-1));
        }
        return result;
    }
}
