package DP;

import java.util.Scanner;

public class Knapsack {
    static int K, N;
    static int items[][];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        N = in.nextInt(); K = in.nextInt();
        items = new int[N][2];
        for(int i=0;i<N;i++) {
            items[i][0] = in.nextInt();
            items[i][1] = in.nextInt();
        }
        System.out.println(getKnapsack(0, K));
    }
    public static int getKnapsack(int pos, int capacity) {
        if(pos==N) {
            return 0;
        }
        int ret = 0;
        if(items[pos][0]<=capacity) {
            // 가져감
            ret = getKnapsack(pos+1, capacity-items[pos][0])
            +items[pos][1];

            // 안가져감
        }
        ret = Math.max(ret, getKnapsack(pos+1, capacity));
        return ret;
    }
}
