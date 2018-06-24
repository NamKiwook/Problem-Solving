public class WalkerHeaven {
   int MOD = 20170805;
   public int solution(int m, int n, int[][] cityMap) {
       int[][] h = new int[m][n];
       int[][] v = new int[m][n];
       h[0][0] = 1;
       v[0][0] = 1;
       for(int i = 1; i < m + n - 1; i++){
           for(int j =0; j < m; j++) {
               int x = i - j;
               int y = j;

               if(x < 0 || x >= n)
                   continue;

               if(cityMap[y][x] == 1){
                   v[y][x] = 0;
                   h[y][x] = 0;
                   continue;
               }
               if(y == 0) {
                   h[y][x] = h[y][x - 1];
                   v[y][x] = 0;
               } else if(x == 0) {
                   v[y][x] = v[y - 1][x];
                   h[y][x] = 0;
               } else {
                    if(cityMap[y-1][x] == 2) {
                       v[y][x] = v[y - 1][x];
                   }else {
                       v[y][x] = (v[y - 1][x] + h[y - 1][x]) % MOD;
                   }
                   if(cityMap[y][x-1] == 2) {
                       h[y][x] = h[y][x-1];
                   } else {
                       h[y][x] = (v[y][x-1] + h[y][x-1]) % MOD;
                   }

               }
           }
       }

        int answer = (v[m-1][n-1] + h[m-1][n-1]) % MOD;
        return answer;
    }
}
