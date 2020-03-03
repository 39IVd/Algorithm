package Study0807;

import java.util.LinkedList;
import java.util.Scanner;

public class BJ_2533_SNS {
    static int N;
    static int[] visit;
    static int dp[][];
    static LinkedList<Integer>[] list;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt();
        visit = new int[N+1];
        dp = new int[N+1][2];
        list = new LinkedList[N+1];
        for(int i=1;i<=N;i++) {
            list[i] = new LinkedList<>();
        }
        for(int i=0;i<N-1;i++) {
            int a = in.nextInt();
            int b = in.nextInt();
            list[a].add(b);
            list[b].add(a);
        }
        dfs(1);
        System.out.println(Math.min(dp[1][0], dp[1][1]));
    }
    public static void dfs(int node) {
        visit[node] = 1;
        dp[node][0] = 0;
        // 자신이 얼리어답터가 아님 -> 자식노드는 얼리어답터여야 함
        dp[node][1] = 1;
        // 자신이 얼리어답터임 -> 자식은 얼리어답터 O or X
        LinkedList<Integer> item = list[node];
        for(int i : item) {
            if(visit[i]!=1) {
                dfs(i);
                dp[node][0] += dp[i][1];
                dp[node][1] += Math.min(dp[i][0], dp[i][1]);
            }
        }
    }
}
