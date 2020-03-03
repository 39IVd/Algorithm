package Simulation;

import java.util.Scanner;

public class BJ_1331_KnightTour {
    static int[][] chess = new int[7][7];
    static int[][] visit = new int[7][7];
    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static boolean flag = false;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        String[] input = new String[2];
        int count = 1;
        for(int i=0;i<36;i++) {
            input = scan.nextLine().split("");
            int column = 0;
            int row = Integer.parseInt(input[1]);
            switch (input[0]) {
                case "A": column = 1;
                    break;
                case "B": column = 2;
                    break;
                case "C": column = 3;
                    break;
                case "D": column = 4;
                    break;
                case "E": column = 5;
                    break;
                case "F": column = 6;
                    break;
            }
            chess[column][row] = count;
            count++;
        }
//        for(int i=1;i<=6;i++) {
//            for(int j=1;j<=6;j++) {
//                System.out.print(chess[i][j]+" ");
//            }
//            System.out.println();
//        }
        for(int i=1;i<=6;i++) {
            for(int j=1;j<=6;j++) {
                if(chess[i][j]==1) {
                    Tour(i, j, 1);
                }
            }
        }
        if (flag) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
//        for(int i=1;i<=6;i++) {
//            for(int j=1;j<=6;j++) {
//                System.out.print(visit[i][j]+" ");
//            }
//            System.out.println();
//        }
    }
    public static void Tour(int x, int y, int count) {
        visit[x][y] = 1;
        if(chess[x][y]==36) {
            for(int i=0;i<8;i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (isRange(xx, yy)) {
                    if (chess[xx][yy] == 1 && visit[xx][yy]==1) {
                        TourEnd();
                    }
                }
            }
        }
        else {
            flag = false;
            for(int i=0;i<8;i++) {
                int xx = x + dx[i];
                int yy = y + dy[i];
                if (isRange(xx, yy)) {
                    if (chess[xx][yy] == count+1 && visit[xx][yy]!=1) {
                        Tour(xx, yy, count+1);
                        flag = true;
                    }
                }
            }
        }

    }
    public static void TourEnd() {
        for(int i=1;i<=6;i++) {
            for(int j=1;j<=6;j++) {
                if(visit[i][j]!=1) {
                    flag = false;
                }
            }
        }
        flag = true;
    }
    public static boolean isRange(int x, int y) {
        if(x>0&&y>0&&x<7&&y<7) {
            return true;
        }
        else {
            return false;
        }
    }
}
