public class A3 {
    public static void main(String[] args) {
        Solution3 s = new Solution3();
        System.out.print(s.solution(3,new int[][] {{0,0,1},{0,0,1},{0,1,0}}));
    }
}


class Solution3 {
    int[][] solution(int n, int[][] signs){
        int[][] answer = new int[n][n];
        for(int i = 0; i < n; i++) {
            int[][] temp = new int[n][n];
            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    for(int l = 0; l < n; l++) {
                        if(answer[j][l]*signs[l][k] + answer[j][k] + signs[j][k]> 0) {
                            temp[j][k] = 1;
                            break;
                        }
                    }
                }
            }

            int equalNumber = 0;

            for(int j = 0; j < n; j++) {
                for(int k = 0; k < n; k++) {
                    if(answer[j][k] == temp[j][k]) equalNumber++;
                    answer[j][k] = temp[j][k];
                }
            }

            if(equalNumber == n*n) break;
        }
        return answer;
    }
}
