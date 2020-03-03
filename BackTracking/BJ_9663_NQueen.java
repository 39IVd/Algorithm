package BackTracking;

import java.util.Scanner;

public class BJ_9663_NQueen {
    static int n;
    static int[][] chess; // 1이면 불가
    static int[] dx = {-1, 0, 1, 0, -1, -1, 1, 1};
    static int[] dy = {0, -1, 0, 1, -1, 1, -1, 1};
    static int count = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        chess = new int[n][n];
        dfs(1, 0, chess);
        System.out.println(count);
    }
    public static void dfs(int q, int currX, int[][] chess) {
        if(q==n+1) {
            count++;
            System.out.println("count : "+count);
            return;
        }
        for(int i=currX;i<n;i++) {
            for(int j=0;j<n;j++) {
                int[][] newChess = new int[n][n];
                for(int l=0;l<n;l++) {
                    for(int o=0;o<n;o++) {
                        newChess[l][o] = chess[l][o];
                    }
                }
                if(newChess[i][j]==0) {
                    newChess[i][j] = q*10;
                    int x = i, y = j;
                    for(int k=0;k<8;k++) { // 가로세로
                        x = i; y = j;
                        while(true) {
                            x += dx[k]; y += dy[k];
                            if(x>=0&&x<n&&y>=0&&y<n) {
                                newChess[x][y] = 1;
                            }
                            else {
                                break;
                            }
                        }
                    }

                    System.out.println(q+" : ");
                    for(int l=0;l<n;l++) {
                        for(int o=0;o<n;o++) {
                            System.out.print(newChess[l][o]+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    dfs(q+1, i, newChess);
                }
            }
        }

    }
}
