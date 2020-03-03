package Study0807;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point_Wall {
    int x, y, cnt;
    boolean b;
    public Point_Wall(int x, int y, boolean b, int cnt) {
        this.x = x; this.y = y;
        this.b = b; this.cnt = cnt;
    }
}
public class BJ_2206_BreaktheWallandMove {
    static int n, m;
    static int[][] map;
    static int[][][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static int min = 10000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        map = new int[n][m]; visit = new int[2][n][m];
        for(int i=0;i<n;i++) {
            String str = in.nextLine();
            for(int j=0;j<m;j++) {
                map[i][j] = Integer.parseInt(str.charAt(j)+"");
            }
        }
        bfs();
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<m;j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }
        System.out.println(min==10000? -1:min);
    }
    public static void bfs() {
        Queue<Point_Wall> q = new LinkedList();
        q.add(new Point_Wall(0, 0, false, 1));
        while(!q.isEmpty()) {
            Point_Wall pt = q.poll();
            if(pt.x==n-1&&pt.y==m-1) {
                min = Math.min(min, pt.cnt);
                continue;
            }
            for(int i=0;i<4;i++) {
                int px = pt.x+dx[i];
                int py = pt.y+dy[i];
                if(px>=0&&px<n&&py>=0&&py<m) {
                    if(pt.b==true) { // 벽 부순 상태
                        if(visit[1][px][py]!=1&&map[px][py]==0) {
                            visit[1][px][py]=1;
                            q.add(new Point_Wall(px, py, true, pt.cnt+1));
                        }
                    }
                    else { // 벽 안부순 상태
                        if(map[px][py]==1&&visit[1][px][py]!=1) { // 벽이면 부숨
                            visit[1][px][py]=1;
                            q.add(new Point_Wall(px, py, true, pt.cnt+1));
                        }
                        else if(map[px][py]==0&&visit[0][px][py]!=1) { // 벽이 아니면 그냥 진행
                            visit[0][px][py]=1;
                            q.add(new Point_Wall(px, py, false, pt.cnt+1));
                        }
                    }
                }
            }
        }
    }
}
