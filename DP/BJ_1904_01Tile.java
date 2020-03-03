package DP;

import java.util.Scanner;

public class BJ_1904_01Tile {
    static int n;
    static int[] dp = new int[1000000];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dp[0]=1; dp[1]=1;

        for(int i=2;i<=n;i++) {
            dp[i] = (dp[i-2]+dp[i-1])%15746;
        }
        System.out.println(dp[n]);
    }
}
