package Greedy;

import java.util.Arrays;
import java.util.Scanner;

public class BJ_2217_Rope2 {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] rope = new int[100000];
    static int max = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=0;i<n;i++) {
            rope[i] = in.nextInt();
        }
        Arrays.sort(rope, 0, n);
        for(int i=0;i<n;i++) {
//            System.out.println(rope[i]);
            max = Math.max(max, rope[i]*(n-i));
        }
        System.out.println(max);
    }
}
