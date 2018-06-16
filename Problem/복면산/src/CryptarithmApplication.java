import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class CryptarithmApplication {
    public static void main(String[] args) throws IOException {
        InputStreamReader isr = new InputStreamReader(System.in);
        BufferedReader br = new BufferedReader(isr);
        StringTokenizer st = new StringTokenizer(br.readLine());
        Cryptarithm cryptarithm = new Cryptarithm(st.nextToken(),st.nextToken(),st.nextToken());
    }
}

class Cryptarithm {
    String formulaA;
    String formulaB;
    String result;
    boolean isSuccess = false;
    Map<Character,Integer> variableSet = new TreeMap<>();
    int[] assignArr = new int[] {0,1,2,3,4,5,6,7,8,9};

    public Cryptarithm (String formulaA, String formulaB, String result) {
        for(int i = 0; i < formulaA.length(); i++){
            this.formulaA = formulaA;
            if(!variableSet.containsKey(formulaA.charAt(i)))
                variableSet.put(formulaA.charAt(i),variableSet.size());
        }
        for(int i = 0; i < formulaB.length(); i++){
            this.formulaB = formulaB;
            if(!variableSet.containsKey(formulaB.charAt(i)))
                variableSet.put(formulaB.charAt(i),variableSet.size());
        }
        for(int i = 0; i < result.length(); i++){
            this.result = result;
            if(!variableSet.containsKey(result.charAt(i)))
                variableSet.put(result.charAt(i),variableSet.size());
        }
        if(variableSet.size() > 10) {
            System.out.print("NO");
            return;
        }
        assignNumber(assignArr,0);
        if(!isSuccess) {
            System.out.print("NO");
        }
    }

    private void assignNumber(int[] assignArr, int currentDepth) {
        if(isSuccess)
            return;
        if(currentDepth == assignArr.length){
            int count = 0;
            for(char key : variableSet.keySet()) {
                variableSet.put(key,assignArr[count++]);
            }
            if(calc(assignArr)) {
                System.out.print("YES");
                return;
            }
        }

        for(int i = currentDepth; i < assignArr.length; i++) {
            swap(assignArr,currentDepth,i);
            assignNumber(assignArr,currentDepth+1);
            swap(assignArr,currentDepth,i);
        }
    }
    private void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }
    private boolean calc(int[] arr) {
        long A = 0;
        long B = 0;
        long C = 0;
        for(int i = 0; i < formulaA.length(); i++) {
            A = A * 10 + variableSet.get(formulaA.charAt(i));
        }
        for(int i = 0; i < formulaB.length(); i++) {
            B = B * 10 + variableSet.get(formulaB.charAt(i));
        }
        for(int i = 0; i < result.length(); i++) {
            C = C * 10 + variableSet.get(result.charAt(i));
        }
        if(A + B == C) {
            isSuccess = true;
            return true;
        }
        return false;
    }
}


