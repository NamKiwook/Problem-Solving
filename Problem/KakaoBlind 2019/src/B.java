import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class B {
    public static void main(String[] args) {
        int[] a = solution(5,new int[] {2,1,2,6,2,4,3,3});
        int[] b = solution(4,new int[] {4,4,4,4,4});
        return;
    }
    public static int[] solution(int N, int[] stages) {
        int[] answer = new int[N];
        int[] stageInfo = new int[N + 1];
        ArrayList<double[]> failRate = new ArrayList<>();
        for(int i = 0; i < stages.length; i++){
            stageInfo[stages[i] - 1]++;
        }
        for(int i = 0; i < N; i++) {
            int stageTotal = 0;
            for(int j = i; j < N + 1; j++) {
                stageTotal += stageInfo[j];
            }
            if(stageTotal == 0) {
                failRate.add(new double[]{0, i});
            } else {
                failRate.add(new double[]{(double) stageInfo[i]/stageTotal, i});
            }

        }
        Collections.sort(failRate, new Comparator<double[]>() {
            @Override
            public int compare(double[] o1, double[] o2) {
                if(o1[0] != o2[0]) {
                    if(o1[0] > o2[0]) {
                        return -1;
                    } else {
                        return 1;
                    }
                } else {
                    if(o1[1] > o2[1]) {
                        return 1;
                    } else {
                        return -1;
                    }
                }
            }
        });

        for(int i = 0; i < failRate.size(); i++) {
            answer[i] = (int) failRate.get(i)[1] + 1;
        }
        return answer;
    }
}
