import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class P9095 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int[] table = new int[11];
        int n = Integer.parseInt(br.readLine());

        table[1] = 1;
        table[2] = 2;
        table[3] = 4;
        for(int i = 4; i <= 10; i++) {
            table[i] = table[i - 1] + table[i - 2] + table[i - 3];
        }
        for(int i = 0; i < n; i++) {
            int k = Integer.parseInt(br.readLine());
            System.out.println(table[k]);
        }
    }
}
