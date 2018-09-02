
public class A1 {
    public static void main(String[] args) {
        Solution1 s = new Solution1();
        System.out.print(s.solution(1,100));
    }
}


class Solution1 {
    public int solution(int n, int m) {
        int answer = 0;
        for(int i = n; i <= m; i++) {
            char[] input = Integer.toString(i).toCharArray();
            boolean isPalindrome = true;
            for(int j = 0; j < input.length / 2; j++){
                if(input[j] != input[input.length - 1 - j]) {
                    isPalindrome = false;
                    break;
                }
            }
            if(isPalindrome) answer++;
        }
        return answer;
    }
}
