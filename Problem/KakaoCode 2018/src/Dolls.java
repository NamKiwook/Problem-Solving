import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class Dolls {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());

        int N = Integer.parseInt(st.nextToken());
        int K = Integer.parseInt(st.nextToken());

        st = new StringTokenizer(br.readLine());
        int[] an = new int[N];
        for(int i = 0; i < N; i++) {
            an[i] = Integer.parseInt(st.nextToken());
        }
        double minimum = 1e18;

        for(int i = K; i <= N; i++ ) {
            for(int j = 0; j <= N - i; j++) {
                double mean = 0;
                for(int k = 0; k < i; k++) {
                    mean += an[j+k];
                }
                mean /= i;

                double deviation = 0;
                for(int k =0; k < i; k++) {
                    deviation += (mean - an[j+k]) * (mean - an[j+k]);
                }
                deviation /= i;

                if(minimum > deviation) {
                    minimum = deviation;
                }
            }
        }

        System.out.printf("%.10f",Math.sqrt(minimum));
    }
}
