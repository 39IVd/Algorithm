package BruteForce;

import java.util.Scanner;

public class BJ_14888_PutTheOperator {
    static int n;
    static int[] a = new int[20];
    static int[] operator = new int[20];
//    plus, minus, multiple, divide
    static int max = Integer.MIN_VALUE, min = Integer.MAX_VALUE;
    static int[] visitied = new int[20];
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        for(int i=0;i<n;i++) {
            a[i] = in.nextInt();
        }
        int ind = 0;
        for(int i=0;i<4;i++) {
            int num = in.nextInt();
            for(int j=0;j<num;j++) {
                operator[ind] = i;
                ind++;
            }
        }
//        for(int i=0;i<n-1;i++) {
//            System.out.print(operator[i]+" ");
//        }
//        System.out.println();

        permu(0, a[0]);
        System.out.println(max);
        System.out.println(min);

    }
    public static void permu(int count, int res) {
        if(count==n-1) {
            min = Math.min(min, res);
            max = Math.max(max, res);
            return;
        }
        int tmp = res;
        for(int i=0;i<n-1;i++) {
            res = tmp;
            if(visitied[i]!=1) {
                visitied[i] = 1;
                switch (operator[i]) {
                    case 0:
                        res += a[count+1];
                        break;
                    case 1:
                        res -= a[count+1];
                        break;
                    case 2:
                        res *= a[count+1];
                        break;
                    case 3:
                        res /= a[count+1];
                        break;
                }
                permu(count+1, res);
                visitied[i] = 0;
            }
        }
    }
}
