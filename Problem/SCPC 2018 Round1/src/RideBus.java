import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.StringTokenizer;

public class RideBus {
    static int Answer;

    public static void main(String args[]) throws Exception {
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
        for (int test_case = 0; test_case < T; test_case++) {
            Answer = 0;
            /////////////////////////////////////////////////////////////////////////////////////////////
            StringTokenizer st = new StringTokenizer(br.readLine());

            int N = Integer.parseInt(st.nextToken());
            int K = Integer.parseInt(st.nextToken());
            int[] ability = new int[N];

            st = new StringTokenizer(br.readLine());
            for (int i = 0; i < N; i++) {
                ability[i] = Integer.parseInt(st.nextToken());
            }
            ability = mergeSort(ability,0,N-1);
            int pR = 0, pL = 0;
            int windowSize = 0;
            while (pL < N) {
                for (int i = 0; i <= K; i++) {
                    if(pR >= N) {
                        break;
                    }
                    if (ability[pL] + K >= ability[pR]) {
                        pR++;
                        windowSize++;
                    } else {
                        break;
                    }
                }
                if(windowSize > Answer)
                    Answer = windowSize;
                pL++;
                windowSize--;

            }
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////


            // Print the answer to standard output(screen).
            System.out.println("Case #" + (test_case + 1));
            System.out.println(Answer);
        }
    }
    public static int[] mergeSort(int[] arr , int left , int right) {

        int[] leftArr;
        int[] rightArr;
        int[] sortedArr;

        if(right - left == 0){
            sortedArr = new int[1];
            sortedArr[0] = arr[left];
            return sortedArr;
        }

        int mid =(int) ((right + left) / 2 );

        leftArr = mergeSort(arr , left , mid);
        rightArr = mergeSort(arr , mid+1 , right);
        sortedArr = merge(leftArr , rightArr);

        return sortedArr;
    }

    private static int[] merge(int[] leftArr, int[] rightArr) {
        int left = 0;
        int right = 0;
        int sort = 0;

        int[] sortedArr = new int[leftArr.length + rightArr.length];

        while(left < leftArr.length && right < rightArr.length){
            if(leftArr[left] - rightArr[right] < 0 ){
                sortedArr[sort] = leftArr[left];
                left++;
                sort++;
            } else {
                sortedArr[sort] = rightArr[right];
                right++;
                sort++;
            }
        }

        while(left < leftArr.length){
            sortedArr[sort] = leftArr[left];
            left++;
            sort++;
        }
        while (right < rightArr.length){
            sortedArr[sort] = rightArr[right];
            right++;
            sort++;
        }
        return sortedArr;
    }
}
