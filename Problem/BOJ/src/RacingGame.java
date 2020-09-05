import java.io.BufferedReader;
import java.io.InputStreamReader;

public class RacingGame {
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] firstLineContent = br.readLine().split(" ");
        int nodeNo = Integer.parseInt(firstLineContent[0]);
        int edgeNo = Integer.parseInt(firstLineContent[1]);
        BellmanFordGraph bfg = new BellmanFordGraph(nodeNo, edgeNo);
        UnionFind uf = new UnionFind(nodeNo);

        for (int i = 0; i < edgeNo; i++) {
            String[] lineContent = br.readLine().split(" ");
            bfg.edge[i].src = Integer.parseInt(lineContent[0]) - 1;
            bfg.edge[i].dest = Integer.parseInt(lineContent[1]) - 1;
            bfg.edge[i].weight = Integer.parseInt(lineContent[2]);
            uf.merge(bfg.edge[i].src, bfg.edge[i].dest);
        }
        if (uf.find(0) != uf.find(nodeNo - 1)) {
            System.out.println("bug");
        } else {
            try {
                System.out.println(bfg.BellmanFord(bfg, 0));
            } catch (Exception e) {
                System.out.println("bug");
            }
        }
    }

    public static class UnionFind {
        private int[] parent;
        private int[] level;

        public UnionFind(int n) {
            parent = new int[n + 1];
            level = new int[n + 1];
            for (int i = 1; i <= n; i++) {
                parent[i] = i;
                level[i] = 1;
            }
        }

        public int find(int node) {
            if (node == parent[node]) {
                return node;
            }
            return parent[node] = find(parent[node]);
        }

        public void merge(int nodeA, int nodeB) {
            nodeA = find(nodeA);
            nodeB = find(nodeB);
            if (nodeA == nodeB) {
                return;
            }
            if (level[nodeA] > level[nodeB]) {
                int temp = nodeA;
                nodeA = nodeB;
                nodeB = temp;
            }

            parent[nodeA] = nodeB;
            if (level[nodeA] == level[nodeB]) {
                ++level[nodeB];
            }
        }
    }

    static class BellmanFordGraph {
        class Edge {
            int src, dest, weight;

            Edge() {
                src = dest = weight = 0;
            }
        }

        int V, E;
        Edge edge[];

        BellmanFordGraph(int v, int e) {
            V = v;
            E = e;
            edge = new Edge[e];
            for (int i = 0; i < e; ++i) {
                edge[i] = new Edge();
            }
        }

        int BellmanFord(BellmanFordGraph graph, int src) throws Exception {
            int V = graph.V, E = graph.E;
            int dist[] = new int[V];
            for (int i = 0; i < V; ++i) {
                dist[i] = Integer.MAX_VALUE;
            }
            dist[src] = 0;
            for (int i = 1; i < V; ++i) {
                for (int j = 0; j < E; ++j) {
                    int u = graph.edge[j].src;
                    int v = graph.edge[j].dest;
                    int weight = graph.edge[j].weight;
                    if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                        dist[v] = dist[u] + weight;
                    }
                }
            }
            for (int j = 0; j < E; ++j) {
                int u = graph.edge[j].src;
                int v = graph.edge[j].dest;
                int weight = graph.edge[j].weight;
                if (dist[u] != Integer.MAX_VALUE && dist[u] + weight < dist[v]) {
                    throw new Exception("Loop");
                }
            }
            return dist[V - 1];
        }
    }
}


