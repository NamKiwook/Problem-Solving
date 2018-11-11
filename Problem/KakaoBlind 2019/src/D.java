import java.util.Arrays;

public class D {
    public static void main(String[] args) {
        System.out.println(solution(new int[]{3,1,2},5));
        return;
    }
    public static int solution(int[] food_times, long k) {
        int foodLength = food_times.length;
        int[] sortedTimes = food_times.clone();
        Arrays.sort(sortedTimes);
        for(long i = 0; i < k;) {
            if(foodLength < k) {
                i += foodLength;
            } else {
                i++;
            }
        }

        int answer = 0;
        return answer;
    }
}
