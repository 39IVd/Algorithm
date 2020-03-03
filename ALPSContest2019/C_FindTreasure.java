package ALPSContest2019;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point_Treasure {
    int x,y,k;
    public Point_Treasure(int x, int y, int k) {
        this.x = x;this.y=y;this.k=k;
    }
}
public class C_FindTreasure {
    static int n, m, l;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    static String[] s;
    static String[][] matrix;
    static int[][] visited;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt(); l = in.nextInt();
        in.nextLine(); visited = new int[n+1][m+1];
        s = new String[l];
        s = in.nextLine().split("");
        matrix = new String[n+1][m+1];
        for(int i=1;i<=n;i++) {
            String[] str = in.nextLine().split("");
            for(int j=1;j<=m;j++) {
                matrix[i][j] = str[j-1];
            }
        }
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=m;j++) {
//                System.out.print(matrix[i][j]);
//            }
//            System.out.println();
//        }
        bfs();
    }
    public static void bfs() {
        Queue<Point_Treasure> q = new LinkedList();
        q.add(new Point_Treasure(1, 1, 0));
        int strcnt = 0;
        int nx=0, ny=0, nk=0;
        while(!q.isEmpty()) {
            Point_Treasure pt = q.poll();
            visited[pt.x][pt.y] = 1;
            nk = pt.k;
            if(matrix[pt.x][pt.y].equals(s[l-1])) {
                nk++;
                nx = pt.x; ny = pt.y;
                strcnt = -1;
            }
            strcnt++;
            boolean allvisit = true;
            for(int i=0;i<4;i++) {
                int px = pt.x+dx[i];
                int py = pt.y+dy[i];
                if(px>=1&&px<=n&&py>=1&&py<=m) {
                    if(matrix[px][py].equals(s[strcnt])&&
                            visited[px][py]!=1) {
                        q.add(new Point_Treasure(px, py, nk));
                    }
                    if(visited[px][py]!=1) {
                        allvisit = false;
                    }
                }
            }
            if(allvisit) {
                nk = -1;
            }
        }
        System.out.println(nk);
        if(nk!=-1) {
            System.out.println(nx+" "+ny);
        }
    }

}
