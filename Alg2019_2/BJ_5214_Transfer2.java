package Alg2019_2;

import java.util.*;

public class BJ_5214_Transfer2 {
    static final int INF = 1000000;
    static int n, k, m;
    static ArrayList<ArrayList<Integer>> path; // 갈 수 있는 역 표시
//    인접 리스트로 구현
    static int[] dist = new int[INF];
    static int[] visit = new int[INF];
    static {
        Arrays.fill(dist, INF);
    }
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt(); m = in.nextInt();
        path = new ArrayList<ArrayList<Integer>>();
        for(int i=0;i<=n+m;i++) {
            path.add(new ArrayList<Integer>());
        }
        for(int i=1;i<=m;i++) {
            int dummy = n+i;
            for(int j=0;j<k;j++) {
                int c = in.nextInt();
                path.get(dummy).add(c);
                path.get(c).add(dummy);
            }
        }
//        for(int i=1;i<=n;i++) {
//            System.out.print(i+" : ");
//            for(int j=0;j<path[i].size();j++) {
//                System.out.print(path[i].get(j)+" ");
//            }
//            System.out.println();
//        }
        bfs();
    }
    public static void bfs() {
        Queue<Integer> q = new LinkedList();
        q.add(1); dist[1] = 1;
        visit[1] = 1;
        while(!q.isEmpty()) {
            int curr = q.poll();
//            System.out.println(curr+" : "+dist[curr]);
            if(curr==n) {
                break;
            }
            for(int next : path.get(curr)) {
                if(visit[next]!=1&&dist[next]>dist[curr]+1) {
                    q.add(next);
                    visit[next] = 1;
                    dist[next] = dist[curr]+1;
                }
            }
        }
        System.out.println(dist[n]>=INF? -1 : (dist[n]+1)/2);
    }
}
