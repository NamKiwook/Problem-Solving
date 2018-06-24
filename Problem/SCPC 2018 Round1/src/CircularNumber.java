import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;

public class CircularNumber {
    static int Answer;
    static int[] ans = new int[3];
    static int[] tmp = new int[3];
    private static boolean isEnd = false;
    static int endIndex = 0;

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
        int T = Integer.parseInt(br.readLine());

        //Scanner sc = new Scanner(new FileInputStream("input.txt"));

        for(int test_case = 0; test_case < T; test_case++) {
            int n = Integer.parseInt(br.readLine());
//            int n = (int) (Math.random() * 10000);
            System.out.println("Case #"+(test_case+1));
            Answer = 0;
            ans = new int[3];
            tmp = new int[3];
            isEnd = false;

            /////////////////////////////////////////////////////////////////////////////////////////////
            calc(n,1);
            /////////////////////////////////////////////////////////////////////////////////////////////
            if(isEnd){
                System.out.print(endIndex);
                if(endIndex == 1){
                    ans[1] = 0;
                    ans[2] = 0;
                } else {
                    ans[2] = 0;
                }
                Arrays.sort(ans);
                for(int i = 0; i < 3; i++) {
                    if(ans[2 - i] > 0) {
                        System.out.print(" " + ans[2 - i]);
                    }
                }
            } else if(tmp[0] > 0) {
                System.out.print(tmp.length);
                Arrays.sort(tmp);
                for(int i = 0; i < tmp.length; i++) {
                    System.out.print(" "+tmp[tmp.length - 1- i]);
                }
            } else {
                System.out.print(0);
            }
            // Print the answer to standard output(screen).
            System.out.println();
        }
    }
    public static void calc(int n, int index) {
        int inputLength= (int) Math.log10(n);
        if(isEnd)
            return;
        if(isPalindrome(n)) {
            ans[index - 1] = n;
            if(index == 2 || index == 1){
                endIndex = index;
                isEnd = true;
                return;
            }
            tmp = ans.clone();
        }
        if(index == 3) {
            return;
        }
        if(inputLength >= 3) {
            for(int i = 1; i <= 9; i++) {
                for(int j = 0; j <= 9; j++){
                    if(i * 1001 + j * 110 < n) {
                        if(isEnd)
                            return;
                        ans[index - 1] = i * 1001 + j * 110;
                        calc(n - (i * 1001 + j * 110), index+1);
                    }
                }
            }
        }
        if(inputLength >= 2) {
            for(int i = 1; i <= 9; i++) {
                for(int j = 0; j <= 9; j++){
                    if(i * 101 + j * 10 < n) {
                        if(isEnd)
                            return;
                        ans[index - 1] = i * 101 + j * 10;
                        calc(n - (i * 101 + j * 10), index+1);
                    }
                }
            }
        }
        if(inputLength >= 1) {
            for(int i = 1; i <= 9; i++) {
                if(i * 11 < n) {
                    if(isEnd)
                        return;
                    ans[index - 1] = i * 11;
                    calc(n - (i * 11), index+1);
                }
            }
        }
        if(inputLength >= 0) {
            for(int i = 1; i <= 9; i++) {
                if(i * 1 < n) {
                    if(isEnd)
                        return;
                    ans[index - 1] = i * 1;
                    calc(n - (i * 1), index+1);
                }
            }
        }
        return;
    }

    private static boolean isPalindrome(int n) {
        String a = Integer.toString(n);
        char[] b = a.toCharArray();
        for(int i = 0; i < b.length; i++) {
            if(b[i] != b[b.length- 1 - i])
                return false;
        }
        return true;
    }
}
