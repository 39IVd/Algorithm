package Study0824;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point_Shark {
    int x, y, cnt;
    public Point_Shark(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class BJ_16236_BabyShark {
    static int n;
    static int[][] map;
    static int[][] visit;
    static Point_Shark start;
    static int t = 0, b = 2, e = 0;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); map = new int[n][n];
        visit = new int[n][n];
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                if(map[i][j]==9) {
                    start = new Point_Shark(i, j, 0);
                }
            }
        }
        find();
        System.out.println(t);
    }
    public static void find() {
        Queue<Point_Shark> q = new LinkedList<>();
        int min = 100;
        q.add(start);
        boolean boo = true;
        while(boo) {
            min = 100;
            int dist = 1000;
            Point_Shark fish = new Point_Shark(100, 100, 0);
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(map[i][j]!=0&&map[i][j]<b&&map[i][j]<min) {
                        int d = i-start.x+j-start.y;
                        if(d<dist&&i<fish.x) {//
                            dist = d;
                            min = map[i][j];
                            fish = new Point_Shark(i, j, 0);
                            q.clear();
                            System.out.println("f"+fish.x); // 무한루프
                        }
                    }
                }
            }
            if(min==100) {boo = false;}
            while(!q.isEmpty()) {
                Point_Shark pt = q.poll();
                visit[pt.x][pt.y] = 1;
                if(pt.x==fish.x&&pt.y==fish.y) {
                    map[pt.x][pt.y] = 0;
                    t += pt.cnt;
                    e++;
                    start = new Point_Shark(pt.x, pt.y, 0);
                    q.add(start);
                    initVIsit();
                    if(b==e) {
                        b++; e = 0;
                    }
                }
                for(int i=0;i<4;i++) {
                    int px = pt.x+dx[i];
                    int py = pt.y+dy[i];
                    if(px>=0&&px<n&&py>=0&&py<n) {
                        if(map[px][py]<=b&&visit[px][py]!=1) {
                            q.add(new Point_Shark(px, py, pt.cnt+1));
                        }
                    }
                }

            }
        }
    }
    public static void initVIsit() {
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visit[i][j]  = 0;
            }
        }
    }
}
