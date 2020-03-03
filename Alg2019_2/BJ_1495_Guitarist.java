package Alg2019_2;

import java.util.Scanner;

public class BJ_1495_Guitarist {
    static int n, s, m;
    static int[] V;
    static int[][] p;
    static int max = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); s = in.nextInt(); m = in.nextInt();
        V = new int[n+1]; p = new int[n+1][2];
        V[0] = s;
        for(int i=1;i<=n;i++) {
            V[i] = in.nextInt();
        }


        p[0][0] = p[0][1] = s;

        for(int i =0;i<=n;i++) {
            int t1 = p[i-1][0]-V[i]; int t2 = p[i-1][1]-V[i];
            if(t1>=0&&t1<=m) {

            }
            if(t1>=0&&t1<=m) {
                p[i][0] = t1;
            }

        }

        if(s+V[1]>=0 && s+V[1]<=m) {
            p[1][0] = s+V[1];
        }
        if(s-V[1]>=0 && s-V[1]<=m) {
            p[1][0] = s-V[1];
        }
//        for(int i=2;i<n;i++) {
//            if (p[i-1][0]!=-1) {
//                if((p[i-1][0]+V[i]+V[i+1]>=0 &&p[i-1][0]+V[i]+V[i+1]<=m)
//                        ||(p[i-1][0]+V[i]-V[i+1]>=0 &&p[i-1][0]+V[i]-V[i+1]<=m)) {
//                    p[i][0] = p[i-1][0]+V[i];
//                }
//                if((p[i-1][0]-V[i]+V[i+1]>=0 &&p[i-1][0]-V[i]+V[i+1]<=m)
//                        ||(p[i-1][0]-V[i]-V[i+1]>=0 &&p[i-1][0]-V[i]-V[i+1]<=m)) {
//                    p[i][0] = p[i-1][0]-V[i];
//                }
//            }
//            if (p[i-1][1]!=-1) {
//                if((p[i-1][1]+V[i]+V[i+1]>=0 &&p[i-1][1]+V[i]+V[i+1]<=m)
//                        ||(p[i-1][1]+V[i]-V[i+1]>=0 &&p[i-1][1]+V[i]-V[i+1]<=m)) {
//                    p[i][1] = p[i-1][1]+V[i];
//                }
//                if((p[i-1][1]-V[i]+V[i+1]>=0 &&p[i-1][1]-V[i]+V[i+1]<=m)
//                        ||(p[i-1][1]-V[i]-V[i+1]>=0 &&p[i-1][1]-V[i]-V[i+1]<=m)) {
//                    p[i][1] = p[i-1][1]-V[i];
//                }
//            }
//        }
        for(int i=0;i<2;i++) {
            for(int j=0;j<=n;j++) {
                System.out.print(p[j][i]+" ");
            }
            System.out.println();
        }
        max = Math.max(p[n][0], p[n][1]);
        System.out.println(max);
    }
}
