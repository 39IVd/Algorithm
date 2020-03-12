package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_2213_IndependentSetOfTree2 {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[][] dp = new int[10001][2];
    static String[][] track = new String[10001][2];
    static int[] weight = new int[10001];
    static int[] visited = new int[10001];

    static List<Integer>[] selected = new List[2];
    static List<Integer>[] edge = new List[10001];
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=1;i<=n;i++) {
            weight[i] = in.nextInt();
//            dp[i] = weight[i];
//            selected[i] = new LinkedList<>();
//            selected[i].add(i);
            edge[i] = new LinkedList<>();
        }
        for(int i=0;i<n-1;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edge[a].add(b); edge[b].add(a);
        }
        selected[0] = new LinkedList<>(); selected[1] = new LinkedList<>();
        selected[1].add(1);
        dfs(1);

        for(int i=1;i<=n;i++) {
            System.out.println(dp[i][0]+" "+dp[i][1]);
        }
        System.out.println(selected[0].toString());
        System.out.println(selected[1].toString());

//        for(int i=1;i<=n;i++) {
//            System.out.println(dp[i][0]+" "+dp[i][1]);
//        }
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    public static void dfs(int curr) {
        visited[curr] = 1;
        System.out.println(curr);
        dp[curr][0]=0;
        dp[curr][1]= weight[curr];
        for(int i=0;i<edge[curr].size();i++) {
            int child = edge[curr].get(i);
            if(visited[child]==0) {
                dfs(child);
                if(dp[child][0]<dp[child][1]) {
                    selected[0].add(child);
                    System.out.println("child : "+child);
                }
                dp[curr][0] += Math.max(dp[child][0], dp[child][1]);
                dp[curr][1] += dp[child][0];
            }
        }
    }
}
