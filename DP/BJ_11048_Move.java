package DP;

import java.util.Scanner;

public class BJ_11048_Move {
    static int n, m;
    static int[][] map = new int[1000][1000];
    static int[][] dp = new int[1000][1000];
    static int[] dy = {0, -1, -1};
    static int[] dx = {-1, 0, -1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                map[i][j] = in.nextInt();
            }
        }
        dp[0][0] = map[0][0];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                for(int k=0;k<3;k++) {
                    int by = i+dy[k];
                    int bx = j+dx[k];
                    if(by>=0&&by<n&&bx>=0&&bx<m) {
                        dp[i][j] = Math.max(dp[i][j], dp[by][bx]+map[i][j]);
                    }
                }
            }
        }
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(dp[n-1][m-1]);

    }
}
