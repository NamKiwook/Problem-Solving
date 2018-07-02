import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class SecretMapApplication{
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int n =  Integer.parseInt(st.nextToken());
        int[] arr1 = new int[n];
        int[] arr2 = new int[n];
        st = new StringTokenizer(br.readLine(),"[,] ");
        for(int i = 0; i < n; i++){
            arr1[i] = Integer.parseInt(st.nextToken());
        }
        st = new StringTokenizer(br.readLine(),"[,] ");
        for(int i = 0; i < n; i++){
            arr2[i] = Integer.parseInt(st.nextToken());
        }
        SecretMap sm = new SecretMap(arr1,arr2);
        String[] a= sm.solution();
        for(int i = 0; i < n; i++){
            a[i] = "\"" + a[i]+"\"";
        }
        System.out.print(Arrays.toString(a));
        return;
    }
}

class SecretMap {
    int[] arr1;
    int[] arr2;

    public SecretMap(){}
    public SecretMap(int[] arr1, int[] arr2) {
        this.arr1 = arr1;
        this.arr2 = arr2;
    }

    public String[] solution(){
        int[] result = new int[arr1.length];
        String[] solution = new String[arr1.length];;
        for(int i = 0; i < arr1.length; i++){
            result[i] = arr1[i] | arr2[i];
            solution[i] = "";
            for(int j = 0; j < arr1.length; j++) {
                if(result[i] % 2 == 1) {
                    solution[i] = "#"+solution[i];
                } else {
                    solution[i] = " "+solution[i];
                }
                result[i] /= 2;
            }
        }
        return solution;
    }
}