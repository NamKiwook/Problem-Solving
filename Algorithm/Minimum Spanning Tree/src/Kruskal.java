import java.util.PriorityQueue;

public class Kruskal {
    int result = 0;
    PriorityQueue<Edge> pq;
    UnionFind uf;
    int numberNode;
    int numberEdge;

    public Kruskal(int numberEdge, int numberNode) {
        this.numberNode = numberNode;
        this.numberEdge = numberEdge;
        uf = new UnionFind(numberNode);
        pq = new PriorityQueue<Edge>();
    }
    public void inputEdge(int start, int end, int weight) {
        pq.add(new Edge(start, end, weight));
    }

    public int calc() {
        for(int i = 0; i < numberEdge; i++) {
            Edge e = pq.poll();
            int a = uf.find(e.start);
            int b = uf.find(e.end);
            if(a == b) continue; //사이클

            uf.merge(e.start,e.end);
            result += e.weight;
        }
        return result;
    }


}

class Edge implements Comparable<Edge> {
    int start;
    int end;
    int weight;
    public Edge(int start,int end,int weight){
        this.start = start;
        this.end = end;
        this.weight = weight;
    }
    @Override
    public int compareTo(Edge e) {
        return this.weight - e.weight;
    }
}

