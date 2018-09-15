import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

public class CompressionApplication {
    public static void main(String[] args) {
        Compression c  = new Compression();
        int[] a = c.solution("KAKAO");
        int[] b = c.solution("TOBEORNOTTOBEORTOBEORNOT");
        int[] x = c.solution("ABABABABABABABAB");
        return;
    }
}
class Compression {
    public int[] solution(String msg) {
        ArrayList<Integer> answer = new ArrayList<>();
        ArrayList<String> dic = new ArrayList<>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O","P","Q","R","S","T","U","V","W","X","Y","Z"));
        Queue<Character> msgQ = new LinkedList<>();
        for(int i = 0; i < msg.length(); i++) {
            msgQ.add(msg.charAt(i));
        }
        while(!msgQ.isEmpty()) {
            String w = String.valueOf(msgQ.peek());
            int index = 0;
            while(dic.contains(w)) {
                msgQ.poll();
                index = dic.indexOf(w) + 1;
                w += msgQ.peek();
            }
            answer.add(index);
            dic.add(w);
        }
        int[] ans = new int[answer.size()];
        for(int i = 0; i < answer.size(); i++) {
            ans[i] = answer.get(i);
        }
        return ans;
    }
}