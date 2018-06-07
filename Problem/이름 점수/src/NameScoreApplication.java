import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class NameScoreApplication {
    public static void main (String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        br.readLine();
        StringTokenizer st = new StringTokenizer(br.readLine());

        System.out.print(NameScore.calcScore(st.nextToken()));
    }
}
class NameScore {
    public static int calcScore(String name) {
        int score = 0;
        for(int i = 0; i < name.length(); i++ ) {
            score += name.charAt(i) - 'A' + 1;
        }
        return score;
    }
}