import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;
import java.util.TreeMap;

public class QuestApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Quest quest = new Quest();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());

        for(int i = 0; i < N; i++) {
            quest.inputQuest(Integer.parseInt(st.nextToken()));
        }

        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            if(Integer.parseInt(st.nextToken()) == 1) {
                quest.inputQuest(Integer.parseInt(st.nextToken()));
            } else {
                System.out.println(quest.numberRequire(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
    }

}
}
class Quest {
    public void inputQuest(int index) {
        tm.put(index,true);
    }

    public int numberRequire(int L, int R) {
        int length = tm.subMap(tm.ceilingKey(L),true,tm.floorKey(R),true).size();
        return (R-L+1) - (length);
    }
}
