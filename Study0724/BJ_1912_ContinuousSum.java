package Study0724;

import java.util.Scanner;

public class BJ_1912_ContinuousSum {
    static int n;
    static int[] d;
    public static void main(String[] args) {
        Scanner scan = new Scanner(System.in);
        n = scan.nextInt(); scan.nextLine();
        String[] arr = new String[n];
        d = new int[n];
        arr = scan.nextLine().split(" ");
        for(int i=0;i<n;i++) {
            d[i] = Integer.parseInt(arr[i]);
        }
        System.out.println(DP());
//        for(int i=0;i<n;i++) {
//            System.out.print(d[i]+" ");
//        }
    }
    public static int DP() {
        for(int i=1;i<n;i++) {
            d[i] = Max(d[i-1]+d[i], d[i]);
        }
        int max = -1000;
        for(int i=0;i<n;i++) {
            if(max<d[i]) {
                max = d[i];
            }
        }
        return max;
    }
    public static int Max(int a, int b) {
        return a>b? a : b;
    }
}
