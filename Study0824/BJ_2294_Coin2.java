package Study0824;

import java.util.Scanner;

public class BJ_2294_Coin2 {
    static int n, k;
    static int[] arr;
    static int min = 1000;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt(); k = in.nextInt();
        arr = new int[n];
        for(int i=0;i<n;i++) {
            arr[i] = in.nextInt();
        }
        for(int i=0;i<n-1;i++) {
            for(int j=i;j<n;j++) {
                if(arr[i]<arr[j]) {
                    int tmp = arr[j];
                    arr[j] = arr[i];
                    arr[i] = tmp;
                }
            }
        }
        for(int i=0;i<n;i++) {
//            System.out.println(arr[i]);
            Calculate(0, k, i);
        }
        if(min==1000) { min = -1; }
        System.out.println(min);
    }
    public static void Calculate(int total, int res, int c) {
        if(res/arr[c]>0) {
            total += res / arr[c];
            if (res % arr[c] != 0) {
                for (int i = c + 1; i < n; i++) {
                    Calculate(total + res / arr[c], res % arr[c], i);
                }
            } else {
                min = Math.min(min, total);
            }
        }
    }
}
