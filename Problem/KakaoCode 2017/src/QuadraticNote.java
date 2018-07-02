//오답 다시 풀어야함.
public class QuadraticNote {
    int answer = 0;
    public int solution(int n) {
        answer = 0;
        int length = checkLength(n);
        note(n, 0, 0, length, 1);
        return answer;
    }

    public int checkLength(int n) {
        int length = 0;
        long h = 5;
        while(h <= n) {
            length++;
            h = (long) Math.pow(3,length) + (2 * length);
        }
        return length - 1;
    }

    public void note(int n, int usingPlus, int usingStar, int length, long s) {
        if(usingStar == length) {
            System.out.println(s);
            if(s == n && usingPlus == 2 * length) {
                answer++;
            }
            return;
        }
        if(usingStar == length - 1) {
            note(n, usingPlus +  (usingStar+1) * 2 - usingPlus, usingStar + 1, length, s * 3 +  (usingStar+1) * 2 - usingPlus);
        } else {
            for (int i = 0; i <= (usingStar + 1) * 2 - usingPlus; i++) {
                if (s * 3 + i > n)
                    break;
                note(n, usingPlus + i, usingStar + 1, length, s * 3 + i);
            }
        }

        return;
    }
}
