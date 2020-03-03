package Simulation;

import java.util.Scanner;

public class BJ_1057_Tournament {
    static int n;
    static double a, b;
    static int res=-1;
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        n = in.nextInt();
        a=in.nextDouble(); b=in.nextDouble();
        int cnt = 0;
        while(true) {
            a = Math.ceil(a/2);
            b = Math.ceil(b/2);
//            System.out.println(a+", "+b);
            cnt++;
            if(a==b) {
                res = cnt;
                break;
            }
        }
        System.out.println(res);
    }
}
