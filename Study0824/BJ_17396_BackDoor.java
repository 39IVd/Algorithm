package Study0824;

import java.util.Scanner;

public class BJ_17396_BackDoor {
    static int n, m;
    static int[] point;
    static int[] visit;
    static int[][] graph;
    static int min = 1000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        point = new int[n] ;
        graph = new int[n][n];
        visit = new int[n];
        for(int i=0;i<n;i++) {
            point[i] = in.nextInt();
            for(int j=0;j<n;j++) {
                graph[i][j] = 0;
            }
        }
        point[n-1] = 0;
        for(int i=0;i<m;i++) {
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            int t = in.nextInt();
            if(point[p1]==0&&point[p2]==0) {
                graph[p1][p2] = t;
                graph[p2][p1] = graph[p1][p2];
            }
        }
//        System.out.println();
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }
        visit[0]=1;
        dfs(0, 0);
        if(min==1000) {
            min = -1;
        }
        System.out.println(min);
    }
    public static void dfs(int curr, int t) {
        if(curr==n-1) {
            min = Math.min(min, t);
            System.out.println("end : "+min);
        }
        else {
            for(int i=0;i<n;i++) {
                if(visit[i]!=1&&graph[curr][i]!=0) {
                    System.out.println(curr+"-"+i+" : "+(t+graph[curr][i])+"초");
                    visit[i] = 1;
                    dfs(i, t+graph[curr][i]);
                    visit[i] = 0;
                }
            }
        }
    }
}
