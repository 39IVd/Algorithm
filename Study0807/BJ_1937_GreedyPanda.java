package Study0807;

import java.util.Scanner;

public class BJ_1937_GreedyPanda {
    static int n;
    static int[][] matrix;
    static int[][] dp;
    static int[] dx = {0, 1, -1, 0};
    static int[] dy = {1, 0, 0, -1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        matrix = new int[n][n]; dp = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        System.out.println(calDP());
    }
    public static int calDP() {
        int max = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                dp[i][j] = dfs(i, j, 1);
                for(int k=2;k<4;k++) {
                    int px = i+dx[k];
                    int py = j+dy[k];
                    if(px>=0&&px<n&&py>=0&&py<n) {
                        if(matrix[i][j]<matrix[px][py]
                                && dp[i][j]<dp[px][py]+1) {
                            dp[i][j] = dp[px][py]+1;
                        }
                    }
                }
                max = Math.max(max, dp[i][j]);
            }
        }
//        printDP();
        return max;
    }
    public static int dfs(int x, int y, int cnt) {
        for(int i=0;i<2;i++) {
            int px = x+dx[i];
            int py = y+dy[i];
            if(px>=0&&px<n&&py>=0&&py<n) {
                if(matrix[x][y]<matrix[px][py]) {
                    dfs(px, py, cnt++);
                }
            }
        }
        return cnt;
    }
//    public static void printDP() {
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(dp[i][j]+" ");
//            }
//            System.out.println();
//        }
//    }
}
