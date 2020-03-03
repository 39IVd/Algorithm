package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class Partition {
    static int n;
    static ArrayList<Integer> dp[];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        dp = new ArrayList[(int)Math.pow(2, (n-1))];


    }
//    public static int partition(int n) {
//        if(n==1) {
//            return 1;
//        }
//        for(int i=1;i<n;i++) {
//
//        }
//    }
}
