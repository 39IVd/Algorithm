package DP;

import java.util.Scanner;

public class BJ_2133_TileFilling {
    static int n;
    static int res;
    static int cnt = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        res = n;
        dfs(n*3, 0);
        System.out.println(cnt);
    }
    public static void dfs(int res, int col) {
        if(col==3) {
            cnt++;
            return;
        }
        if(res==0) {
            return;
        }
        dfs(res-2, col+1);

        dfs(res-2, col+2);
    }
}
