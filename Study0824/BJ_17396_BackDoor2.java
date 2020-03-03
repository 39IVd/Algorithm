package Study0824;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Door {
    int index, time;
    public Door(int index, int time) {
        this.index = index;
        this.time = time;
    }
}

public class BJ_17396_BackDoor2 {
    static int n, m;
    static int[] point;
    static int[][] visit;
    static int[][] graph;
    static int min = 1000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        point = new int[n];
        graph = new int[n][n];
        visit = new int[n][n];
        for(int i=0;i<n;i++) {
            point[i] = in.nextInt();
            for(int j=0;j<n;j++) {
                graph[i][j] = 0;
            }
        }
        point[n-1] = 0;
        for(int i=0;i<m;i++) {
            int p1 = in.nextInt();
            int p2 = in.nextInt();
            int t = in.nextInt();
            if(point[p1]==0&&point[p2]==0) {
                graph[p1][p2] = t;
                graph[p2][p1] = graph[p1][p2];
            }
        }
//        System.out.println();
//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(graph[i][j]+" ");
//            }
//            System.out.println();
//        }
        bfs();
        if(min==1000) {
            min = -1;
        }
        System.out.println(min);
    }
    public static void bfs() {
        Queue<Door> q = new LinkedList();
        q.add(new Door(0, 0));
        visit[0][0] = 1;
        while(!q.isEmpty()) {
            Door curr = q.poll();
            if(curr.index==n-1) {
                min = Math.min(min, curr.time);
                System.out.println("end : "+min);
//                for(int i=1;i<n;i++) {
//                    visit[i] = 0;
//                }
            }
            for(int i=0;i<n;i++) {
                if(visit[curr.index][i]!=1&&graph[curr.index][i]!=0) {
                    q.add(new Door(i, curr.time+graph[curr.index][i]));
                    visit[curr.index][i] = 1; visit[i][curr.index] = 1;
                    System.out.println(curr.index+"-"+i+" : "+(curr.time+graph[curr.index][i])+"초");
                }
            }
        }
    }
}
