package Search;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Point_Bead {
    int y, x;

    Point_Bead(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BJ_13460_BeadEscape {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static char[][] map = new char[20][20];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static int[][] visited = new int[20][20];
    static int[][] visited2 = new int[20][20];

    static Point_Bead hole;
    static Point_Bead red, blue;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            char[] s = in.nextLine().toCharArray();
            for (int j = 0; j < m; j++) {
                map[i][j] = s[j];
                if (map[i][j] == '0') {
                    hole = new Point_Bead(i, j);
                } else if (map[i][j] == 'R') {
                    red = new Point_Bead(i, j);
                } else if (map[i][j] == 'B') {
                    blue = new Point_Bead(i, j);
                }
            }
        }
        bfs();
        System.out.println(res=(res==Integer.MAX_VALUE? -1 : res));
    }

    public static void bfs() {
        int cnt = -1;
        Queue<Point_Bead> q = new LinkedList<>();
        q.add(red);
        Queue<Point_Bead> q2 = new LinkedList<>();
        q2.add(blue);


        while (!q.isEmpty()) {
            Point_Bead pt = q.poll();
            Point_Bead pt2 = q2.poll();
            visited[pt.y][pt.x] = 1;
            visited2[pt2.y][pt2.x] = 1;

            System.out.println("red : "+pt.y+","+pt.x+"=>"+cnt);
            System.out.println("blue : "+pt2.y+","+pt2.x+"=>"+cnt);

            cnt++;
            int py = pt.y;
            int px = pt.x;
            int py2 = pt2.y;
            int px2 = pt2.x;
            for (int i = 0; i < 4; i++) {
                while (true) {
                    py += dy[i];
                    px += dx[i];
//                    py2 += dy[i];
//                    px2 += dx[i];
//                    System.out.println("q_red : "+py+","+px+"=>"+cnt);
//                    System.out.println("q_blue : "+py2+","+px2+"=>"+cnt);
                    if (py < 0 || py >= n && px < 0 && px >= m) {
                        break;
                    }
                    if(visited[py][px]!=1) {
                        if (map[py][px] == '#') {
                            break;
                        }

                        else if (map[py][px] == '0') {
                            res = cnt;
                        }
                        map[py][px] = 'R';
                        pt.y = py;
                        pt.x = px;
                    }

//                    if (py2 < 0 || py2 >= n && px2 < 0 && px2 >= m) {
//                        break;
//                    }
//                    if(visited2[py2][px2]!=1) {
//                        if (map[py2][px2] == '#') {
//                            break;
//                        }
//                        else if (map[py2][px2] == 'R') {
//                            break;
//                        }
//                        else if (map[py2][px2] == '0') {
//
//                        }
//                        map[py2][px2] = 'B';
//                        pt2.y = py2;
//                        pt2.x = px2;
//                    }

                }
                q.add(new Point_Bead(pt.y, pt.x));
                q2.add(new Point_Bead(pt2.y, pt2.x));


            }
        }
    }

}
