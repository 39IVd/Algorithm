package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

class node_SP implements Comparable<node_SP> {
    int v, d;
    node_SP(int v, int d) {
        this.v = v ; this.d = d;
    }
    @Override
    public int compareTo(node_SP o) {
        if(o.d<this.d) return 1;
        else return -1;
    }
}

class edge_SP {
    int adj, w;
    edge_SP(int adj, int w) {
        this.adj = adj; this.w = w;
    }
}

public class BJ_1753_ShortestPath2 {
    static Scanner in = new Scanner(System.in);
    static int v, e, k;
    static int[] d = new int[20001];
    static List<edge_SP>[] edges = new List[20001];
    static PriorityQueue<node_SP> pq = new PriorityQueue<>();
    public static void main(String[] args) {
        v = in.nextInt(); e = in.nextInt();k=in.nextInt();
        for(int i=1;i<=v;i++) {
            edges[i] = new LinkedList<>();
            d[i] = Integer.MAX_VALUE;
        }
        for(int i=0;i<e;i++) {
            int v1 = in.nextInt(); int v2 = in.nextInt(); int w = in.nextInt();
            edges[v1].add(new edge_SP(v2, w));
//            if(v1==k) {
//                d[v2] = w;
////                pq.add(new node_SP(v2, w));
//            }
        }
//        int cnt = 1;
        d[k] = 0;
        pq.add(new node_SP(k, 0));
        while (!pq.isEmpty()) {
            node_SP from = pq.poll();
//            System.out.println(from.v+","+from.d);
            for(int i=0;i<edges[from.v].size();i++) {
                int to = edges[from.v].get(i).adj;
                int weight = edges[from.v].get(i).w;
                if(d[to]>d[from.v]+weight) {
                    d[to] = d[from.v]+weight;
                    pq.add(new node_SP(to, d[to]));
//                    System.out.println("add "+to+","+d[to]);
                }

            }

        }
        for(int i=1;i<=v;i++) {
            System.out.println(d[i]==Integer.MAX_VALUE?"INF":d[i]);
        }
    }
}
