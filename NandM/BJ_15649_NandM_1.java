package NandM;

import java.util.Scanner;

public class BJ_15649_NandM_1 {
    static int N, M;
    static int[][] arr;
    static int[] used;
    static String str = "";
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        N = scan.nextInt(); M = scan.nextInt();
        int count = factorial(N)/factorial(N-M);
        arr = new int[count][M];
        used = new int[N+1];
//        System.out.println(factorial(N)/factorial(N-M));
        recursive(0, 0);
    }
    public static void recursive(int curr, int dist) {
        if(dist==M) {
            System.out.println(str+"\n");
            return;
        }
        else {
            for(int i=1;i<=N;i++) {
                if(used[i]!=1) {
                    used[i] = 1;
                    str += i+" ";
                    recursive(i, dist+1);
                    used[i] = 0;
                }

            }
        }
    }
    public static int factorial(int n) {
        int num = 1;
        while(n>0) {
            num = num*(n);
            n--;
        }
        return num;
    }
}
