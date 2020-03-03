package AlgorithmLecture3_2;

// Codeforces Problem C

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.PriorityQueue;
import java.util.Stack;
import java.util.StringTokenizer;


public class C_Dijkstra {
    final static int INF = 100000;
    static int n, m;
    static Edge_Dijkstra[] edge;
    static int[] visit;
    static Node_Dijkstra[] node;
    static PriorityQueue<Node_Dijkstra> pq = new PriorityQueue<>();
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        edge = new Edge_Dijkstra[m];
        node = new Node_Dijkstra[n+1];
        visit = new int[n+1];

        for(int i=1;i<=n;i++) {
            node[i] = new Node_Dijkstra(i, INF);
            pq.offer(node[i]);
        }

        Stack<Edge_Dijkstra> s =  new Stack();

        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            if(a>b) { int tmp = a; a=b; b=tmp;}
            edge[i] = new Edge_Dijkstra(a, b, w);
            if(a==1) {
                node[b].dist = w;
                pq.offer(node[b]);
                s.add(new Edge_Dijkstra(1, b, w));
//                System.out.println(w);
            }
        }
        node[1].dist = 0;
        visit[1] = 1;
        int cnt = 1;
        while(cnt<n) {
            Node_Dijkstra e = pq.poll(); // dist 가 가장 짧은 노드 순
            if(e.node==n) {break;}
            cnt++;
            if(e.dist!=INF&&visit[e.node]!=1) {
                System.out.println(e.node+" : "+e.dist);
                // 방문하지 않은 경우 해당 노드와 연결된 모든 노드들을 갱신
                visit[e.node] = 1;
                for (int i = 0; i < m; i++) {
                    int n1 = 0, n2 = 0;
                    if(edge[i].a!=e.node&&edge[i].b!=e.node) {
                        continue;
                    }
                    else {
                        if(edge[i].a==e.node) {n1 = edge[i].a; n2 = edge[i].b;}
                        if(edge[i].b==e.node) {n1 = edge[i].b; n2 = edge[i].a;}
                        int d =node[n1].dist+edge[i].w;
                        if(visit[n2]!=1&&node[n2].dist>d) {
                            s.add(new Edge_Dijkstra(n1, n2, d));
                            System.out.println(n1+", "+n2+", "+d);
                            node[n2].dist = d;
                            pq.offer(node[n2]);
                        }
                    }

                }
            }
        }
        System.out.println(node[n].dist);
        if(node[n].dist==INF) {
            System.out.println(-1);
        }
        else {
            ArrayList<Integer> res = new ArrayList<>();
            res.add(n);
            int curr = n;
            for(int i=s.size()-1;i>=0;i--) {
                if(s.get(i).b==curr) {
                    res.add(s.get(i).a);
                    curr = s.get(i).a;
                }
            }
            for(int i=res.size()-1;i>=0;i--) {
                System.out.print(res.get(i)+" ");
            }
        }
    }
}
class Node_Dijkstra implements Comparable<Node_Dijkstra> {
    int node, dist;
    public Node_Dijkstra(int node, int dist) {
        this.node = node; this.dist = dist;
    }

    @Override
    public int compareTo(Node_Dijkstra o) {
        return this.dist<o.dist? -1 : 1;
    }
}
class Edge_Dijkstra {
    int a, b, w;
    public Edge_Dijkstra(int a, int b, int w) {
        this.a=a;this.b=b;this.w=w;
    }
}
