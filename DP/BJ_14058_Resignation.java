//package DP;
//
//import java.util.Scanner;
//
//class Job {
//    int price, day;
//    public Job(int price, int day) {
//        this.price = price;
//        this.day = day;
//    }
//}
//
//public class BJ_14058_Resignation {
//    static int n;
//    static int[] time = new int[15];
//    static int[] price = new int[15];
//    static int[][] dp = new int[15][2];
//    static Job[][] jobs = new Job[15][2];
//    public static void main(String[] args) {
//        Scanner in = new Scanner(System.in);
//        n =in.nextInt();
//        for(int i=1;i<=n;i++) {
//            time[i] = in.nextInt();
//            price[i] = in.nextInt();
//        }
//        jobs[0][0] = new Job(0, 1);
//        jobs[0][1] = new Job(0, 1);
//        for(int i=0;i<=n;i++) {
//            int sday = jobs[i][0].day;
//            int sprice = jobs[i][0].price;
//            int nextDay = i+sday;
//            jobs[nextDay][0]  = new Job(sprice+price[nextDay], nextDay+time[nextDay]);
//
//            int uday = jobs[i][1].day;
//            int uprice = jobs[i][0].price;
//            nextDay = i+uday;
//            jobs[nextDay][1] = new Job()
//
//        }
////        dp[0][0] = 10; dp[0][1] = 0;
////        for(int i=1;i<n;i++) {
////            dp[i][0] =
////        }
//
//    }
//    public static void func(int price, int day) {
//
//    }
//}
