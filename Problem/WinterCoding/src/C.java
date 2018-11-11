public class C {
    static public void main(String[] args) {
        System.out.print(solution(new int[]{1,2,3,5}));
    }
    public static int solution(int[] cookie) {
        int answer = 0;
        int maxC = 0;
        for(int window = cookie.length; window > 1; window--) {
            for(int startPosition = 0; cookie.length - window >= startPosition; startPosition++) {
                int[] son1 = new int[2];
                son1[0] = 0;
                son1[1] = startPosition;
                int[] son2 = new int[2];
                son2[0] = 0;
                son2[1] = startPosition + window - 1;
                for(int i = 0; i < window; i++) {
                    if(son1[0] >= son2[0]) {
                        son2[0] += cookie[son2[1]--];
                    } else {
                        son1[0] += cookie[son1[1]++];
                    }
                }
                if(son1[0] == son2[0]) {
                    if(answer < son1[0]) answer = son1[0];
                }
            }
            if(answer > 0) maxC++;
            if(answer > 0 && maxC > 2) break;
        }
        return answer;
    }
}
