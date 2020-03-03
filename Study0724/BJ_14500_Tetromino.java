package Study0724;

import java.util.Scanner;

public class BJ_14500_Tetromino {
    static int N, M;
    static int[][] paper;
    static int[][] visit;
    static int[] dx = {1, -1, 0, 0};
    static int[] dy = {0, 0, 1, -1};
    static int max = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); M = in.nextInt();
        paper = new int[N][M]; visit = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                paper[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                visit[i][j] = 1;
                dfs(i, j, 0, 0);
                visit[i][j] = 0;
                Exception(i, j);
            }
        }
        System.out.println(max);
    }
    public static void dfs(int x, int y, int depth, int sum) {
        if(depth==4) {
            max = Math.max(max, sum);
            return;
        }
        for(int i=0;i<4;i++) {
            int nextX = x+dx[i]; int nextY = y+dy[i];
            if(nextX<0||nextY<0||nextX>=N||nextY>=M) {
                continue;
            }
            if(visit[nextX][nextY]==1) {
                continue;
            }
            visit[nextX][nextY]=1;
            dfs(nextX, nextY, depth+1, sum+paper[nextX][nextY]);
            visit[nextX][nextY]=0;
        }
    }
    public static void Exception(int x, int y) {
        if((x==0||x==N-1)&&(y==0||y==M-1)) {
            return;
        }
        int sum = paper[x][y];
        if(x==0){
            sum += paper[x][y-1]+paper[x][y+1]+paper[x+1][y];
        }
        else if(x==N-1) {
            sum += paper[x][y-1]+paper[x][y+1]+paper[x-1][y];

        }
        else if(y==0) {
            sum += paper[x][y+1]+paper[x+1][y]+paper[x-1][y];
        }
        else if(y==M-1) {
            sum += paper[x][y-1]+paper[x+1][y]+paper[x-1][y];
        }
        else {
            sum = Math.max(sum, paper[x][y]+paper[x][y-1]+paper[x][y+1]+paper[x+1][y]);
            sum = Math.max(sum, paper[x][y]+paper[x][y-1]+paper[x][y+1]+paper[x-1][y]);
            sum = Math.max(sum, paper[x][y]+paper[x][y+1]+paper[x+1][y]+paper[x-1][y]);
            sum = Math.max(sum, paper[x][y]+paper[x][y-1]+paper[x+1][y]+paper[x-1][y]);
        }
        max = Math.max(max, sum);
    }

}
