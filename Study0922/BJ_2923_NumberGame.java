package Study0922;

import java.util.Scanner;

public class BJ_2923_NumberGame {
    static int n;
    static int[] a, b, res;
    static int mina = 100, minb = 100;
    static int maxa = -1, maxb = -1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a = new int[n+1]; b = new int[n+1]; res = new int[n+1];
        for(int i=1;i<=n;i++) {
            a[i] = in.nextInt(); b[i] = in.nextInt();
            maxa = Math.max(maxa, a[i]);
            maxb = Math.max(maxb, b[i]);
            mina = Math.min(mina, a[i]);
            minb = Math.min(minb, b[i]);
            if(maxa>maxb) {
                res[i] = maxa+minb;
            }
            else if(maxb>maxa) {
                res[i] = maxb+mina;
            }
            else if(maxa==maxb) {
                res[i] = Math.max(maxa+minb, maxb+mina);
            }
        }
        for(int i=1;i<=n;i++) {
            System.out.println(res[i]);
        }
    }
}
