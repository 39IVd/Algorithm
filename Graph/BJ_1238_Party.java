package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.PriorityQueue;
import java.util.Scanner;

//    문제 정의 : Directed Graph에서, 모든 노드에 대해 X에 방문했다가 다시 돌아오는 경로의 최소 비용을 구하라.
//    (1) 모든 노드에서 X로 가는 최소 비용 + (2) X에서 모든 노드로 가는 최소 비용의 합.
//    => Dijkstra 알고리즘은 한 노드에서 다른 모든 노드로 가는 Shortest Path를 구할 수 있다.
//    (1)을 구하기 위해, edge의 방향을 반대로 하여 X에서 모든 노드로 가는 Shortest Path를 구한다.
//    (2)를 구하기 위해, 원래 edge 방향 그대로 X에서 모든 노드로 가는 Shortest Path를 구한다.
//    (1)과 (2)에서 각 노드의 d[]를 구한 다음 합한다. 이 중 최대값이 가장 거리가 먼 노드의 비용이다.


class edge_Party {
    int adj, t;
    edge_Party(int adj, int t) {
        this.adj = adj; this.t = t;
    }
}
class node_Party implements Comparable<node_Party> {
    int v, t;
    node_Party(int v, int t) {
        this.v = v; this.t = t;
    }

    @Override
    public int compareTo(node_Party o) {
        if(o.t<this.t) return 1;
        else if(o.t>this.t) return -1;
        else return 0;
    }
}

public class BJ_1238_Party {
    static Scanner in = new Scanner(System.in);
    static int n, m, x;
    static int[][] d = new int[1001][2];
    static int[] visited = new int[1001];
    static PriorityQueue<node_Party> pq = new PriorityQueue<>();
    static PriorityQueue<node_Party> pq_reverse = new PriorityQueue<>();
    static List<edge_Party>[] edges = new List[1001];
    static List<edge_Party>[] edges_reverse = new List[1001];
    public static void main(String[] args) {
        n = in.nextInt(); m = in.nextInt(); x = in.nextInt();
        for(int i=1;i<=n;i++) {
            edges[i] = new LinkedList<>();
            edges_reverse[i] = new LinkedList<>();
            d[i][0] = Integer.MAX_VALUE;
            d[i][1] = Integer.MAX_VALUE;
        }
        for(int i=0;i<m;i++) {
            int v1 = in.nextInt(); int v2 = in.nextInt(); int t = in.nextInt();
            edges[v1].add(new edge_Party(v2, t));
            edges_reverse[v2].add(new edge_Party(v1, t));
            if(v1==x) {
                d[v2][0] = t;
                pq.add(new node_Party(v2, t));
            }
            else if(v2==x) {
                d[v1][1] = t;
                pq_reverse.add(new node_Party(v1, t));
            }
        }
//        1. x에서 모든 정점으로 가는 최소 비용 (d[node][0], edges)
//        2. 모든 정점에서 x로 가는 최소 비용 (d[node][1], edges_reverse)
        int cnt = 1;
        while (cnt<n) {
            node_Party curr = pq.poll();
//            System.out.println(curr.v+","+curr.t);
            if(visited[curr.v]==0) {
                for(int i=0;i<edges[curr.v].size();i++) {
                    int adj = edges[curr.v].get(i).adj;
                    int time = edges[curr.v].get(i).t;
//                    System.out.println("add_before=> "+adj+","+(d[curr.v][0]+time));

                    if(adj!=x) {
                        d[adj][0] = Math.min(d[adj][0], d[curr.v][0]+time);
                        pq.add(new node_Party(adj, d[adj][0]));
//                        System.out.println("add=> "+adj+","+d[adj][0]);
                    }
                }
                visited[curr.v] = 1;
                cnt++;
            }

        }
//        System.out.println("end");
        for(int i=1;i<=n;i++) {
            visited[i] = 0;
//            System.out.print(d[i][0]+" ");
        }
//        System.out.println();
        cnt = 1;
        while (cnt<n) {
            node_Party curr = pq_reverse.poll();
            if(visited[curr.v]==0) {
                for(int i=0;i<edges_reverse[curr.v].size();i++) {
                    int adj = edges_reverse[curr.v].get(i).adj;
                    int time = edges_reverse[curr.v].get(i).t;
                    if(adj!=x) {
                        d[adj][1] = Math.min(d[adj][1], d[curr.v][1]+time);
                        pq_reverse.add(new node_Party(adj, d[adj][1]));

                    }
                }
                visited[curr.v] = 1;
                cnt++;
            }
        }
//        for(int i=1;i<=n;i++) {
//            System.out.print(d[i][1]+" ");
//        }
//        System.out.println();
        int res = 0;
        for(int i=1;i<=n;i++) {
            if(i!=x) {
                res = Math.max(res, d[i][0]+d[i][1]);
            }
        }
        System.out.println(res);
    }
}
