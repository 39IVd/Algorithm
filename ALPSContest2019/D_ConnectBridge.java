package ALPSContest2019;

import java.util.Scanner;

public class D_ConnectBridge {
    static int n, m, k;
    static int[] s;
    static int[] parent;
    static int[] dist;
    static int max = 1000000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt(); k = in.nextInt();
        s = new int[n+1]; parent = new int[n+1]; dist = new int[n+1];
        for(int i=1;i<=n;i++) {
            s[i] = in.nextInt();
            parent[i] = i-1;
            dist[i] = max;
        }
        parent[1] = n;
        for(int k=0;k<m;k++) {
            in.nextInt();
            int j = in.nextInt();
            parent[j] = j;
        }
//        for(int i=1;i<=n;i++) {
//            System.out.println(parent[i]);
//        }
        int total = 0;
        for(int i=1;i<=n;i++) {
            int p = parent[i];
            dist[p] = Math.min(dist[p], s[i]);
        }
        for(int i=1;i<=n;i++) {
            if(dist[i]!=max) {
                total+=dist[i];
            }
        }
//        for(int i=1;i<=n;i++) {
//            int min = 10000;
//            boolean isp = false;
//            for(int j=1;j<=n;j++) {
//                if(parent[j]==i) {
//                    isp = true;
//                    min = Math.min(min, s[j]);
//                }
//            }
//            if(isp) {
//                total += min;
//            }
//        }
        if(total<=k) {
            System.out.println("YES");
        }
        else {
            System.out.println("NO");
        }
//        System.out.println(total);
    }
}
