package Greedy;

import java.util.Scanner;

public class BJ_1969_DNA {
    static Scanner in = new Scanner(System.in);
    static int n, m;
    static char[][] dna = new char[1000][50];
//    static int[][] diff = new int[1000][1000];
    static int[] diff = new int[1000];
    public static void main(String[] args) {
        n = in.nextInt(); m = in.nextInt();
        in.nextLine();
        for(int i=0;i<n;i++) {
            dna[i] = in.nextLine().toCharArray();
        }
        int min = Integer.MAX_VALUE;
        for(int i=0;i<n;i++) {
            if(i!=n-1) {
                for(int j=i+1;j<n;j++) {
                    int diff2 = 0;
                    for(int k=0;k<m;k++) {
                        if(dna[i][k]!=dna[j][k]) {
                            diff2++;
                        }
                    }
                    diff[i] += diff2; diff[j] += diff2;
                    System.out.println(i+","+j+"=>"+diff2);
                    if(diff[i]>min) {
                        break;
                    }
                }
            }
            System.out.println(i+" : "+diff[i]);
            min = Math.min(min, diff[i]);
        }
        System.out.println(min);
    }
}
