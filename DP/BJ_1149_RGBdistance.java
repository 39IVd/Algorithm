package DP;

import java.util.Scanner;

public class BJ_1149_RGBdistance {
    static int N;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        dp = new int[N+1][3];
        dp[0][0] = dp[0][1] = dp[0][2] = 0;
        for(int i=1;i<=N;i++) {
            for(int j=0;j<3;j++) {
                dp[i][j] = scan.nextInt();
            }
        }
        Calculate();
    }
    public static void Calculate() {
        for(int i=1;i<=N;i++) {
            dp[i][0] += Min(dp[i-1][1], dp[i-1][2]);
            dp[i][1] += Min(dp[i-1][0], dp[i-1][2]);
            dp[i][2] += Min(dp[i-1][0], dp[i-1][1]);
        }
        System.out.println(Min(dp[N][0], Min(dp[N][1], dp[N][2])));
    }
    public static int Min(int a, int b) {
        return a<b? a : b;
    }
}
