package Simulation;

import java.util.Scanner;

public class BJ_14503_RobotVacuum {
    static int n,m;
    static int r,c,d;
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, 1, 0, -1};
//    상 우 하 좌
    static int[][] matrix;
    static int nextR, nextC, nextD;
    static int res = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m=in.nextInt();
        r=in.nextInt();c=in.nextInt();d=in.nextInt();
        matrix = new int[n][m];
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                matrix[i][j]=in.nextInt();
            }
        }
//        System.out.println();
//        for(int i=0;i<=n+1;i++) {
//            for(int j=0;j<=m+1;j++) {
//                System.out.print(matrix[i][j]+" ");
//            }
//            System.out.println();
//        }
        boolean isStop = false;
        while(true) {
            if(isStop) {
                break;
            }
            matrix[r][c] = 2;
//            if(d==0) d=3;
//            else d=d-1;

            System.out.println("current : "+(r)+", "+(c));
                    System.out.println();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                System.out.print(matrix[i][j]+" ");
            }
            System.out.println();
        }
            res++;
//            clear
            int cnt = 0;
            while(true) {
                if(cnt==4) {
//                    all positions are wall or already cleared
                    if(isStop) break;
                    if(d>1) nextD -=2;
                    else nextD +=2;
//                    go back
                    nextR = r+dx[nextD];
                    nextC = r+dy[nextD];
                    if(isWall(nextR, nextC)) {
                        isStop = true;
                        break;
                    }
                    else {
                        if(matrix[nextR][nextC]==1) {
//                        is wall?
//                        stop
                            isStop = true;
                            break;
                        }
                        else {
                            r = nextR; c = nextC;
                        }

                    }
                }
                if(d==0) nextD=3;
                else nextD=d-1;
//                turn left
                nextR = r+dx[nextD];
                nextC = c+dy[nextD];
                if(!isWall(nextR, nextC)) {
                    if(matrix[nextR][nextC]==0) {
                        d = nextD;
                        r = nextR; c = nextC;
//                    turn left and go
                        break;
                    }
                    else {
                        d = nextD;
                        System.out.println(cnt);
                        cnt++;
                    }
                }

                else {
//                    wall or already cleared
                    d = nextD;
                    System.out.println(cnt);
                    cnt++;
                }
            }

        }
        System.out.println(res);
    }
    public static boolean isWall(int r, int c) {
        if(r<=0||r>=n||c<=0||c>=m) {
            return true;
        }
        else {
            return false;
        }
    }
}
