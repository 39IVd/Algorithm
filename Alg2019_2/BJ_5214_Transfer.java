package Alg2019_2;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Station {
    int num; int cnt;
    public Station(int num, int cnt) {
        this.num = num; this.cnt = cnt;
    }
}
public class BJ_5214_Transfer {
    static int n, k, m;
    static int[][] path; // 갈 수 있는 역 표시
    static int[] visit;
    static int[] conn; // 연결하는 역의 개수
    static int min = 1000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt(); m = in.nextInt();
        path = new int[n+1][n+1]; visit = new int[n+1];
        conn = new int[k];
        for(int i=0;i<m;i++) {
            for(int j=0;j<k;j++) {
                conn[j] = in.nextInt();
            }
            for(int j=0;j<k;j++) {
                for(int l=0;l<k;l++) {
                    if (j != l) {
                        path[conn[j]][conn[l]] = 1;
                    }
                }
            }
        }
//        for(int i=1;i<=n;i++) {
//            for(int j=1;j<=n;j++) {
//                System.out.print(path[i][j]+" ");
//            }
//            System.out.println();
//        }
        bfs();
        System.out.println(min);
    }
    public static void bfs() {
        Station start = new Station(1, 1);
        Queue<Station> q = new LinkedList();
        q.add(start);
        while(!q.isEmpty()) {
            Station curr = q.poll();
//            System.out.println(curr.num+" : "+curr.cnt);
            visit[curr.num] = 1;
            if(curr.num==n) {
                min = Math.min(min, curr.cnt);
                return;
            }
            for(int i=1;i<=n;i++) {
                if(path[curr.num][i]==1&&visit[i]!=1) {
                    q.add(new Station(i, curr.cnt+1));
                }
            }
        }
    }
}
