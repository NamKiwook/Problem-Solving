import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class GambleApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Gamble gamble = new Gamble(st.nextToken());
        st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        for(int i = 0 ; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gamble.changeStirng(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        char[] string = gamble.getString();
        for(int i = 0; i < string.length; i++) {
            System.out.print(string[i]);

        }
    }
}
class Gamble {
    char[] string;
    public Gamble(String input) {
        string = input.toCharArray();
    }
    public void changeStirng(int A, int B) {
        char swapTemp = string[A];
        string[A] = string[B];
        string[B] = swapTemp;
    }
    public char[] getString() {
        return string;
    }
}
