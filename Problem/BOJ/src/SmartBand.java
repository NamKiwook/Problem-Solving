import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class SmartBand {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int age = Integer.parseInt(br.readLine());
        int maxBeat = 220 - age;
        int[] beat = new int[6];
        while (br.ready()) {
            int beatPerSec = Integer.parseInt(br.readLine());
            double beatPerMax = (double) beatPerSec / maxBeat * 100;
            if (beatPerMax >= 90) {
                beat[0] += 1;
            } else if (beatPerMax >= 80) {
                beat[1] += 1;
            } else if (beatPerMax >= 75) {
                beat[2] += 1;
            } else if (beatPerMax >= 68) {
                beat[3] += 1;
            } else if (beatPerMax >= 60) {
                beat[4] += 1;
            } else {
                beat[5] += 1;
            }
        }
        System.out.printf("%d %d %d %d %d %d\n", beat[0], beat[1], beat[2], beat[3], beat[4], beat[5]);
    }
}
