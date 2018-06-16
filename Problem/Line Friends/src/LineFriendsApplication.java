import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class LineFriendsApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        LineFriends lf = new LineFriends();

        int N = Integer.parseInt(st.nextToken());
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            lf.inputLine(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
    }
}
class LineFriends {
    ArrayList<int[]> lines = new ArrayList<>();
    ArrayList<int[]> index = new ArrayList<>();
    public void inputLine(int left, int right) {
        lines.add(new int[]{left,right});
    }
    public void prepare() {
        index.addAll(lines);
        TreeMap<Integer,int[]> oneLength = new TreeMap<>();
        setLine("right");
        for(int i = 0; i < lines.size(); i++) {
            for(int j = lines.get(i)[0]; j < lines.get(i-1)[0]; j++) {

            }
        }
    }
    private void  setLine(String Standard){
        if(Standard == "left") {
            Collections.sort(lines, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[0] - o1[0];
                }
            });
        } else {
            Collections.sort(lines, new Comparator<int[]>() {
                @Override
                public int compare(int[] o1, int[] o2) {
                    return o2[1] - o1[1];
                }
            });
        }
    }
}
