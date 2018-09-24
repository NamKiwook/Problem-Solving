import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;

public class C {
    public static void main(String[] args) {
        solution(new String[][] {{"100","ryan","music","2"},{"200","apeach","math","2"},{"300","tube","computer","3"},{"400","con","computer","4"},{"500","muzi","music","3"},{"600","apeach","music","2"}});
    }

    public static int solution(String[][] relation) {
        Queue<int[]> numberCase = new LinkedList<>();
        int answer = 0;
        boolean[] ans = new boolean[1000000000];
        for(int i = 0; i < relation[0].length; i++) {
            numberCase.add(new int[] {i});
        }


        while(!numberCase.isEmpty()) {
            int[] currentCase = numberCase.poll();
            String[][] arr = new String[relation.length][currentCase.length];
            boolean isCandidate = true;



            for(int i = 0; i < relation.length; i++) {
                String[] tmpCandi = new String[currentCase.length];
                for(int j = 0; j < currentCase.length; j++) {
                    tmpCandi[j] = relation[i][currentCase[j]];
                }
                for(int j = 0; j < arr.length; j++) {
                    boolean tmp = false;
                    for(int k = 0; k < arr[j].length; k++) {
                        if(!tmpCandi[k].equals(arr[j][k])) {
                            tmp = true;
                        }
                    }
                    isCandidate = isCandidate && tmp;
                }
                arr[i] = tmpCandi;
            }


            if(isCandidate) {
                int j = 1;
                for(int i = 0; i < currentCase.length; i++) {
                    i += currentCase[i] * currentCase[i];
                }
                if(ans[i] )
                answer++;
            } else {
                int[] addCase = new int[currentCase.length + 1];
                for(int i = 0; i < currentCase.length; i++) {
                    addCase[i] = currentCase[i];
                }
                for(int i = currentCase[currentCase.length - 1] + 1; i < relation[0].length; i++) {
                    addCase[currentCase.length] = i;
                    numberCase.add(addCase.clone());
                }
            }
        }
        return answer;
    }
}
