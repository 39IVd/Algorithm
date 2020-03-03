package BackTracking;

import java.util.Scanner;

public class BJ_2023_WeirdPrimeNumber {
    static Scanner in = new Scanner(System.in);
    static int n;

    public static void main(String[] args) {
        n = in.nextInt();
        find(1, "2");
        find(1, "3");
        find(1, "5");
        find(1, "7");

    }
    public static void find(int cnt, String s) {
        if(cnt==n) {
            System.out.println(s);
            return;
        }
        for(int i=1;i<=9;i=i+2) {
            boolean prime = true;
            int num = Integer.parseInt(s+i+"");
            int sq = (int)(Math.floor(Math.sqrt(num)));
//            System.out.println(num+"=>"+sq);
            for(int j=3;j<=sq;j++) {
                if(num%j==0) {
                    prime =false;
                    break;
                }
            }
            if(prime) find(cnt+1, num+"");

        }
    }
}
