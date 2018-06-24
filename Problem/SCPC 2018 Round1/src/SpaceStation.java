import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

public class SpaceStation {
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

            StringTokenizer st = new StringTokenizer(br.readLine());
            int N = Integer.parseInt(st.nextToken());
            Answer = N;
            int M = Integer.parseInt(st.nextToken());
            Node[] node = new Node[N];
            for(int i = 0; i < N; i++) {
                node[i]= new Node();
            }
            for(int i = 0; i <M; i++) {
                st = new StringTokenizer(br.readLine());
                int A = Integer.parseInt(st.nextToken()) - 1;
                int B = Integer.parseInt(st.nextToken()) - 1;
                node[A].connectedNodeName.add(B);
                node[B].connectedNodeName.add(A);
            }
            Queue<Integer> twoEdge = new LinkedList<>();
            for(int i = 0; i < N; i++) {
                if(node[i].connectedNodeName.size() == 2)
                    twoEdge.add(i);
            }

            while(!twoEdge.isEmpty()) {
                int targetNode = twoEdge.poll();
                if(node[targetNode].connectedNodeName.size() != 2)
                    continue;
                int nodeA = node[targetNode].connectedNodeName.get(0);
                int nodeB = node[targetNode].connectedNodeName.get(1);
                if(node[nodeA].connectedNodeName.contains(nodeB)) {
                    node[nodeA].connectedNodeName.remove(Integer.valueOf(targetNode));
                    node[nodeB].connectedNodeName.remove(Integer.valueOf(targetNode));
                    Answer--;
                    if(node[nodeA].connectedNodeName.size() == 2)
                        twoEdge.add(nodeA);
                    if(node[nodeB].connectedNodeName.size() == 2)
                        twoEdge.add(nodeB);
                }
            }
            /////////////////////////////////////////////////////////////////////////////////////////////
			/*
			   Implement your algorithm here.
			   The answer to the case will be stored in variable Answer.
			 */
            /////////////////////////////////////////////////////////////////////////////////////////////


            // Print the answer to standard output(screen).
            System.out.println("Case #"+(test_case+1));
            System.out.println(Answer);
        }
    }
    static class Node{
        ArrayList<Integer> connectedNodeName = new ArrayList<>();
    }
}
