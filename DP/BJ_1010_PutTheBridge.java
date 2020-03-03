package DP;

import java.util.Scanner;

public class BJ_1010_PutTheBridge {
    static int num;
    static int[] N, M;
    static int[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        num = in.nextInt();
        N= new int[num]; M = new int[num];
        for(int i=0;i<num;i++) {
            N[i] = in.nextInt(); M[i] = in.nextInt();
            dp = new int[num][N[i]+1];
            int d = (int)(N[i]/2);
            for(int j=0;j<d+1;j++) {
//                dp[num][j] =
            }
            for(int j=d+1;j<N[i]+1;j++) {
                dp[num][j] = dp[num][N[i]-j];
            }
        }
//        for(int i=0;i<num;i++) {
//            System.out.println(dp[i]);
//        }
    }
}
