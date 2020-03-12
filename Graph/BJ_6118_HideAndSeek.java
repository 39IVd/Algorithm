package Graph;

//    그래프에서, 1번 노드로부터 거리가 가장 먼 노드의 번호와, 그 거리(거쳐야 하는 edge의 개수), 거리가 같은 다른 노드의 개수를 출력.

import java.util.Scanner;

public class BJ_6118_HideAndSeek {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static int[] d = new int[20001];
    static int[][] e = new int[20001][20001];
    public static void main(String[] args) {
        n = in.nextInt(); m = in.nextInt();
        for(int i=0;i<m;i++) {
            int a = in.nextInt(); int b = in.nextInt();
            e[a][b] = 1; e[b][a] = 1;
        }
        for(int i=1;i<=n;i++) {
            d[i] = Integer.MAX_VALUE;
        }
        d[1]=0;
        int curNode = 1;
        int max = 0;
        while (curNode<n) {
            for(int i=2;i<=n;i++) {
                if(d[i]>1 && e[curNode][i]==1) {
                    d[i] = Math.min(d[i], d[curNode]+1);
                    max = Math.max(max, d[i]);
                }
            }
            curNode++;
        }
//        for(int i=1;i<=n;i++) {
//            System.out.print(d[i]+" ");
//        }
        int cnt = 0, index = 0;
        for(int i=n;i>1;i--) {
            if(d[i]==max) {
                cnt++;
                index = i;
            }
        }
        System.out.println(index+" "+max+" "+cnt);
    }
}
