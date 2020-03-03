package Study0807;

import java.util.Scanner;

public class BJ_1937_GreedyPanda2 {
    static int n;
    static int[][] matrix;
    static int[][] dp;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    static int max = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        matrix = new int[n][n]; dp = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                max = Math.max(max, dfs(i, j));
            }
        }
        System.out.println(max);
    }
    public static int dfs(int x, int y) {
        if(dp[x][y]!=0) return dp[x][y];
        int day = 1;
        for(int i=0;i<4;i++) {
            int px = x+dx[i];
            int py = y+dy[i];
            if(px>=0&&px<n&&py>=0&&py<n) {
                if(matrix[x][y]<matrix[px][py]) {
                    day = Math.max(day, dfs(px, py)+1);
                    dp[x][y] = day;
                }
            }
        }
        return day;
    }
}
