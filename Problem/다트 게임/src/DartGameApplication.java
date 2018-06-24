import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class DartGameApplication {
    public static void main(String[] args) throws IOException {
        BufferedReader br =new BufferedReader(new InputStreamReader(System.in));
        DartGame dg = new DartGame();
        System.out.print(dg.calc(br.readLine()));
    }
}
class DartGame{
    public int calc(String input) {
        int[] result = new int[3];
        String[] operator = input.split("[0-9]+");
        String[] number= input.split("\\D+");
        for(int i = 0; i < 3; i++) {
            result[i] = Integer.parseInt(number[i]);
            if(operator[i+1].charAt(0) == 'S'){
                result[i] = (int) Math.pow(result[i],1);
            } else if (operator[i+1].charAt(0) == 'D') {
                result[i] = (int) Math.pow(result[i],2);
            } else {
                result[i] = (int) Math.pow(result[i],3);
            }

            if(operator[i+1].length() > 1) {
                if(operator[i+1].charAt(1) == '*') {
                    if(i >= 1)
                        result[i-1] *= 2;
                    result[i] *= 2;
                } else {
                    result[i] *= -1;
                }
            }
        }
        int returnVal = 0;
        for(int i = 0; i < 3; i++) {
            returnVal += result[i];
        }
        return returnVal;
    }
}
