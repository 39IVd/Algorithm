package Search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Lab {
    int y, x;
    public Lab(int y, int x) {
        this.y=y;
        this.x=x;
    }
}

public class BJ_14502_Laboratory2 {
    static int n, m;
    static int[][] init_lab = new int[10][10];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static List<Lab> clear = new LinkedList<>();
    static List<Lab> virus = new LinkedList<>();
    static int safe = 0;
    static int max = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                init_lab[i][j] = in.nextInt();
                if(init_lab[i][j]==0) {
                    clear.add(new Lab(i, j));
                    safe++;
                }
                else if(init_lab[i][j]==2) {
                    virus.add(new Lab(i, j));
                }
            }
        }
        combin(0, -1, init_lab);
        System.out.println(max);
    }
    public static void combin(int count, int num, int[][] new_lab) {
        if(count==3) {
            int[][] b_lab = new int[10][10];
            for(int i=0;i<n;i++) {
                for (int j = 0; j < m; j++) {
                    b_lab[i][j] = new_lab[i][j];
                }
            }

            for(int i=0;i<virus.size();i++) {
                bfs(virus.get(i), b_lab);
            }
            int ss = 0;
            for(int i=0;i<n;i++) {
                for (int j = 0; j < m; j++) {
                    if(b_lab[i][j]==0) {
                        ss++;
                    }
                }
            }
            max = Math.max(max, ss);

            return;
        }
        for(int i=num+1;i<clear.size();i++) {
            Lab new_wall = clear.get(i);
            new_lab[new_wall.y][new_wall.x] = 1;
            combin(count+1, i, new_lab);
            new_lab[new_wall.y][new_wall.x] = 0;
        }
    }
    public static void bfs(Lab virus, int[][] new_lab) {
        Queue<Lab> q = new LinkedList<>();
        q.add(virus);
        while (!q.isEmpty()) {
            Lab curr = q.poll();
            for(int k=0;k<4;k++) {
                int ny = curr.y+dy[k];
                int nx = curr.x+dx[k];
                if(ny>=0&&ny<n&&nx>=0&&nx<m) {
                    if(new_lab[ny][nx]==0) {
                        q.add(new Lab(ny, nx));
                        new_lab[ny][nx]=2;
                    }
                }
            }
        }
    }
}
