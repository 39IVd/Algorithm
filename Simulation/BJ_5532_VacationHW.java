package Simulation;

import java.util.Scanner;

public class BJ_5532_VacationHW {
    static int l, a, b, c, d;
    static int k, m, res;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        l = in.nextInt();a=in.nextInt();b=in.nextInt();c=in.nextInt();d=in.nextInt();
        k = a/c; m = b/d;
        if(a%c!=0) {
            k++;
        }
        if(b%d!=0) {
            m++;
        }
        res = l-Math.max(k, m);
        System.out.println(res);
    }
}
