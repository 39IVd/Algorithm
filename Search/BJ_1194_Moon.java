package Search;

import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Scanner;

class Point_Moon {
    int y, x, cnt;
    List<Integer> keylist = new LinkedList<>();
    int[][] visited;
    Point_Moon(int y, int x, int cnt, List keylist, int[][] visited) {
        this.y=y;this.x=x;this.cnt=cnt;
        this.keylist = keylist;
        this.visited = visited;
    }
}

public class BJ_1194_Moon {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static char[][] maze = new char[55][55];
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
    static Point_Moon start;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        n = in.nextInt();m = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            String[] s = in.nextLine().split("");
            for(int j=0;j<m;j++) {
                maze[i][j] = s[j].charAt(0);
                if(maze[i][j]=='0') {
                    start = new Point_Moon(i, j, 0, new LinkedList(), new int[55][55]);
                }
            }
        }
//        for(int i=0;i<n;i++) {
//            for (int j = 0; j < m; j++) {
//                System.out.print(maze[i][j]);
//            }
//            System.out.println();
//        }
        bfs();
        System.out.println((res==Integer.MAX_VALUE)? -1 : res);

    }
    public static void bfs() {
        Queue<Point_Moon> q = new LinkedList<>();
        q.add(start);
        while (!q.isEmpty()) {
            Point_Moon curr = q.poll();
            if(maze[curr.y][curr.x]>=97&&maze[curr.y][curr.x]<=122) {
                for(int i=0;i<n;i++) {
                    for(int j=0;j<m;j++) {
                        curr.visited[i][j]=0;
                    }
                }
//                System.out.println("key");
            }
            curr.visited[curr.y][curr.x] = 1;
//            System.out.println(curr.y+","+curr.x+"=> "+maze[curr.y][curr.x]+", "+curr.cnt);

            if(maze[curr.y][curr.x]=='1') {
                res = Math.min(res, curr.cnt);
                break;
            }
            for (int i = 0; i < 4; i++) {
                int ny = curr.y + dy[i];
                int nx = curr.x + dx[i];
                List<Integer> newList = new LinkedList<>();
                for(int j=0;j<curr.keylist.size();j++) {
                    newList.add(curr.keylist.get(j));
                }
                int[][] newVisited = new int[55][55];
                for(int j=0;j<n;j++) {
                    for(int k=0;k<m;k++) {
                        newVisited[j][k] = curr.visited[j][k];
                    }
                }
                if (ny >= 0 && ny < n && nx >= 0 && nx < m) {
                    if (maze[ny][nx]!='#' && curr.visited[ny][nx] != 1) {
                        if(maze[ny][nx]>=97&&maze[ny][nx]<=122) {
//                            key
                            newList.add(maze[ny][nx]-32);
                            q.add(new Point_Moon(ny, nx, curr.cnt+1, newList, newVisited));
                        }
                        else if(maze[ny][nx]>=65&&maze[ny][nx]<=90) {
//                            door
                            for(int k=0;k<curr.keylist.size();k++) {
                                if(curr.keylist.get(k)==maze[ny][nx]) {
                                    q.add(new Point_Moon(ny, nx, curr.cnt+1, newList, newVisited));
                                    break;
                                }
                            }
                        }
                        else {
//                            empty or exit
                            q.add(new Point_Moon(ny, nx, curr.cnt+1, newList, newVisited));
                        }
                    }
                }
            }
        }

    }
    public static void initVisit() {

    }
}
