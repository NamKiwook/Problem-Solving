import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class QuestApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        ArrayList<int[]> input = new ArrayList<>();
        int N = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        for (int i = 0; i < N; i++) {
            input.add(new int[]{Integer.parseInt(st.nextToken()), 1});
        }
        st = new StringTokenizer(br.readLine());
        int M = Integer.parseInt(st.nextToken());
        ArrayList<String> query = new ArrayList<>();
        for(int i = 0; i < M; i++) {
            query.add(br.readLine());
            st = new StringTokenizer(query.get(i));
            if(Integer.parseInt(st.nextToken()) == 1) {
                input.add(new int[]{Integer.parseInt(st.nextToken()), 0});
            }
        }
        Collections.sort(input, new Comparator<int[]>() {
            @Override
            public int compare(int[] o1, int[] o2) {
                return o1[0] - o2[0];
            }
        });
        int inputSize = input.size();
        Quest quest = new Quest(inputSize);
        for(int i = 0; i < inputSize; i++) {
            quest.inputQuest(input.get(i)[0], i + 1, input.get(i)[1]);
        }
        int querySize = query.size();
        for(int i = 0; i < querySize; i++) {
            st = new StringTokenizer(query.get(i));
            if(Integer.parseInt(st.nextToken()) == 1) {
                quest.updateTree(Integer.parseInt(st.nextToken()));
            } else {
                System.out.println(quest.rangeQeust(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken())));
            }
        }
    }
}
class Quest {
    FenwickTree ft;
    int[] inputArr;
    public Quest(int n){
        ft = new FenwickTree(n);
        inputArr = new int[n+1];
    }

    public void inputQuest(int index, int count, int isExcuted) {
        inputArr[count] = index;
        if(isExcuted == 1) {
            ft.update(count,isExcuted);
        }
    }

    public void updateTree(int index) {
        int target = binarySearch(inputArr,index,true);
        ft.update(target, 1);
    }

    public int rangeQeust(int left, int right) {
        int targetLeft = binarySearch(inputArr,left,true);
        int targetRight = binarySearch(inputArr,right,false);
        return (right-left + 1) - ft.sum(targetLeft,targetRight);
    }

    public int binarySearch(int[] sortedArr, int search, boolean isCeiling) {
        int min = 1;
        int max = sortedArr.length - 1;
        int mid = (min + max) / 2;
        while(min <= max) {
            mid = (min + max) / 2;
            if(sortedArr[mid] == search){
                return mid;
            } else if(sortedArr[mid] < search) {
                min = mid + 1;
            } else {
                max = mid - 1;
            }
        }
        if(sortedArr[mid] < search) {
            if(isCeiling)
                return mid+1;
            else
                return mid;
        } else {
            if(isCeiling)
                return mid;
            else
                return mid-1;
        }
    }

}
class FenwickTree {
    private int[] tree;

    public FenwickTree (int n) {
        tree = new int[n+1];
    }
    public int sum(int index) {
        int result = 0;
        while(index > 0) {
            result += tree[index];
            index -= (index & -index);
        }
        return result;
    }
    public int sum(int left, int right) {
        if(left > right)
            return 0;

        return sum(right) - sum(left - 1);
    }

    public void update(int index, int diff) {
        while(index < tree.length) {
            tree[index] += diff;
            index += (index & -index);
        }
    }
}

