import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Bracket {
    static int Answer;

    public static void main(String args[]) throws Exception	{
		/*
		   The method below means that the program will read from input.txt, instead of standard(keyboard) input.
		   To test your program, you may save input data in input.txt file,
		   and call below method to read from the file when using nextInt() method.
		   You may remove the comment symbols(//) in the below statement and use it.
		   But before submission, you must remove the freopen function or rewrite comment symbols(//).
		 */

		/*
		   Make new scanner from standard input System.in, and read data.
		 */

        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        //Scanner sc = new Scanner(new FileInputStream("input.txt"));
        int T = Integer.parseInt(br.readLine());

        for(int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            String input = br.readLine();
            /////////////////////////////////////////////////////////////////////////////////////////////
            int[] stack = new int[input.length()];
            int top = 0;
            int tmpCnt = 0;
            for(int i = 0; i < input.length(); i++) {
                if(input.charAt(i) == '(' ||input.charAt(i) == '{' ||input.charAt(i) == '[') {
                    stack[top++] = input.charAt(i);
                } else if(input.charAt(i) == ']' || input.charAt(i) == '}' || input.charAt(i) == ')') {
                    if(top == 0) {
                        tmpCnt = 0;
                        top = 0;
                    } else if(stack[top - 1] == input.charAt(i) - 1 || stack[top - 1] == input.charAt(i) - 2) {
                        tmpCnt++;
                        top--;
                    } else {
                        tmpCnt = 0;
                        top = 0;
                    }
                }
                if(Answer < tmpCnt*2) {
                    Answer = tmpCnt * 2;
                }
            }


            /////////////////////////////////////////////////////////////////////////////////////////////
            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
}
