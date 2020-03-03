package DP;

import java.util.Scanner;


public class BJ_14058_Resignation2 {
    static int n;
    static int[] time = new int[20];
    static int[] price = new int[20];
    static int[][] dp = new int[20][2];
    static int max = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n =in.nextInt();
        for(int i=1;i<=n;i++) {
            time[i] = in.nextInt();
            price[i] = in.nextInt();
            dp[i][0] = 0;
            if(i+time[i]>n+1) {
                dp[i][1] = 0;
            }
            else {
                dp[i][1] = price[i];
            }
        }
//        for(int i=1;i<=n;i++) {
//            System.out.println(i+" : "+dp[i][0]+", "+dp[i][1]);
//        }
//        System.out.println();
        func(1);
//        for(int i=1;i<=n;i++) {
//            System.out.println(i+" : "+dp[i][0]+", "+dp[i][1]);
//        }
        System.out.println(max);
    }
    public static void func(int curDay) {
        max = Math.max(max, dp[curDay][0]);
        max = Math.max(max, dp[curDay][1]);

        if(curDay>=n) {
            return;
        }
        int nextDay = curDay+1;
        dp[nextDay][0] = Math.max(dp[nextDay][0]
                , dp[curDay][0]);
        if(time[nextDay]+nextDay<=n+1) {
            dp[nextDay][1] = Math.max(dp[nextDay][1]
                    ,dp[curDay][0]+price[nextDay]);
        }
        func(nextDay);


        nextDay = curDay+time[curDay];
        dp[nextDay][0] = Math.max(dp[nextDay][0]
                ,dp[curDay][1]);

        if(time[nextDay]+nextDay<=n+1) {
            dp[nextDay][1] = Math.max(dp[nextDay][1]
                    ,dp[curDay][1]+price[nextDay]);
        }
        func(nextDay);
    }
}
