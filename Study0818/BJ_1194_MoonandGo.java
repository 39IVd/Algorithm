package Study0818;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

class Point_Moon {
    int x, y, cnt;
    public Point_Moon(int x, int y, int cnt) {
        this.x = x;
        this.y = y;
        this.cnt = cnt;
    }
}

public class BJ_1194_MoonandGo {
    static int n, m;
    static char[][] maze;
    static int[][] visited;
    static Point_Moon start;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n =in.nextInt();m = in.nextInt();
        in.nextLine();
        maze = new char[n][m]; visited = new int[n][m];
        for(int i=0;i<n;i++) {
            String[] st = in.nextLine().split("");
            for(int j=0;j<m;j++) {
                maze[i][j] = st[j].charAt(0);
                if(st[j].equals("0")) {
                    start = new Point_Moon(i, j, 0);
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(maze[i][j]);
            } System.out.println();
        }
        char low = 'A'+32;
        System.out.println(low);

        bfs();
        if(min==Integer.MAX_VALUE) {
            min = -1;
        }
        System.out.println(min);
    }
    public static void bfs() {
        Queue<Point_Moon> q = new LinkedList<>();
        Stack<Character> stack =  new Stack<>();
        q.add(start);
        while(!q.isEmpty()) {
            Point_Moon pt = q.poll();
            visited[pt.x][pt.y] = 1;
            char curr = maze[pt.x][pt.y];
            System.out.println(curr+" "+pt.cnt);
            if(curr=='1') {
                min = Math.min(min, pt.cnt);
                continue;
            }
            for(int i=0;i<4;i++) {
                int px = pt.x+dx[i];
                int py = pt.y+dy[i];
                if(px>=0&&px<n&&py>=0&&py<m) {
                    char next = maze[px][py];
                    if(isLower(curr)) {
                        q.add(new Point_Moon(px, py, pt.cnt+1));
                    }
                    if(visited[px][py]!=1) {
                        if(isLower(next)) {
                            stack.add(next);
                            q.add(new Point_Moon(px, py, pt.cnt+1));
                        }
                        else if(isUpper(next)) {
                            char low = (char)(next+32);
                            if(stack.contains(low)) {
                                stack.removeElement(low);
                                q.add(new Point_Moon(px, py, pt.cnt+1));
                            }
                            else {
                                visited[px][py] = 0;
                                visited[pt.x][pt.y] = 0;
                            }
                        }
                        else if(next=='.') {
                            q.add(new Point_Moon(px, py, pt.cnt+1));
                        }
                        else if(next=='0') {
                            q.add(new Point_Moon(px, py, pt.cnt+1));
                        }
                    }

                }
            }

        }

    }
    public static boolean isLower(char a) {
        if(a>='a'&&a<='f') {
            return true;
        }
        else {
            return false;
        }
    }
    public static boolean isUpper(char a) {
        if(a>='A'&&a<='F') {
            return true;
        }
        else {
            return false;
        }
    }

}
