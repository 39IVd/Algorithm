package Baekjoon;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;
class position {
    int x, y;
    char color;
    public position(int x, int y, char color) {
        this.x = x;
        this.y = y;
        this.color = color;
    }
}
public class BJ_10026_ColorBlindness {
    static int n;
    static char[][] matrix;
    static int[][] visited;
    static int[] dx = {-1, 1, 0, 0};
    static int[] dy = {0, 0, -1, 1};
    static int count_normal= 0, count_blind = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        in.nextLine();
        matrix = new char[n][n];
        visited = new int[n][n];
        for(int i=0;i<n;i++) {
            String line = in.nextLine();
            for(int j=0;j<n;j++) {
                matrix[i][j] = line.charAt(j);
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]!=1) {
                    bfs(i, j, matrix[i][j]);
                    count_normal++;
                }
            }
        }
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                visited[i][j]= 0;
            }
        }
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (visited[i][j]!=1) {
                    bfs_blind(i, j, matrix[i][j]);
                    count_blind++;
                }
            }
        }
        System.out.println(count_normal+" "+count_blind);
    }
    public static void bfs(int h, int v, char color) {
        Queue<position> q = new LinkedList();
        q.add(new position(h, v, color));
        visited[h][v] = 1;
        while(!q.isEmpty()) {
            position pt = (position)q.poll();
            char currcolor = pt.color;
//            System.out.println(pt.x+", "+pt.y+" : "+pt.color);
            for(int i=0;i<4;i++) {
                int x = dx[i] +pt.x;
                int y = dy[i] +pt.y;
                if(x>=0 && x<n && y>=0 && y<n) {
                    if(matrix[x][y]==currcolor && visited[x][y]!=1) {
                        q.add(new position(x,y, matrix[x][y]));
                        visited[x][y] = 1;
                    }
                }
            }
        }
    }
    public static void bfs_blind(int h, int v, char color) {
        Queue<position> q = new LinkedList();
        q.add(new position(h, v, color));
        visited[h][v] = 1;
        while(!q.isEmpty()) {
            position pt = (position)q.poll();
            char currcolor = pt.color;
//            System.out.println(pt.x+", "+pt.y+" : "+pt.color);
            for(int i=0;i<4;i++) {
                int x = dx[i] +pt.x;
                int y = dy[i] +pt.y;
                if(x>=0 && x<n && y>=0 && y<n) {
                    if(visited[x][y]!=1) {
                        if(currcolor!='B'&&matrix[x][y]!='B') {
                            q.add(new position(x,y, matrix[x][y]));
                            visited[x][y] = 1;
                        }
                        else if (currcolor==matrix[x][y]) {
                            q.add(new position(x,y, matrix[x][y]));
                            visited[x][y] = 1;
                        }
                     }
                }
            }
        }
    }

}