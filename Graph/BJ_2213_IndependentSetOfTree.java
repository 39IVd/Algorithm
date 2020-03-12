package Graph;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_2213_IndependentSetOfTree {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] dp = new int[10001];
    static int[] weight = new int[10001];
    static List<Integer>[] selected = new List[10001];
    static List<Integer>[] adj = new List[10001];
    static int max = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=1;i<=n;i++) {
            weight[i] = in.nextInt();
            dp[i] = weight[i];
            selected[i] = new LinkedList<>();
            selected[i].add(i);
            adj[i] = new LinkedList<>();
        }
        for(int i=0;i<n-1;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            adj[a].add(b); adj[b].add(a);
        }
        for(int i=1;i<n;i++) {
            for(int k=i+1;k<=n;k++) {
                if(!adj[i].contains(k)) {
                    if(dp[k]<dp[i]+weight[k]) {
                        selected[k].clear();
                        selected[k].addAll(selected[i]);
                        selected[k].add(k);
                        dp[k] = dp[i]+weight[k];
                    }
//                    dp[k]= Math.max(dp[k], dp[i]+weight[k]);
                }
            }
        }
        int maxIndex = 0;
        for(int i=1;i<=n;i++) {
            max = Math.max(max, dp[i]);
            maxIndex = i;
//            System.out.println(dp[i]+" ");
        }
        System.out.println(max);
        for(int i=0;i<selected[maxIndex].size();i++) {
            System.out.print(selected[maxIndex].get(i)+" ");
        }
    }
}
