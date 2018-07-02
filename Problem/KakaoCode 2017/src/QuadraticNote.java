public class QuadraticNote {
    int answer = 0;
    public int solution(int n) {
        answer = 0;
        note((long) n,"*++");
        return answer;
    }

    public void note(long n, String formula) {
        long value = 0;

        for(int i = 0; i < formula.length(); i ++) {
            if(formula.charAt(i) == '*') {
                if(value == 0) {
                    value = 3;
                } else {
                    value *= 3;
                }
            } else {
                value += 1;
            }
        }

        if(value > n ) {
            return;
        } else if (value == n) {
            answer += 1;
            return;
        }
        note(n, "*" + formula + "++");
        note(n, "*+" + formula + "+");
        note(n,"*++" + formula);
        return;
    }
}
