package Study0807;

import java.util.Scanner;

public class BJ_10265_MT {
    static int n, k;
    static int[] conn;
    static int[] visit;
    static int max = 0, tmp = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt();
        conn = new int[n+1];
        visit = new int[n+1];
        for(int i=1;i<=n;i++) {
            conn[i] = in.nextInt();
        }
        System.out.println("K:"+k);
        for(int i=1;i<=n;i++) {
            initVisit();
            System.out.println(i+" : "+conn[i]);
            tmp = dfs(i);
            if(tmp<=k) {
                max = Math.max(tmp, max);
            }
            tmp = 0;
        }
        System.out.println(max);
    }
    public static int dfs(int st) {
        if(st==conn[st]&&visit[st]!=1) {
            max++;
            visit[st] = 1;
            return 0;
        }
        else if(visit[st]!=1) {
            visit[st] = 1;
            return 1+dfs(conn[st]);
        }
        else {
            return 0;
        }
    }
    public static void initVisit() {
        for(int i=1;i<=n;i++) {
            visit[i] = 0;
        }
    }
}
