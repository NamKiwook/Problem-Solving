import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class BalloonFactoryApplication {
    public static void main(String[] arg) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        BalloonFactory bf = new BalloonFactory(N,M);
        st = new StringTokenizer(br.readLine());
        for(int i = 0; i < N; i++) {
            bf.inputStaff(Integer.parseInt(st.nextToken()));
        }
        System.out.print(bf.calc());
    }
}
class BalloonFactory {
    int numberStaff, needBalloon;
    int[] staff;
    int inputCount = 0;
    public BalloonFactory(int N, int M) {
        numberStaff = N;
        needBalloon = M;
        staff = new int[N];
    }
    public void inputStaff(int input) {
        staff[inputCount++] = input;
    }
    public long calc() {
        long numberBalloon;
        long min = 0;
        long max = (long) staff[0] * needBalloon;
        long cnt = (max+min) / 2;
        while(max > min) {
            numberBalloon = 0;
            for(int i = 0; i < staff.length; i++) {
                numberBalloon += cnt/staff[i];
            }
            if(numberBalloon == needBalloon) {
                break;
            } else if(numberBalloon > needBalloon) {
                max = cnt - 1;
            } else if(numberBalloon < needBalloon) {
                min = cnt + 1;
            }
            cnt = (max + min)/ 2;
        }
        numberBalloon = 0;
        for(int i = 0; i < staff.length; i++) {
            numberBalloon += cnt/staff[i];
        }
        long currentBalloon = numberBalloon;
        if(numberBalloon >= needBalloon) {
            while(numberBalloon == currentBalloon) {
                currentBalloon = 0;
                cnt--;
                for(int i = 0; i < staff.length; i++) {
                    currentBalloon += cnt/staff[i];
                }
            }
            return cnt + 1;
        } else {
            while(numberBalloon == currentBalloon) {
                currentBalloon = 0;
                cnt++;
                for(int i = 0; i < staff.length; i++) {
                    currentBalloon += cnt/staff[i];
                }
            }
            return cnt;
        }
    }
}