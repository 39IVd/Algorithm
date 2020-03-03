package Simulation;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_1563_Survailence {
    static int n, m;
    static int[][] map = new int[10][10];
    static int[] dx = {-1, 0, 1, 0};
    static int[] dy = {0, -1, 0, 1};
//    상 좌 하 우
    static int tsurv =0;
    static int cc = 0;
    static int[][] omap = new int[10][10];
    static int res = 1000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            String[] s = in.nextLine().split(" ");
            for(int j=0;j<m;j++) {
                map[i][j] =  Integer.parseInt(s[j]);
                if(map[i][j]!=0) {
                    cc++;
                }
            }
        }
        System.out.println("cc : "+cc);
        dfs(0, 0, 0);
        System.out.println(n*m-tsurv-cc);

        System.out.println(res);
    }
    public static void dfs(int y, int x, int surv) {
        System.out.println("surv : "+surv);
        for(int i=y;i<n;i++) {
            for(int j=x;j<=m;j++) {
                if(i==n-1&&j==m) {
                    tsurv = Math.max(tsurv, surv);
                    System.out.println("tsurv : "+tsurv);
                    System.out.println();
                    int r = 0;
                    for(int k=0;k<n;k++) {
                        for(int l=0;l<m;l++) {
                            if(map[k][l]==0) {
                                r++;
                            }
                            System.out.print(map[k][l]+" ");
                        }
                        System.out.println();
                    }
                    System.out.println();
                    res = Math.min(res, r);
                    return;
                }

                if(map[i][j]!=0&&map[i][j]!=6&&map[i][j]!=9) {
                    for(int k=0;k<n;k++) {
                        for(int l=0;l<m;l++) {
                            omap[k][l] = map[k][l];
                        }
                    }
                    System.out.println("cctv => "+i+", "+j+" : "+surv);
                    List<Integer> dir = new LinkedList<>();
                    int s = 0;
                    switch (map[i][j]) {
                        case 1:
                            dir.add(1);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(2);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(3);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1,surv+ s);
                            initmap();


                            dir.add(0);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            break;
                        case 2:
                            dir.add(1); dir.add(3);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(2); dir.add(0);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            break;
                        case 3:
                            dir.add(0);dir.add(1);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1,surv+ s);
                            initmap();

                            dir.add(1);dir.add(2);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(2);dir.add(3);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1,surv+ s);
                            initmap();

                            dir.add(3);dir.add(0);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            break;
                        case 4:
                            dir.add(0);dir.add(1);dir.add(3);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(1);dir.add(0);dir.add(2);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(2);dir.add(1);dir.add(3);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            dir.add(3);dir.add(0);dir.add(2);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            break;
                        case 5:
                            dir.add(3);dir.add(0);dir.add(2);dir.add(1);
                            s=find(i, j, dir);
                            dir.clear();
                            dfs(i, j+1, surv+s);
                            initmap();

                            break;
                    }

                }
            }
        }



    }
    public static int find(int y, int x, List<Integer> dir) {
        int surv =0; // 감시한 개수
        for(int i=0;i<dir.size();i++) {
            int d = dir.get(i);
            int ny = y ,nx = x;
            while(true) {
                ny = ny+dy[d];
                nx = nx+dx[d];
                if(!(ny>=0&&ny<=n-1&&nx>=0&&nx<=m-1)) {
                    break;
                }
                else {
                    if(map[ny][nx]==6) {
                        break;
                    }
                    else if(map[ny][nx]==0) {
                        System.out.println("ny : "+ny+", nx : "+nx);
                        map[ny][nx] = 9;
                        surv++;
                    }
                }
            }
        }
        return surv;
    }
    public static void initmap() {
        for(int k=0;k<n;k++) {
            for(int l=0;l<m;l++) {
                map[k][l] = omap[k][l];
            }
        }
    }
}
