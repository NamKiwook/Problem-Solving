import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class OverflowModularApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int modular = Integer.parseInt(st.nextToken());
        int result = 1;
        OverflowModular om = new OverflowModular(modular);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            result = om.multipleModular(result, Integer.parseInt(st.nextToken()));
        }
        System.out.print(result);
    }
}
class OverflowModular {
    int modular;
    public OverflowModular(int modular) {
        this.modular = modular;
    }
    public int multipleModular(int A, int B) {
        int modularA = A % modular;
        int modularB = B % modular;
        long multiple = (long)modularA * modularB;
        long result = multiple % modular;
        return (int) result;
    }
}