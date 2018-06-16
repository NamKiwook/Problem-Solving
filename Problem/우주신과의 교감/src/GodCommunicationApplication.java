import java.awt.*;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.*;

public class GodCommunicationApplication {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        int N = Integer.parseInt(st.nextToken());
        int M = Integer.parseInt(st.nextToken());
        GodCommunication gc = new GodCommunication(N);
        for(int i = 0; i < N; i++) {
            st = new StringTokenizer(br.readLine());
            gc.inputNode(i,Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()));
        }
        gc.setEdge();
        for(int i = 0; i < M; i++) {
            st = new StringTokenizer(br.readLine());
            gc.inputEdge(Integer.parseInt(st.nextToken()),Integer.parseInt(st.nextToken()),0);
        }
        System.out.printf("%.2f",gc.kruskal());
    }
}
class GodCommunication{
    PriorityQueue<Edge> pq = new PriorityQueue<Edge>();
    UnionFind uf;
    int numberNode;
    Point[] node;
    Set<Edge> edge = new HashSet<Edge>();
    public GodCommunication(int n) {
        numberNode = n;
        uf = new UnionFind(n);
        node = new Point[n+1];
    }

    public void inputNode(int index,int X, int Y) {
        node[index+1] = new Point(X,Y);
    }

    public void inputEdge(int s, int e, double w) {
        if(s > e) {
            int temp = s;
            s = e;
            e = temp;
        }
        Edge temp = new Edge(s,e,w);
        if(!edge.contains(temp)) {
            edge.add(temp);
        } else {
            edge.remove(temp);
            edge.add(temp);
        }
    }

    public void setEdge() {
        for(int i = 1; i <= numberNode; i++) {
            for(int j = i+1; j <= numberNode; j++) {
                double distance = Math.sqrt(Math.pow(node[i].x - node[j].x,2) + Math.pow(node[i].y-node[j].y,2));
                inputEdge(i,j,distance);
            }
        }
    }
    public double kruskal() {
        double result = 0;
        for(Edge e : edge) {
            pq.add(e);
        }
        for(int i = 0; i < edge.size(); i++) {
            Edge e = pq.poll();
            int a = uf.find(e.start);
            int b = uf.find(e.end);
            if(a == b) continue; //사이클

            uf.union(e.start,e.end);
            result += e.weight;
        }

        return result;
    }
    class UnionFind {
        int[] parents;
        int[] level;
        public UnionFind(int n) {
            parents = new int[n+1];
            level = new int[n+1];
            for(int i = 1; i <= n; i++) {
                parents[i] = i;
                level[i] = 1;
            }
        }
        public int find(int node) {
            if(parents[node] == node)
                return node;
            return parents[node] = find(parents[node]);
        }
        public void union(int nodeA, int nodeB) {
            int A = find(nodeA);
            int B = find(nodeB);
            if(A == B)
                return;
            if(level[A] > level[B]) {
                int temp = A;
                A = B;
                B = temp;
            }
            parents[A] = B;
            if(level[A] == level[B]) {
                ++level[A];
            }
        }
    }
    class Edge implements Comparable<Edge> {
        int start;
        int end;
        double weight;
        public Edge(int s, int e, double w) {
            start = s;
            end = e;
            weight = w;
        }
        @Override
        public int compareTo(Edge edge) {
            return this.weight >= edge.weight ? 1 : -1;
        }
        @Override
        public int hashCode() {
            return Objects.hash(start,end);
        }
        @Override
        public boolean equals(Object o) {
            if (o instanceof Edge) {
                Edge temp = (Edge) o;
                return temp.end == end && temp.start == start;
            }
            return false;
        }
    }
}
