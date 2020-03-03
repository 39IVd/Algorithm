package ALPSContest2019;

//Runtime Error Occurs

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.StringTokenizer;

public class D_ConnectBridge2 {
    static int n, m, k;
    static int[] s;
    static int[] parent;
    static int[] dist;
    static int MAX_VALUE = 1000000;

    public static void main(String[] args) throws Exception {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        StringTokenizer st = new StringTokenizer(br.readLine());
        n = Integer.parseInt(st.nextToken()); m = Integer.parseInt(st.nextToken()); k = Integer.parseInt(st.nextToken());
        st = new StringTokenizer(br.readLine());
        parent = new int[n+1]; s = new int[n+1]; dist = new int[n+1];
        for(int i=1;i<=n;i++) {
            s[i] = Integer.parseInt(st.nextToken());
            parent[i] = i-1;
        }
        parent[1] = n;
        for(int i=0;i<m;i++) {
            st = new StringTokenizer(br.readLine());
            st.nextToken(); int t2 =Integer.parseInt(st.nextToken());
            parent[t2] = t2;
        }
        int total=0;
        Arrays.fill(dist, MAX_VALUE);
        for(int i=1;i<=n;i++) {
            int p = parent[i];
            dist[p] = Math.min(dist[p], s[i]);
        }
        for(int i=1;i<=n;i++) {
            if(dist[i]!=MAX_VALUE) {
                total+=dist[i];
            }
        }
        String res = total<=k? "YES":"NO";
        System.out.println(res);
    }
}
