package DP;
// Longest Increasing Subsequence
// 최장 증가 수열

// 수열 A가 주어졌을 때, 그 수열의 증가 부분 수열 중에서 합이 가장 큰 것을 구하는 프로그램을 작성하시오.
// 예를 들어, 수열 A = {1, 100, 2, 50, 60, 3, 5, 6, 7, 8} 인 경우에
// 합이 가장 큰 증가 부분 수열은 {1, 2, 50, 60} 이고, 합은 113이다.


import java.util.Scanner;

public class LIS {
    static int n;
    static int[] arr;
    static int[] dp;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[n]; dp = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        System.out.println(calLIS());
    }
    public static int calLIS() {
        int max = 0;
        dp[0] = arr[0];
        for(int i=1;i<n;i++) {
            dp[i] = 1;
            for(int j=0;j<i;j++) {
                if(arr[j]<arr[i] && dp[j]+arr[i]>dp[i]) {
                    dp[i] = dp[j]+arr[i];
                }
            }
            max = Math.max(max, dp[i]);
        }
        return max;
    }
}
