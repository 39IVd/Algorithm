package Alg2019_2;

import java.util.Scanner;

public class BJ_1495_Guitarist4 {
    static int n, s, m;
    static int[] V;
    static int max = -1;
    static boolean[][] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); s = in.nextInt(); m = in.nextInt();
        V = new int[n+1]; dp = new boolean[n+1][m+1];
        for(int i=1;i<=n;i++) {
            V[i] = in.nextInt();
        }
        dp[0][s] = true;
        cal();
        System.out.println(max);
    }
    public static void cal() {
        for(int i=1;i<=n;i++) {
            for(int j=0;j<=m;j++) {
                if(dp[i-1][j]) {
                    int vol = j+V[i];
                    if(vol>=0&&vol<=m) {
                        dp[i][vol] = true;
                        if(i==n) {
                            max = Math.max(max, vol);
                        }
//                        System.out.println(i+" : "+vol);
                    }
                    vol = j-V[i];
                    if(vol>=0&&vol<=m) {
                        dp[i][vol] = true;
                        if(i==n) {
                            max = Math.max(max, vol);
                        }
//                        System.out.println(i+" : "+vol);
                    }
                }
            }
        }
    }
}
