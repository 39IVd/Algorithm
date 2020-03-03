package Simulation;

import java.util.LinkedList;
import java.util.Queue;
import java.util.Scanner;

class Snake {
    int y, x;
    public Snake(int y, int x) {
        this.y = y;
        this.x = x;
    }
}

public class BJ_3190_Snake {
    static int n;
    static int[][] map = new int[100][100];
    static int k, l;
    static int[] dy = {-1, 0, 1, 0};
    static int[] dx = {0, 1, 0, -1};
//    상 우 하 좌
//    0 1 2 3
    static int[] time = new int[10000];
    static int seconds =1;
    static Queue<Snake> list = new LinkedList<>();
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                map[i][j] = 0;
            }
        }
        for(int i=0;i<k;i++) {
            int y = in.nextInt();
            int x = in.nextInt();
            map[y-1][x-1] = 4;
        }
        l = in.nextInt();
        in.nextLine();
        for(int i=0;i<l;i++) {
            String[] s = in.nextLine().split(" ");
            int sec = Integer.parseInt(s[0]);
            if(s[1].equals("L")) time[sec] = -1;
//            왼쪽 90 회전 => d -=1
            else time[sec] = 1;
//            오른쪽 회전 => d +=1
        }

        int y = 0,  x= 0;
        int d = 1; // 우
        map[y][x] = 1;
        list.add(new Snake(y, x));
        while (true) {
            int ny = y + dy[d];
            int nx = x + dx[d];
//            System.out.println("d : "+d);
//            System.out.println(ny+","+nx);
            if(ny<0||ny>=n||nx<0||nx>=n) {
//                벽
                break;
            }
            if(map[ny][nx]==1) {
//                자기 자신
                break;
            }
            list.add(new Snake(ny, nx));

            if(map[ny][nx]!=4) {
//                사과가 아니면
                Snake tail = list.poll();
                map[tail.y][tail.x] = 0;
            }
            map[ny][nx] = 1;
            if(time[seconds]==-1) {
//                왼쪽 회전
                if(d==0) d = 3;
                else d -=1;
            }
            else if(time[seconds]==1) {
//                오른쪽 회전
                if(d==3) d = 0;
                else d +=1;
            }
            y = ny; x = nx;

            seconds++;
        }

//        for(int i=0;i<n;i++) {
//            for(int j=0;j<n;j++) {
//                System.out.print(map[i][j]+" ");
//            }
//            System.out.println();
//        }

        System.out.println(seconds);
    }
}
