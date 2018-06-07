import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DrainageWorkApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int x = Integer.parseInt(st.nextToken());
        DrainageWork dw = new DrainageWork(x);
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            dw.inputPipe(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        System.out.print(dw.getResult());
    }
}
class DrainageWork {
    int[] DP;
    int wantLength;
    public DrainageWork(int wantLength) {
        this.wantLength = wantLength;
        DP = new int[wantLength+1];
    }
    public void inputPipe(int pipeLength, int number) {
        int[] currentDP = new int[wantLength+1];
        for(int i = 0; i <= number; i++) {
            if(i * pipeLength <= wantLength) {
                currentDP[i * pipeLength] = 1;
            } else {
                break;
            }
        }
        for(int i = 1; i < wantLength+1; i++) {
            if(DP[i] > 0) {
                for(int j = 0; j <= number; j++) {
                    if(i + j*pipeLength <= wantLength) {
                        currentDP[i + j * pipeLength] += DP[i];
                    } else {
                        break;
                    }
                }
            }
        }
        DP = currentDP;
    }
    public int getResult() {
        return DP[wantLength];
    }
}