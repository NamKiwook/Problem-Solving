public class UnionFind {
    private int[] parent;
    private int[] level;
    public UnionFind(int n) {
        parent = new int[n+1];
        level = new int[n+1];
        for(int i = 1; i <= n; i++) {
            parent[i] = i;
            level[i] = 1;
        }
    }

    public int find(int node) {
        if(node == parent[node]) {
            return node;
        }
        return parent[node] = find(parent[node]);
    }

    public void merge(int nodeA, int nodeB) {
        nodeA = find(nodeA);
        nodeB = find(nodeB);
        if(nodeA == nodeB) {
            return;
        }
        if(level[nodeA] > level[nodeB]) {
            int temp = nodeA;
            nodeA = nodeB;
            nodeB = temp;
        }

        parent[nodeA] = nodeB;
        if(level[nodeA] == level[nodeB]){
            ++level[nodeB];
        }
    }
}
