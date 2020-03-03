package Simulation;

import java.util.Scanner;
import java.util.Stack;

class point_Knight {
    int x; int y;
    point_Knight(int x, int y) {
        this.x = x;
        this.y = y;
    }
}

public class BJ_1331_KnightTour2 {
    static int[][] chess = new int[7][7];
    static int[] dx = {1, 1, -1, -1, 2, 2, -2, -2};
    static int[] dy = {2, -2, 2, -2, 1, -1, 1, -1};
    static Stack stack  = new Stack();
    static boolean flag = true;
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
        int cnt = 36;
        while(cnt>0) {
            for(int i=1;i<=6;i++) {
                for(int j=1;j<=6;j++) {
                    if(chess[i][j]==cnt) {
                        point_Knight pt = new point_Knight(i, j);
                        stack.push(pt);
                        cnt--;
                    }
                }
            }
        }
        point_Knight first = (point_Knight)stack.peek();
        Tour(first);
        if (flag) {
            System.out.println("Valid");
        }
        else {
            System.out.println("Invalid");
        }
    }
    public static void Tour(point_Knight first) {
//        int cnt = 1;
        while(!stack.isEmpty()&&flag==true) {
            point_Knight pt1 = (point_Knight) stack.pop();
//            System.out.println(cnt+" : "+pt1.x+", "+pt1.y);
            flag = false;
            if(stack.isEmpty()) {
                int xx = pt1.x-first.x;
                int yy = pt1.y-first.y;
                for(int i=0;i<8;i++) {
                    if(dx[i]==xx&&dy[i]==yy) {
                        flag = true;
                    }
                }
            }
            else {
                point_Knight pt2 = (point_Knight) stack.peek();
                int xx = pt1.x-pt2.x;
                int yy = pt1.y-pt2.y;

                for(int i=0;i<8;i++) {
                    if(dx[i]==xx&&dy[i]==yy) {
                        flag = true;
                    }
                }
//                cnt++;
            }

        }
    }
}
