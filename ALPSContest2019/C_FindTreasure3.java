package ALPSContest2019;

//incorrect

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.LinkedList;
import java.util.Queue;
import java.util.StringTokenizer;

class Point_FT {
    int x, y, k;
    public Point_FT(int x, int y, int k) {
        this.x=x;this.y=y;this.k=k;
    }
}

public class C_FindTreasure3 {
    static int n, m, l;
    static String [] s;
    static String[][] map;
    static int[][] visit;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); l = Integer.parseInt(st.nextToken());
        map = new String[n][m]; s = new String[l]; visit = new int[n][m];
        st = new StringTokenizer(br.readLine());
        s = st.nextToken().split("");
        for(int i=0;i<n;i++) {
            st = new StringTokenizer(br.readLine());
            map[i] = st.nextToken().split("");
        }
        bfs();
    }
    public static void bfs() {
        Queue<Point_FT> q = new LinkedList();
        q.add(new Point_FT(0, 0, 0));
        int curr = 0;
        int fpx = 0, fpy = 0, fpk = 0;
        boolean loop = false;
        while(!q.isEmpty()) {
            Point_FT pt = q.poll();
            if(visit[pt.x][pt.y]==1) {
                loop = true;
                break;
            }
            else {
                visit[pt.x][pt.y] = 1;
            }
            for(int i=0;i<4;i++) {
                int px = pt.x+dx[i]; int py = pt.y+dy[i];
                if(px>=0&&px<n&&py>=0&&py<m) {
                    if(s[curr+1].equals(map[px][py])) {
                        curr++;
                        if(curr==l-1) {
                            q.add(new Point_FT(px, py, pt.k+1));
                            fpx = px+1; fpy = py+1; fpk = pt.k+1;
                            curr=-1;
                        }
                        else {
                            q.add(new Point_FT(px, py, pt.k));
                        }
                    }
                }
            }
        }
        String result = loop? "-1" : fpk+"\n"+fpx+" "+fpy;
        System.out.println(result);
    }
}
