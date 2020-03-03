package Simulation;

import java.util.Scanner;

public class BJ_3006_TurboSort {
    static int n;
    static int[] arr;
    static int[] res;
    static int[][] count = new int[100000][2];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        arr = new int[100000];
        res = new int[100000];
        int[] visited = new int[100000];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        int minN = 1, maxN = n;
        boolean odd = true;
        for(int level=0;level<n;level++) {
            if(odd) {
                if(arr[level]==minN) {
                    for(int i=0;i<n;i++) {
                        if(i<level) {
                            count[i][1]++;
                        }
                        else if(i>level) {
                            count[i][0]++;
                        }
                    }
                    minN++;
                }
            }
            else {
                if(arr[level]==maxN) {
                    for(int i=0;i<n;i++) {
                        if(i<level) {
                            count[i][1]++;
                        }
                        else if(i>level) {
                            count[i][0]++;
                        }
                    }
                    maxN--;
                }
            }
            odd = !odd;
        }
        for(int i=0;i<2;i++) {
            for(int j=0;j<n;j++) {
                System.out.print(count[j][i]+" ");
            }
            System.out.println();
        }
    }
}
