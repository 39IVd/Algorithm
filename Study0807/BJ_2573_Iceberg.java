package Study0807;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point_Iceberg {
    int x, y;
    public Point_Iceberg(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ_2573_Iceberg {
    static int N, M;
    static int[][] matrix;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
    static int year = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); M = in.nextInt();
        matrix = new int[N][M];
        visit = new int[N][M];
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        while(CountLump()<2) {
            initVisit();
            Sinking();
            year++;
        }
        System.out.println(year);
    }
    public static void Sinking() {
        for(int i=1;i<N-1;i++) {
            for(int j=1;j<M-1;j++) {
                if(matrix[i][j]!=0) {
                    int oc = 0;
                    for(int k=0;k<4;k++) {
                        int px = i+dx[k];
                        int py = j+dy[k];
                        if(inRange(px, py)) {
                            if(matrix[px][py]==0) {
                                oc++;
                            }
                        }
                    }
                    if(matrix[i][j]<=oc) {
                        matrix[i][j] = 0;
                    }
                    else {
                        matrix[i][j] -= oc;
                    }
                }
            }
        }
    }
    public static int CountLump() {
        int cnt = 0;
        Queue<Point_Iceberg> q = new LinkedList();
        boolean allzero = true;
        for(int i=1;i<N-1;i++) {
            for(int j=1;j<M-1;j++) {
                if(matrix[i][j]!=0&& visit[i][j]!=1) {
                    allzero = false;
                    q.add(new Point_Iceberg(i, j));
                    while(!q.isEmpty()) {
                        Point_Iceberg pt = q.poll();
                        visit[pt.x][pt.y] = 1;
                        for(int k=0;k<4;k++) {
                            int px = dx[k]+pt.x;
                            int py = dy[k]+pt.y;
                            if(inRange(px, py)) {
                                if(matrix[px][py]!=0 && visit[px][py]!=1) {
                                    q.add(new Point_Iceberg(px, py));
                                }
                            }
                        }
                    }
                    cnt++;
                }
            }
        }
        if(allzero) {
            year = 0;
            return 1000;
        }
        return cnt;
    }
    public static boolean inRange(int x, int y) {
        if(x>=0&&x<N&&y>=0&&y<M) {
            return true;
        }
        return false;
    }
    public static void initVisit() {
        for(int i=0;i<N;i++) {
            for(int j=0;j<M;j++) {
                visit[i][j] = 0;
            }
        }
    }
}
