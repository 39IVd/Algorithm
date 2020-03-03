package DP;

import java.util.Scanner;

public class BJ_2156_WineTasting {
    static int N;
    static int[][] wine;

    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt();
        wine = new int[2][N+1];
        wine[0][0] = wine[1][0] = 0;
        for(int i=1;i<=N;i++) {
            wine[0][i] = wine[1][i] = scan.nextInt();
        }
        DP();
        for(int i=0;i<2;i++) {
            for(int j=0;j<=N;j++) {
                System.out.print(wine[i][j]+" ");
            }
            System.out.println();
        }
    }
    public static void DP() {
        for(int j=2;j<=N;j++) {
            wine[0][j] += wine[1][j-1];
            wine[1][j] += Max(wine[0][j-2], wine[1][j-2]);
        }
        int maxN = Max(wine[0][N], wine[1][N]);
        int maxN_1 = Max(wine[0][N-1], wine[1][N-1]);
        System.out.println(Max(maxN, maxN_1));
    }
    public static int Max(int a, int b) {
        return a>b? a : b;
    }
}
