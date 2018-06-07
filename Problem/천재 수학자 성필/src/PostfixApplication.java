import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class PostfixApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Postfix postfix = new Postfix();
        char[] input = st.nextToken().toCharArray();
        for(int i = 0; i < input.length; i++) {
            postfix.inputFormula(input[i]);
        }
        System.out.print(postfix.getResult());
    }
}
class Postfix {
    private int[] stack = new int[100];
    private int top = 0;
    private int pop() {
        return stack[--top];
    }
    private void push(int input) {
        stack[top++] = input;
    }

    public void inputFormula(char input) {
        if(Character.isDigit(input)) {
            push(input - '0');
        } else if(input == '+') {
            int a = pop();
            int b = pop();
            push(a+b);
        } else if(input == '-') {
            int a = pop();
            int b = pop();
            push(b-a);
        } else if(input == '*') {
            int a = pop();
            int b = pop();
            push(a*b);
        } else if(input == '/') {
            int a = pop();
            int b = pop();
            push(b/a);
        }
    }

    public int getResult() {
        return pop();
    }
}
