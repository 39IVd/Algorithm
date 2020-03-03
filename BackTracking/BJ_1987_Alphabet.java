package BackTracking;

import java.util.Scanner;

class Point_Alpha {
    int y, x;
    Point_Alpha(int y, int x) {
        this.y=y;this.x=x;
    }
}


public class BJ_1987_Alphabet {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static int[][] map = new int[30][30];
//    A=1 ... Z=26
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited = new int[30][30];
    static int[] alp = new int[27];
    static int max = 0;
    public static void main(String[] args) {
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            char[] s = in.nextLine().toCharArray();
            for(int j=0;j<m;j++) {
                map[i][j] = s[j]-64;
            }
        }
        visited[0][0] = 1;
        alp[map[0][0]] = 1;
        dfs(1, new Point_Alpha(0,0));
        System.out.println(max);
    }
    public static void dfs(int cnt, Point_Alpha curr) {
//        System.out.println(curr.y+","+curr.x+"->"+cnt);
        max = Math.max(max, cnt);
        if(curr.y==n-1&&curr.x==m-1) {
            return;
        }
        for(int i=0;i<4;i++) {
            int ny = curr.y+dy[i];
            int nx = curr.x+dx[i];
            if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                if(alp[map[ny][nx]]!=1&&visited[ny][nx]!=1) {
                    alp[map[ny][nx]] = 1;
                    visited[ny][nx] = 1;
                    dfs(cnt+1, new Point_Alpha(ny, nx));
                    alp[map[ny][nx]] = 0;
                    visited[ny][nx] = 0;
                }
            }
        }
    }
}
