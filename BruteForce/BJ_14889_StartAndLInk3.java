package BruteForce;

import java.util.Scanner;

public class BJ_14889_StartAndLInk3 {
    static int n;
    static int[][] team = new int[20][20];
    static int[] init_visited = new int[20];
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                team[i][j] = in.nextInt();
            }
        }

        combin(0, -1, init_visited);
        System.out.println(min);
    }
    public static void combin(int count, int num, int[] visited) {
        if(count==n/2) {
            int start = 0, link = 0;
            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
                    if(visited[i]==1&&visited[j]==1&&i!=j) {
                        start+=team[i][j];
                    }
                    else if(visited[i]==0&&visited[j]==0&&i!=j) {
                        link+=team[i][j];
                    }
                }
//                System.out.print(visited[i]+" ");
            }
//            System.out.println();
            min = Math.min(min, Math.abs(start-link));
            return;
        }
        for(int i=num+1;i<n;i++) {
            visited[i] = 1;
            combin(count+1, i, visited);
            visited[i] = 0;
        }
    }
}
