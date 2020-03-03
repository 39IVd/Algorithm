package Alg2019_2;

import java.util.Scanner;

public class BJ_1495_Guitarist3 {
    static int n, s, m;
    static int[] V;
    static int max = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); s = in.nextInt(); m = in.nextInt();
        V = new int[n+1];
        V[0] = s;
        for(int i=1;i<=n;i++) {
            V[i] = in.nextInt();
        }
        dfs(0, 5);
        System.out.println(max);
    }
    public static void dfs(int i, int curr) {
        System.out.println(i+" : "+curr);
        if(i==n) {
            max = Math.max(max, curr);
            System.out.println("max : "+max);
            return;
        }
        int next = curr+V[i+1];
        if(next>=0&&next<=m) {
            dfs(i+1, next);
        }
        next = curr-V[i+1];
        if(next>=0&&next<=m) {
            dfs(i+1, next);
        }
    }
}
