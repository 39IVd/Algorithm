package BruteForce;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class point_Chicken {
    int y, x;
    public point_Chicken(int y, int x) {
        this.y = y;
        this.x=x;
    }
}

public class BJ_15686_ChickenStreet {
    static int n,m;
    static int[][] init_map = new int[50][50];
    static int[][] new_map = new int[50][50];
    static point_Chicken[] chicken = new point_Chicken[15];
    static List<point_Chicken> chickenList = new LinkedList<>();
    static List<point_Chicken> home = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        for(int i=0;i<n;i++) {
            for(int j=0;j<n;j++) {
                init_map[i][j] = in.nextInt();
                if(init_map[i][j]==2) {
                    chickenList.add(new point_Chicken(i, j));
                    init_map[i][j] = 0;
                }
                else if(init_map[i][j]==1) {
                    home.add(new point_Chicken(i, j));
                }
                new_map[i][j] = init_map[i][j];
            }
        }
        combin(0, -1, chicken);
        System.out.println(min);
    }
    public static void combin(int count, int num, point_Chicken[] chicken) {
        if(count==m) {
            for(int i=0;i<m;i++) {
                point_Chicken c = chicken[i];
                new_map[c.y][c.x] = 2;
            }
            int t_dist = 0;
            for(int i=0;i< home.size();i++) {
                int dist = Integer.MAX_VALUE;
                point_Chicken h = home.get(i);
                for(int j=0;j<m;j++) {
                    point_Chicken c = chicken[j];
                    dist = Math.min(dist, (Math.abs(c.y-h.y)+Math.abs(c.x-h.x)));
                }
                t_dist+=dist;
            }
            min = Math.min(min, t_dist);

            for(int i=0;i<n;i++) {
                for(int j=0;j<n;j++) {
//                    System.out.print(new_map[i][j]+" ");
                    new_map[i][j] = init_map[i][j];
                }
//                System.out.println();
            }
//            System.out.println();

            return;
        }
        for(int i=num+1;i<chickenList.size();i++) {
            chicken[count] = chickenList.get(i);
            combin(count+1, i, chicken);
            chicken[count] = null;
        }
    }
}
