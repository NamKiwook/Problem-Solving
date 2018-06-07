import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.StringTokenizer;

public class APC2017Application {
    public static void main (String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());

        APC2017 apc2017 = new APC2017();
        int N = Integer.parseInt(st.nextToken());

        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            apc2017.inputScore(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }

        System.out.print(apc2017.calcRank());
    }
}
class APC2017 {
    private ArrayList<int[]> inputData = new ArrayList<>();
    private int count = 1;

    public void inputScore(int S, int C, int L) {
        inputData.add(new int[]{S, C, L, count++});
    }

    public int calcRank() {
        Collections.sort(inputData, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                if (o1[0] > o2[0])
                    return -1;
                else if (o1[0] < o2[0])
                    return 1;
                else {
                    if (o1[1] > o2[1])
                        return 1;
                    else if (o1[1] < o2[1])
                        return -1;
                    else {
                        if (o1[2] > o2[2])
                            return 1;
                        else if (o1[2] < o2[2])
                            return -1;
                        else
                            return 0;
                    }
                }
            }
        });
        return inputData.get(0)[3];
    }
}
