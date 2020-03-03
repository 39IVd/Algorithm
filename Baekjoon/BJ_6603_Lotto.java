package Baekjoon;

import java.util.Scanner;

public class BJ_6603_Lotto {
    static int[][] S;
    static int n;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int count=0;
        S = new int[10000][];
        while(true) {
            String[] line = in.nextLine().split(" ");
            int k = Integer.parseInt(line[0]);
            if(k==0) break;
            S[count] = new int[k];
            for(int j=0;j<k;j++) {
                S[count][j] = Integer.parseInt(line[j+1]);
            }
            count++;
        }
        for(int i=0;i<count;i++) {
            dfs(i, 0, 0, "");
//            for(int j=0;j<S[i].length;j++) {
//                dfs(i, j, 0, "");
//            }
            System.out.println();
        }
    }
    public static void dfs(int i, int j, int num, String s) {
        if(num==6) {
            System.out.println(s);
        }
        else {
            if(j<S[i].length) {
                dfs(i, j+1, num+1, s+S[i][j]+" ");
                dfs(i, j+1, num, s);
            }
        }
    }
}
