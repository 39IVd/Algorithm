package Study0824;

import java.util.Scanner;

class Point_Dragon {
    int x, y, d, g;
    public Point_Dragon(int x, int y, int d, int g) {
        this.x=x;this.y=y;this.d=d;this.g=g;
    }
}
public class BJ_15685_DragonCurve {
    static int n;
    static int[][] matrix = new int[100][100];
    static Point_Dragon[] pd;
    static int[] dx = {1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1};
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        pd = new Point_Dragon[n];
        for(int i=0;i<n;i++) {
            pd[i] = new Point_Dragon(in.nextInt(),in.nextInt(),in.nextInt(),in.nextInt());
        }


    }
    public void makeCurve(Point_Dragon dragon) {

    }
}
