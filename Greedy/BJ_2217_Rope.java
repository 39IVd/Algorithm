package Greedy;

import java.util.Scanner;

public class BJ_2217_Rope {
    static Scanner in = new Scanner(System.in);
    static int n;
    static int[] rope = new int[100000];
    static int[] visited = new int[100000];
    static int max = 0;
    public static void main(String[] args) {
        n = in.nextInt();
        for(int i=0;i<n;i++) {
            rope[i] = in.nextInt();
        }
        int minIndex = -1;
        int cnt = 0;
        while(cnt<n) {
            int minVal = Integer.MAX_VALUE;
            for(int i=0;i<n;i++) {
                if(minVal>rope[i]&&visited[i]==0) {
                    minVal = rope[i];
                    minIndex = i;
                }
            }
            visited[minIndex] = 1;
            max = Math.max(max, rope[minIndex]*(n-cnt));
//            System.out.println(rope[minIndex]);
            cnt++;
        }

//        for(int i=0;i<n;i++) {
//            for(int j=i+1;j<n;j++) {
//                if(i!=n-1) {
//                    if(rope[i]>rope[j]) {
//                        int tmp = rope[i];
//                        rope[i] = rope[j];
//                        rope[j] = tmp;
//                    }
//                }
//            }
//            max = Math.max(max, rope[i]*(n-i));
//        }

        System.out.println(max);
    }
}
