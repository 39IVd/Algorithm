package BruteForce;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

class point_Sur {
    int y, x, d;
    public point_Sur(int y, int x, int d) {
        this.y=y;
        this.x=x;
        this.d=d;
    }
}

public class BJ_1563_Survailence {
    static int n, m;
    static int[][] init_map = new int[10][10];
    static int[][] new_map = new int[10][10];

    static int[] dx = {-1, 0, 1, 0, -1, 0};
    static int[] dy = {0, -1, 0, 1, 0, -1};
//    상 좌 하 우
    static List<point_Sur> pos_cctv = new LinkedList<>();
    static List<point_Sur> cctv = new LinkedList<>();
    static int min = Integer.MAX_VALUE;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
                init_map[i][j] = in.nextInt();
                new_map[i][j] = init_map[i][j];
                if(init_map[i][j]!=0&&init_map[i][j]!=6) {
                    pos_cctv.add(new point_Sur(i,j,-1));
                }
            }
        }
        comb(0, -1, init_map, cctv);
        System.out.println(min);
    }
    public static void comb(int count, int num, int[][] map, List<point_Sur> cctv) {
        if(count== pos_cctv.size()) {
//            System.out.println();
//            for(int i=0;i<cctv.size();i++) {
//                point_Sur c = cctv.get(i);
//                System.out.println("cctv : "+c.y+","+c.x+" => "+c.d);
//            }
//            System.out.println();
            surv(cctv);
            return;
        }
        for(int i = num+1; i< pos_cctv.size(); i++) {
            point_Sur cc = pos_cctv.get(i);
            switch (map[cc.y][cc.x]) {
                case 1:
                    for(int d=0;d<4;d++) {
                        List<point_Sur> new_cctv = new LinkedList<>();
                        for(int j=0;j<cctv.size();j++) {
                            new_cctv.add(cctv.get(j));
                        }
                        new_cctv.add(new point_Sur(cc.y, cc.x, d));
                        comb(count+1, i, map, new_cctv);
                    }
                    break;
                case 2:
                    for(int d=0;d<2;d++) {
                        List<point_Sur> new_cctv = new LinkedList<>();
                        for(int j=0;j<cctv.size();j++) {
                            new_cctv.add(cctv.get(j));
                        }
                        new_cctv.add(new point_Sur(cc.y, cc.x, d));
                        new_cctv.add(new point_Sur(cc.y, cc.x, d+2));
                        comb(count+1, i, map, new_cctv);
                    }
                    break;
                case 3:
                    for(int d=0;d<4;d++) {
                        List<point_Sur> new_cctv = new LinkedList<>();
                        for(int j=0;j<cctv.size();j++) {
                            new_cctv.add(cctv.get(j));
                        }
                        new_cctv.add(new point_Sur(cc.y, cc.x, d));
                        new_cctv.add(new point_Sur(cc.y, cc.x, d+1));
                        comb(count+1, i, map, new_cctv);
                    }
                    break;
                case 4:
                    for(int d=0;d<4;d++) {
                        List<point_Sur> new_cctv = new LinkedList<>();
                        for(int j=0;j<cctv.size();j++) {
                            new_cctv.add(cctv.get(j));
                        }
                        new_cctv.add(new point_Sur(cc.y, cc.x, d));
                        new_cctv.add(new point_Sur(cc.y, cc.x, d+1));
                        new_cctv.add(new point_Sur(cc.y, cc.x, d+2));
                        comb(count+1, i, map, new_cctv);
                    }
                    break;
                case 5:
                    List<point_Sur> new_cctv = new LinkedList<>();
                    for(int j=0;j<cctv.size();j++) {
                        new_cctv.add(cctv.get(j));
                    }
                    new_cctv.add(new point_Sur(cc.y, cc.x, 0));
                    new_cctv.add(new point_Sur(cc.y, cc.x, 1));
                    new_cctv.add(new point_Sur(cc.y, cc.x, 2));
                    new_cctv.add(new point_Sur(cc.y, cc.x, 3));
                    comb(count+1, i, map, new_cctv);
                    break;
            }
        }
    }
    public static void surv(List<point_Sur> cctv) {
        for(int i=0;i<cctv.size();i++) {
            point_Sur curr = cctv.get(i);
            int cy = curr.y; int cx = curr.x; int cd = curr.d;
            while (true) {
                int ny = cy+dy[cd];
                int nx = cx+dx[cd];
                if(ny<0||ny>=n||nx<0||nx>=m) {
                    break;
                }
                if(new_map[ny][nx]==6) {
                    break;
                }
                else if(new_map[ny][nx]==0) {
                    new_map[ny][nx] = 9;
                }
                cy = ny; cx = nx;
            }

        }

        int safe = 0;
        for(int i=0;i<n;i++) {
            for(int j=0;j<m;j++) {
//                System.out.print(new_map[i][j]+" ");
                if(new_map[i][j]==0) {
                    safe++;
                }
                new_map[i][j] = init_map[i][j];
            }
//            System.out.println();
        }
//        System.out.println();
        min = Math.min(min, safe);
    }
}
