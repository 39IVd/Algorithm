package AlgorithmLecture3_2;

// Codeforces Problem C

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.*;

public class C_Dijkstra2 {
    static int n, m;
    static int[] dist;
    static int[][] graph;
    static int[] visit;
    final static int INF = Integer.MAX_VALUE;
    static Stack<Edge_Dijk> stack = new Stack<>();

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken());
        dist = new int[n+1];
        visit = new int[n+1];
        graph = new int[n+1][n+1];
        Arrays.fill(dist, INF);
        for(int i=1;i<=n;i++) {
            Arrays.fill(graph[i], INF);
            graph[i][i] = 0;
        }
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            int a = Integer.parseInt(st.nextToken()); int b = Integer.parseInt(st.nextToken());
            int w = Integer.parseInt(st.nextToken());
            graph[a][b] = w; graph[b][a] = w;
            if(a==1) {
                dist[b] = w;stack.add(new Edge_Dijk(1, b));
            }
            if(b==1) {
                dist[a] = w; stack.add(new Edge_Dijk(1, a));
            }
        }
        dist[1] = 0;
        visit[1] = 1;

        int min, c=0;
        int cnt = 1;
        while (cnt < n-1) {
            min = INF;
            for(int i=2;i<=n;i++) {
                if(dist[i]<min&&visit[i]!=1) {
                    c = i; min = dist[i];
                }
            }
            cnt++;
            if(c==n) {
                break;
            }
            visit[c] =1;
            // 방문하지 않은 node 중 거리가 가장 짧은 값으로 c 설정.
            for(int i=1;i<=n;i++) {
                if(graph[c][i]!=INF&&visit[i]!=1) {
                    if(dist[i]>dist[c]+graph[c][i]) {
                        dist[i] = dist[c]+graph[c][i];
                        stack.add(new Edge_Dijk(c, i));
                    }
                }
            }
        }
        ArrayList<Integer> res = new ArrayList<>();
        int curr = n; res.add(curr);
        while(!stack.isEmpty()) {
            Edge_Dijk p = stack.pop();
            if(p.b==curr) {
                curr = p.a;
                res.add(curr);
            }
        }
        if(dist[n]==INF) {
            System.out.println(-1);
        }
        else {
            for(int i=res.size()-1;i>=0;i--) {
                System.out.print(res.get(i)+" ");
            }
        }
    }
}
class Edge_Dijk {
    int a, b;
    public Edge_Dijk(int a, int b) { this.a=a;this.b=b;}
}
