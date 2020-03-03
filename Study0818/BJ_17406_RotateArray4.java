package Study0818;

import java.util.Scanner;

class info {
    int r, c, s;
    public info(int r, int c, int s) {
        this.r = r;
        this.c = c;
        this.s = s;
    }
}
public class BJ_17406_RotateArray4 {
    static int n, m, k;
    static int[][] matrix;
    static int[][] t_matrix;
    static info[] arr; static int[] visit;
    static info[] temp_arr;
    static int min = 10000;

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt(); k = in.nextInt();
        matrix = new int[n+1][m+1]; t_matrix = new int[n+1][m+1];
        arr = new info[k]; visit = new int[k]; temp_arr = new info[k];
        for(int i=1;i<=n;i++) {
            for(int j=1;j<=m;j++) {
                matrix[i][j] = in.nextInt();
            }
        }
        for(int i=0;i<k;i++) {
            arr[i] = new info(in.nextInt(), in.nextInt(), in.nextInt());
        }
        dfs(0);
        System.out.println(min);
    }
    public static void dfs(int len) {
        if(len==k) {
            for(int i=1;i<=n;i++) {
                for(int j=1;j<=m;j++) {
                    t_matrix[i][j] = matrix[i][j];
                }
            }
            Rotation();
            return;
        }
        for(int i=0;i<k;i++) {
            if(visit[i]!=1) {
                visit[i] = 1;
                temp_arr[len] = arr[i];
                dfs(len+1);
                visit[i] = 0;
            }
        }
    }
    public static void Rotation() {
        for(int l=0;l<k;l++) {
            int r = temp_arr[l].r; int c = temp_arr[l].c; int s = temp_arr[l].s;
            while(s>0) {
                int tmp = t_matrix[r-s][c-s];
                for(int i=r-s;i<=r+s-1;i++) {
                    t_matrix[i][c-s] = t_matrix[i+1][c-s];
                }
                for(int i=c-s;i<=c+s-1;i++) {
                    t_matrix[r+s][i] = t_matrix[r+s][i+1];
                }
                for(int i=r+s;i>=r-s+1;i--) {
                    t_matrix[i][c+s] = t_matrix[i-1][c+s];
                }
                for(int i=c+s;i>=c-s+1;i--) {
                    t_matrix[r-s][i] = t_matrix[r-s][i-1];
                }
                t_matrix[r-s][c-s+1] = tmp;
                s--;
            }
        }
        min = Math.min(min, Cal());
    }
    public static int Cal() {
        for(int i=1;i<=n;i++) {
            int t = 0;
            for(int j=1;j<=m;j++) {
                t+=t_matrix[i][j];
            }
            min = Math.min(min, t);
        }
        return min;
    }
}
