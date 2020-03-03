package Study0818;

import java.util.Scanner;

public class BJ_17397_FLEX {
    static int n, m;
    static int[] C;
    static int o_dep = 0;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n= in.nextInt(); m = in.nextInt();
        C = new int[n+1];
        for(int i=1;i<=n;i++) {
            C[i] = in.nextInt();
        }
        for(int i=1;i<=n;i++) {
            if(C[i]<C[i-1]) {
                o_dep += Math.pow((C[i-1]-C[i]), 2);
            }
        }
        System.out.println(o_dep);
    }
}
