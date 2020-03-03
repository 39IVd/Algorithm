package Greedy;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class Point_Mat {
    int y, x;
    public Point_Mat(int y, int x) {
        this.y=y;this.x=x;
    }
}

public class BJ_1080_Matrix {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static int[][] A = new int[60][60];
    static int[][] B = new int[60][60];
    static List<Point_Mat> list = new LinkedList<>();
    static int[] visited;
    static int res = Integer.MAX_VALUE;
    public static void main(String[] args) {
        n = in.nextInt();
        m = in.nextInt();
        in.nextLine();
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            for (int j = 0; j < m; j++) {
                A[i][j] = Integer.parseInt(s[j]);
            }
        }
        for (int i = 0; i < n; i++) {
            String[] s = in.nextLine().split("");
            for (int j = 0; j < m; j++) {
                B[i][j] = Integer.parseInt(s[j]);
            }
        }
        for(int i=0;i<=n-3;i++) {
            for(int j=0;j<=m-3;j++) {
                list.add(new Point_Mat(i, j));
            }
        }
        visited = new int[list.size()];
//        for(int i=0;i<list.size();i++) {
//            System.out.println(list.get(i).y+","+list.get(i).x);
//        }
        permu(0,0, A);
        System.out.println(res=(res==Integer.MAX_VALUE? -1 : res));

    }
    public static void permu(int cnt, int num, int[][] matrix) {
        boolean same = true;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                if(matrix[i][j]!=B[i][j]) {
                    same = false;
                }
            }
        }
        if(same) {
            res = Math.min(res, cnt);
        }
        Point_Mat pt = list.get(num);
        for(int i=0;i<list.size();i++) {
            if(visited[i]!=1) {
                visited[i]=1;
                trans(pt.y,  pt.x, matrix);
                permu(cnt+1, i,matrix);
                visited[i]=0;
            }
        }
    }
    public static void trans(int y, int x, int[][] matrix) {
        for(int i=y;i<y+3;i++) {
            for(int j=x;j<x+3;j++) {
                if(matrix[i][j]==0) matrix[i][j] = 1;
                else if(matrix[i][j]==1) matrix[i][j] = 0;
            }
        }
    }
}
