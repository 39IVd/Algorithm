package Graph;

import java.util.*;


public class BJ_2213_IndependentSetOfTree4 {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[][] dp = new int[10001][2];
    static int[] weight = new int[10001];
    static int[] visited = new int[10001];
    static List<Integer>[] edges = new List[10001];
    static Set<Integer> set_inc = new HashSet<>();
    static Set<Integer> set_uninc = new HashSet<>();
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=1;i<=n;i++) {
            weight[i] = in.nextInt();
//            dp[i] = weight[i];
//            selected[i] = new LinkedList<>();
//            selected[i].add(i);
            edges[i] = new LinkedList<>();
        }
        for(int i=0;i<n-1;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edges[a].add(b); edges[b].add(a);
        }

//        dfs(1, 0, set_uninc);
//        System.out.println(set_uninc.toString());
//        int max_uninc = Math.max(dp[1][0], dp[1][1]);
//        for(int i=1;i<=n;i++) {
//            System.out.println(dp[i][0]+" "+dp[i][1]);
//        }
//        System.out.println(Math.max(dp[1][0], dp[1][1]));


        for(int i=1;i<=n;i++) {
            visited[i] = 0;
        }
        set_inc.add(1);
        dfs(1, 1, set_inc);
        System.out.println(set_inc.toString());
        int max_inc = Math.max(dp[1][0], dp[1][1]);

        for(int i=1;i<=n;i++) {
            System.out.println(dp[i][0]+" "+dp[i][1]);
        }
        System.out.println(Math.max(dp[1][0], dp[1][1]));
    }
    public static void dfs(int curr, int include, Set<Integer> set) {
        visited[curr] = 1;
        if(include==0) {
//            현재 노드가 포함되지 않는 경우
//            dp[curr][1] = weight[curr];
            dp[curr][0] = 0;
            for(int i=0;i<edges[curr].size();i++) {
                int child = edges[curr].get(i);
                if(visited[child]==0) {
                    dfs(child, 0, set);
                    dfs(child, 1, set);
                    if(dp[child][0]<dp[child][1]) {
                        dp[curr][0] += dp[child][1];
//                        dp[curr][1] += dp[child][1];
                        set.add(child);
                    }
                    else {
                        dp[curr][0] += dp[child][0];
                    }
                }
            }
            System.out.println("curr : "+curr+" uninc");

        }
        else {
//            현재 노드가 포함되는 경우
            dp[curr][1] = weight[curr];

            for(int i=0;i<edges[curr].size();i++) {
                int child = edges[curr].get(i);
                if(visited[child]==0) {
                    dfs(child, 0, set);
                    dp[curr][1] += dp[child][0];
                }
            }
            System.out.println("curr : "+curr+" inc");

        }
    }
}
