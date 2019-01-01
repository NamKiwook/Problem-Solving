import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class P9019 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(br.readLine());
        Command command = new Command();
        for(int i = 0; i < T; i++) {
            StringTokenizer st = new StringTokenizer(br.readLine());
            int A = Integer.parseInt(st.nextToken());
            int B = Integer.parseInt(st.nextToken());
            String[] commands = new String[100000];
            Queue<Integer> queue = new LinkedList<>();
            commands[A] = "";
            queue.add(A);
            while(!queue.isEmpty() && commands[B] == null) {
                int current = queue.poll();
                if(commands[command.D(current)] == null) {
                    commands[command.D(current)] = commands[current] + "D";
                    queue.add(command.D(current));
                }
                if(commands[command.L(current)] == null) {
                    commands[command.L(current)] = commands[current] + "L";
                    queue.add(command.L(current));
                }
                if(commands[command.R(current)] == null) {
                    commands[command.R(current)] = commands[current] + "R";
                    queue.add(command.R(current));
                }
                if(commands[command.S(current)] == null) {
                    commands[command.S(current)] = commands[current] + "S";
                    queue.add(command.S(current));
                }
            }
            System.out.println(commands[B]);
        }
    }

}
class Command {
    public int D(int input) {
        return input * 2 % 10000;
    }
    public int S(int input) {
        return input == 0 ? 9999 : input - 1;
    }
    public int L(int input) {
        int l = input / 1000;
        return (input - l * 1000) * 10 + l;
    }
    public int R(int input) {
        int r = input % 10;
        return input / 10 + r * 1000;
    }
}