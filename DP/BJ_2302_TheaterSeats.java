package DP;

import java.util.LinkedList;
import java.util.List;
import java.util.Scanner;

public class BJ_2302_TheaterSeats {
    static int n, m;
    static int[] vip = new int[100];
    static int[] dp = new int[100];
    static List<Integer> seat = new LinkedList<>();
    static int total = 1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); m = in.nextInt();
        int init = 1;
        for(int i=0;i<m;i++) {
            vip[i] = in.nextInt();
            seat.add(vip[i]-init);
            init = vip[i]+1;
        }
        seat.add(n-init+1);
//        for(int i=0;i<seat.size();i++) {
//            System.out.print(seat.get(i)+" ");
//        }

        dp[0] = 1;dp[1] = 1; dp[2] = 2;
        for(int i=3;i<50;i++) {
            dp[i] = dp[i-1]+dp[i-2];
        }
//        for(int i=1;i<10;i++) {
//            System.out.print(dp[i]+" ");
//        }
//        System.out.println();
        for(int i=0;i<seat.size();i++) {
            total *= dp[seat.get(i)];
        }
        System.out.println(total);
    }
}
