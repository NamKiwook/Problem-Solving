public class NGameApplication {
    public static void main(String[] args) {
        NGame s = new NGame();
        System.out.println(s.solution(2,4,2,1));
        System.out.println(s.solution(16,16,2,1));
        System.out.println(s.solution(16,16,2,2));

    }
}
class NGame {
    public String solution(int n, int t, int m, int p) {
        String answer = "";
        int total = (t - 1) * m + p;
        int currentNumber = 0;
        for(int i = 1; i <= total;) {
            String stringNumber = changeNotation(currentNumber++, n);
            for(int j = 0; j < stringNumber.length(); j++) {
                if(i > total) break;
                if((i - p) % m == 0) {
                    answer += stringNumber.charAt(j);
                }
                i++;
            }

        }
        return answer;
    }

    public String changeNotation(int number, int notation) {
        String changedNumber = "";
        char[] numberArray = {'0','1','2','3','4','5','6','7','8','9','A','B','C','D','E','F'};
        if(number == 0) return "0";
        while(number > 0) {
            changedNumber = numberArray[number % notation] + changedNumber;
            number /= notation;
        }
        return changedNumber;
    }
}