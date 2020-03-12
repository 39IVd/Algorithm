package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

//    트리의 독립집합 중, 노드의 가중치의 합이 최소인 집합 구하기. (최소독립집합)
//
//    한 노드에서 시작해서, dfs로 모든 child를 탐색한다.
//    dp[현재노드][0] : 현재 노드를 포함하지 않았을 때 가중치의 총합.
//    dp[현재노드][1] : 현재 노드를 포함했을 때 가중치의 총합.
//
//    Algorithm
//    1. 각 노드의 가중치, edge를 초기화한다.
//    2. dfs 함수를 돌면서,
//        2-1. visited[현재노드] = 1 로 변경한다.
//        2-2. dp[현재노드][0] = 0, dp[현재노드][1] = weight[현재노드] 로 변경한다.
//        2-3. for문을 돌면서,
//            - 현재 노드의 child 노드 중, visited = 0인 노드들에 대해,
//            - dfs(child)로 child 노드를 먼저 방문한다.
//            - dp[현재노드][0] += Math.max(dp[child][0], dp[child][1]) 로 변경한다.
//                => 현재 노드를 포함하지 않을 경우, 자식 노드를 포함해도 되고 포함하지 않아도 되기 때문에,
//                두 경우 중 값이 큰 것을 더한다.
//            - dp[현재노드][1] = dp[child][0]으로 변경한다.
//                => 현재 노드를 포함할 경우, 자식 노드는 반드시 포함하지 않아야 하기 때문.
//
//        2-4. leaf노드 (child가 없는 노드)일 경우, dfs는 종료한다.


public class BJ_1949_GreatVillage3 {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[][] dp = new int[10001][2];
    static int[] weight = new int[10001];
    static List<Integer>[] edge = new List[10001];
    static int[] visited = new int[10001];
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=1;i<=n;i++) {
            weight[i] = in.nextInt();
            edge[i] = new LinkedList<>();
        }
        for(int i=0;i<n-1;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            edge[a].add(b); edge[b].add(a);
        }
        dfs(1);
        System.out.println(Math.max(dp[1][0], dp[1][1]));
//        for(int i=1;i<=n;i++) {
//            System.out.println(dp[i][0]+" "+dp[i][1]);
//        }
    }
    public static void dfs(int curr) {
        visited[curr] = 1;
        dp[curr][0] = 0;
        dp[curr][1] = weight[curr];
        for(int i=0;i<edge[curr].size();i++) {
            int child = edge[curr].get(i);
            if(visited[child]==0) {
                dfs(child);
                dp[curr][0] += Math.max(dp[child][0], dp[child][1]);
                dp[curr][1] += dp[child][0];
            }
        }
    }
}
