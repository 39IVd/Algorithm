package Graph;

import java.util.*;

public class BJ_1693_PaintTree {
    static Scanner in = new Scanner(System.in);
    static int n;
    static List<Integer>[] edges = new List[100001];
    static int visited[] = new int[100001];
    static int dp[][] = new int[100001][2];
    static Set<Integer> allSet = new HashSet<>();

    static Set<Integer> set_inc = new HashSet<>();
    static Set<Integer> set_uninc = new HashSet<>();
    static int total = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=1;i<=n;i++) {
            edges[i] = new LinkedList<>();
            allSet.add(i);
        }
        for(int i=1;i<n;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edges[a].add(b); edges[b].add(a);
        }
        int root = 1; int color = 1;

        while (true) {
            root = allSet.iterator().next();
            System.out.println("root : "+root);
            dfs(root, 0, set_uninc);
            System.out.println(set_uninc.toString());
            for(int i=1;i<=n;i++) {
                visited[i] = 0;
            }
            set_inc.add(1);
            dfs(root, 1, set_inc);
            System.out.println(set_inc.toString());
            if(set_uninc.size()>set_inc.size()) {
                total += color*set_uninc.size();
                allSet.removeAll(set_uninc);
            }
            else if(set_uninc.size()<=set_inc.size()) {
                total += color*set_inc.size();
                allSet.removeAll(set_inc);
            }
            color++;
        }


    }
    public static void dfs(int curr, int include, Set<Integer> set) {
        visited[curr] = 1;
        if(include==0) {
//            현재 노드가 포함되지 않는 경우
            dp[curr][0] = 0;
            for(int i=0;i<edges[curr].size();i++) {
                int child = edges[curr].get(i);
                if(visited[child]==0) {
                    dfs(child, 0, set);
                    dfs(child, 1, set);
                    if(dp[child][0]<dp[child][1]) {
                        dp[curr][0] += dp[child][1];
                        set.add(child);
                    }
                    else {
                        dp[curr][0] += dp[child][0];
                    }
                }
            }
        }
        else {
//            현재 노드가 포함되는 경우
            dp[curr][1] = 1;
            for(int i=0;i<edges[curr].size();i++) {
                int child = edges[curr].get(i);
                if(visited[child]==0) {
                    dfs(child, 0, set);
                    dp[curr][1] += dp[child][0];
                }
            }

        }
    }
}
