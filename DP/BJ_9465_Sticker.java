package DP;

import java.util.ArrayList;
import java.util.Scanner;

public class BJ_9465_Sticker {
    static int T;
    static int[] N;
    static ArrayList<int[][]> list = new ArrayList<>();
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        T = scan.nextInt();
        N = new int[T];
        for(int i=0;i<T;i++) {
            N[i] = scan.nextInt();
            int[][] stickers = new int[2][N[i]+1];
            stickers[0][0] = stickers[1][0] = 0;
            for(int j=0;j<2;j++) {
                for(int k=1;k<=N[i];k++) {
                    stickers[j][k] = scan.nextInt();
                }
            }
            list.add(stickers);
        }
        DP();
//        for(int i=0;i<list.size();i++) {
//            for(int j=0;j<2;j++) {
//                for(int k=0;k<=N[i];k++) {
//                    System.out.print(list.get(i)[j][k]+" ");
//                }
//                System.out.println();
//            }
//            System.out.println();
//        }
    }
    public static void DP() {
        for(int i=0;i<list.size();i++) {
            for(int k=2;k<=N[i];k++) {
                list.get(i)[0][k] += Max(list.get(i)[1][k-1], list.get(i)[1][k-2]);
                list.get(i)[1][k] += Max(list.get(i)[0][k-1], list.get(i)[0][k-2]);
            }
            System.out.println(Max(list.get(i)[0][N[i]], list.get(i)[1][N[i]]));
        }
    }
    public static int Max(int a, int b) {
        return a>b? a : b;
    }
}
