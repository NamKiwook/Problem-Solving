import java.util.Collections;
import java.util.PriorityQueue;

public class A2 {
    public static void main(String[] args) {
        Solution2 s = new Solution2();
        System.out.print(s.solution(2,new int[] {3,3,3}));
    }
}


class Solution2 {
    public int solution(int no, int[] works) {
        int result = 0;
        PriorityQueue<Integer> pq= new PriorityQueue<>(Collections.reverseOrder());
        for(int i = 0; i < works.length; i++) {
            pq.add(works[i]);
        }
        for(int i = 0; i < no; i++){
            if(pq.peek() != 0) {
                pq.add(pq.poll() - 1);
            }
        }
        while(!pq.isEmpty()) {
            result += pq.peek() * pq.poll();
        }
        // [실행] 버튼을 누르면 출력 값을 볼 수 있습니다.

        return result;
    }
}
