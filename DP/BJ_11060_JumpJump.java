package DP;

import java.util.Scanner;

//런타임 에러 해결 => 배열 크기를 조건보다 훨씬 높게 잡으면 해결.

public class BJ_11060_JumpJump {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] maze = new int[10000];
    static int[] dp = new int[10000];
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=0;i<n;i++) {
            maze[i] = in.nextInt();
            dp[i] = 10000;
        }
        dp[0] = 0;
        for(int i=0;i<n-1;i++) {
            for(int j=i+1;j<=i+maze[i];j++) {
                dp[j] = Math.min(dp[j], dp[i]+1);
            }
        }
//        for(int i=0;i<n;i++) {
//            System.out.println(dp[i]);
//        }
        int res = dp[n-1];
        if(res==10000) {
            System.out.println(-1);
        }
        else {
            System.out.println(res);
        }
    }
}
